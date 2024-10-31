package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import com.limehello.jecko.text.csv.CSVException;
import java.util.ArrayList;
import java.util.List;

public class CSVLexer {
  private String input;
  private int position;
  private List<CSVToken> tokens;
  
  public CSVLexer() {
    tokens = new ArrayList<>();
  }
  public List<String> tokenize(String input) throws CSVException {
    this.input = input;
    this.position = 0;
    while (hasMoreTokens()) {
      skipWhitespace();
      CSVToken token = nextToken();
    }
  }
  private CSVToken nextToken() throws CSVException {
    char currentChar = getCurrentChar();
    char nextChar getNextChar();
    while (hasMoreTokens())
      if (Character.isWhitespace(currentChar)) {
      position++;
    } else if (isCommaChar(currentChar)) {
      position++;
      
      if (nextChar == '"') {
      }
    }
  }
  private char getCurrentChar() {
    return input.charAt(position);
  }
  private char getNextChar() {
    return input.charAt(position + 1);
  }
  private boolean hasMoreTokens() {
    return position < input.length();
  }
  private void skipWhitespace() {
    while (hasMoreTokens() && Character.isWhitespace(currentChar)) {
      position++;
    }
  }
  private static boolean isCommaChar(char ch) {
    return ch == ',';
  }
  private static boolean isQuoteChar(char ch) {
    return ch == '"';
  }
}
