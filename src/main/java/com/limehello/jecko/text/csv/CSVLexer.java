package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import java.util.List;
import java.util.ArrayList;

public class CSVLexer {
  private String input;
  private int position;
  private List<CSVToken> tokens;
  public CSVLexer() {
    tokens = new ArrayList<>();
  }
  public List<CSVToken> tokenize(String input) {
    this.input = input;
    this.position = 0;
    tokens.clear();
    while (hasMoreTokens()) {
      skipWhitespace();
      CSVToken = nextToken();
    }
  }
  public void skipWhitespace() {
    while (Character.isWhitespace()) {
      position++;
    }
  }
  public boolean hasMoreTokens() {
    return position < input.length();
  }
  public CSVToken nextToken() {
    if (position >= input.length()) {
      return null;
    }
    char currentChar = input.charAt(position);
    if (currentChar == ',') {
      position++;
      return new CSVToken(",", CSVTokenType.COMMA);
    } else if (currentChar == '"') {
      
    } else {
      
    }
  }
  private CSVToken buildQuotedToken() {
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
          break;
        }
      } else {
        value.append(currentChar);
        position++;
      }
    }
    return new CSVToken(value.toString(), CSVTokenType.QUOTED_VALUE);
  }
  public CSVToken buildUnquotedToken() {
    StringBuilder value = new StringBuilder();
    while (hasMoreTokens()) {
      char currentChar = input.charAt(position);
      if (currentChar == ',' || currentChar == '\n' || currentChar == '\r') {
        break;
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
