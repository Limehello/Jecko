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
    while (hasMoreTokens) {
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
      return new CSVToken();
    }
  }
  public CSVToken buildToken() {
    
  }
  public int getPosition() {
    return position;
  }
}
