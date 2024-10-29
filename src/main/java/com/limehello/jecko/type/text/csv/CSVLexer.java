package com.limehello.jecko.type.text.csv;

import java.util.ArrayList;
import java.util.List;
import com.limehello.jecko.type.text.csv.CSVToken;
import com.limehello.jecko.type.text.csv.CSVTokenType;

public class CSVLexer {
  private final String input;
  private int position;

  public CSVLexer(String input) {
    this.input = input;
    this.position = 0;
  }

  public List<CSVToken> tokenize() {
    List<CSVToken> tokens = new ArrayList<>();
    StringBuilder currentToken = new StringBuilder();
    boolean insideQuotes = false;

    while (position < input.length()) {
      char currentChar = input.charAt(position);

      if (currentChar == '"') {
        insideQuotes = !insideQuotes;
        position++;
        continue;
      }

      if (currentChar == ',') {
        if (insideQuotes) {
          currentToken.append(currentChar); // Keep commas inside quoted strings
        } else {
          if (currentToken.length() > 0) {
            tokens.add(createToken(currentToken.toString(), insideQuotes ? CSVTokenType.QSTRING : CSVTokenType.STRING));
            currentToken.setLength(0);
          }
          tokens.add(new CSVToken(",", CSVTokenType.COMMA));
        }
        position++;
        continue;
      }

      if (currentChar == '\n') {
        if (currentToken.length() > 0) {
          tokens.add(createToken(currentToken.toString(), insideQuotes ? CSVTokenType.QSTRING : CSVTokenType.STRING));
          currentToken.setLength(0);
        }
        tokens.add(new CSVToken("\\n", CSVTokenType.NEWLINE));
        position++;
        continue;
      }

      if (Character.isWhitespace(currentChar) && !insideQuotes) {
        position++;
        continue; // Skip whitespace characters outside of quotes
      }

      currentToken.append(currentChar); // Accumulate character into the current token
      position++;
    }

    if (currentToken.length() > 0) {
      tokens.add(createToken(currentToken.toString(), insideQuotes ? CSVTokenType.QSTRING : CSVTokenType.STRING));
    }
    return tokens;
  }

  private CSVToken createToken(String value, CSVTokenType type) {
    if (type == CSVTokenType.STRING && value.matches("-?\\d+(\\.\\d+)?")) {
      return new CSVToken(value, CSVTokenType.NUMBER); // Identify numbers correctly
    }
    if (type == CSVTokenType.STRING) {
      return new CSVToken(value.replaceAll("\\s+", ""), CSVTokenType.STRING); // Remove whitespace for string tokens
    }
    return new CSVToken(value, type);
  }
}
