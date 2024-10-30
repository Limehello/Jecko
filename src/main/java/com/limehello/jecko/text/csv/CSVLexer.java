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
    List<String> tokens = new ArrayList<>();
    tokens.clear();
    this.position = 0;
    for (char ch : this.input.toCharArray()) {
      if (Character.isWhitespace()
    }
  }
}
