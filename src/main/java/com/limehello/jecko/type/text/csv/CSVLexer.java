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
        insideQuotes = !insideQuotes; // Toggle insideQuotes flag
        position++;
        continue;
      }
      if (currentChar == ',') {
        if (insideQuotes) {
          currentToken.append(currentChar);
        } else {
          if (currentToken.length() > 0) {
            tokens.add(createToken(currentToken.toString(), CSVTokenType.QSTRING));
            currentToken.setLength(0);
          }
          tokens.add(new CSVToken(",", CSVTokenType.COMMA));
        }
        position++;
        continue;
      }
      if (currentChar == '\n' || position == input.length() - 1) {
        if (position == input.length() - 1 && currentChar != '\n') {
          currentToken.append(currentChar); // Add last character if not newline
        }
        if (currentToken.length() > 0) {
          tokens.add(createToken(currentToken.toString(), insideQuotes ? CSVTokenType.QSTRING : CSVTokenType.STRING));
          currentToken.setLength(0);
        }
        if (currentChar == '\n') {
          tokens.add(new CSVToken("\\n", CSVTokenType.NEWLINE));
        }
        position++;
        continue;
      }
      if (Character.isWhitespace(currentChar)) {
        position++;
        continue; // Skip whitespace
      }
      currentToken.append(currentChar);
      position++;
    }
    if (currentToken.length() > 0) {
      tokens.add(createToken(currentToken.toString(), insideQuotes ? CSVTokenType.QSTRING : CSVTokenType.STRING));
    }
    return tokens;
  }
  private CSVToken createToken(String value, CSVTokenType type) {
    if (type == CSVTokenType.STRING && value.matches("-?\\d+(\\.\\d+)?")) {
      return new CSVToken(value, CSVTokenType.NUMBER);
    }
    return new CSVToken(value.trim(), type); // Trim to remove leading/trailing spaces
  }
}
