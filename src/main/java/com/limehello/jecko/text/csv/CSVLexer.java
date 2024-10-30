package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import com.limehello.jecko.text.csv.CSVException;
import java.util.List;
import java.util.ArrayList;

public class CSVLexer {
  private String input;
  private int position;
  private List<CSVToken> tokens;
  public CSVLexer() {
    tokens = new ArrayList<>();
  }
  public List<CSVToken> tokenize(String input) throws CSVException {
    this.input = input;
    this.position = 0;
    tokens.clear();
    while (hasMoreTokens()) {
      skipWhitespace();
      CSVToken token = nextToken();
      if (token != null) {
        tokens.add(token);
      }
    }
    return tokens;
  }
  public void skipWhitespace() {
    while (hasMoreTokens() && Character.isWhitespace(input.charAt(position))) {
      position++;
    }
  }
  public boolean hasMoreTokens() {
    return position < input.length();
  }
  public CSVToken nextToken() throws CSVException {
    if (position >= input.length()) {
      return null;
    }
    char currentChar = input.charAt(position);
    if (currentChar == ',') {
      position++;
      return new CSVToken(",", CSVTokenType.COMMA);
    } else if (currentChar == '"') {
      return buildQuotedToken();
    } else {
      return buildUnquotedToken();
    }
  }
  private CSVToken buildQuotedToken() throws CSVException {
    StringBuilder value = new StringBuilder();
    position++;
    while (hasMoreTokens()) {
      char currentChar = input.charAt(position);
      if (currentChar == '"') {
        if (position + 1 < input.length() && input.charAt(position + 1) == '"') {
          value.append('"');
          position += 2;
        } else {
          position++;
          if (hasMoreTokens() && input.charAt(position) != ',' && !Character.isWhitespace(input.charAt(position))) {
            throw new CSVException(
                        "Unexpected character after closing quote at position: " + position
                    );
          }
          break;
        }
      } else {
        value.append(currentChar);
        position++;
      }
    }
    if (position >= input.length() || input.charAt(position - 1) != '"') {
      throw new CSVException("Unclosed quoted value at position: " + (position - 1));
    }
    return new CSVToken(value.toString(), CSVTokenType.QUOTED_VALUE);
  }
  private CSVToken buildUnquotedToken() throws CSVException {
    StringBuilder value = new StringBuilder();
    while (hasMoreTokens()) {
      char currentChar = input.charAt(position);
      if (currentChar == ',' || currentChar == '\n' || currentChar == '\r') {
        break;
      }
      if (Character.isWhitespace(currentChar)) {
        throw new CSVException("Invalid whitespace in unquoted value at position: " + position);
      }
      value.append(currentChar);
      position++;
    }
    return new CSVToken(value.toString(), CSVTokenType.UNQUOTED_VALUE);
  }
  public int getPosition() {
    return position;
  }
}
