package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import java.util.List;
import java.util.ArrayList;

public class CSVLexer {
  private String input;
  private int position;
  public CSVLexer(String input) {
    this.input = input;
    this.position = 0;
  }
  public List<String> tokenize() {
    
  }
  public void skipWhitespace() {
    while (Character.isWhitespace()) {
      position++;
    }
  }
  public boolean hasMoreTokens() {
    return position < input.length();
  }
  public char next() {
    return input.charAt(position++);
  }
  public char peek() {
    return input.charAt(position + 1);
  }
  public char getPosition() {
    return position;
  }
}
