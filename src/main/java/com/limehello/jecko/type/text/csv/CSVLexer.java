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
    CSVTokenType currentType = CSVTokenType.SPACE;
    while (position < input.length()) {
      char currentChar = input.charAt(position);
      if (Character.isWhitespace(currentChar)) {
        position++;
        continue;
      }
      if (currentChar == ',') {
        if (currentToken.length() > 0) {
          tokens.add(createToken(currentToken.toString(), currentType));
          currentToken.setLength(0);
        }
        tokens.add(new CSVToken(",", CSVTokenType.COMMA));
        position++;
        continue;
      }
      if (currentChar == '"') {
        position++;
        boolean isEscaped = false;
        while (position < input.length()) {
          currentChar = input.charAt(position);
          if (currentChar == '"' && !isEscaped) {
            if (position + 1 < input.length() && input.charAt(position + 1) == '"') {
              currentToken.append('"');
              isEscaped = true;
              position += 2;
            } else {
              position++;
              break;
            }
          } else {
            currentToken.append(currentChar);
            isEscaped = false;
            position++;
          }
        }
        tokens.add(new CSVToken(currentToken.toString(), CSVTokenType.QSTRING));
        currentToken.setLength(0);
        continue;
      }
      if (Character.isDigit(currentChar) || 
          (currentChar == '-' && position + 1 < input.length() && 
           Character.isDigit(input.charAt(position + 1)))) {
        while (position < input.length() && 
              (Character.isDigit(input.charAt(position)) || input.charAt(position) == '.')) {
          currentToken.append(input.charAt(position));
          position++;
        }
        tokens.add(new CSVToken(currentToken.toString(), CSVTokenType.NUMBER));
        currentToken.setLength(0);
        continue;
      }
      currentToken.append(currentChar);
      currentType = CSVTokenType.STRING;
      position++;
    }
    if (currentToken.length() > 0) {
      tokens.add(createToken(currentToken.toString(), currentType));
    }
    return tokens;
  }
  private CSVToken createToken(String value, CSVTokenType type) {
    if (type == CSVTokenType.STRING && value.matches("-?\\d+(\\.\\d+)?")) {
      return new CSVToken(value, CSVTokenType.NUMBER);
    }
    return new CSVToken(value, type);
  }
}
