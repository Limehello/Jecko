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
        tokens.add(input.charAt(position), CSVTokenType.WHITESPACE);
        position++;
      } else if (current Char)
    }
  }
}
