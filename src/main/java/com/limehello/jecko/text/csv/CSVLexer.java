package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;

public class CSVLexer {
  private String input;
  private int position;
  public CSVLexer(String input) {
    this.input = input;
    this.position = 0;
  }
  public List<String> tokenize() {
    List<CSVToken> tokens = new ArrayList<>();
    tokens.clear();
    this.position = 0;
    while (position < input.length()) {
      char currentChar = input.charAt(position);
      if (Character.isWhitespace(currentChar)) {
        position++;
      } else if (currentChar == ',') {
        tokens.add(currentChar, CSVTokenType.COMMA);
        position++;
      } else {
        
      }
    }
  }
}
