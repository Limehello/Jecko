package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import com.limehello.jecko.text.csv.CSVException;
import java.util.ArrayList;
import java.util.List;

public class CSVLexer {
  private String input;
  private int position;
  private char currentChar;
  private List<CSVToken> tokens;
  private boolean ignoreWhitespace;
  
  public CSVLexer() {
    tokens = new ArrayList<>();
    ignoreWhitespace= true;
  }
  public List<String> tokenize() throws CSVException {
    
  }
  public void nextToken() {
    
  }
  public boolean hasMoreTokens() {
    return position < input.length();
  }
  public void skipWhitespace() {
    while (hasMoreTokens() && Character.isWhitespace(currentChar)) {
      position++;
    }
  }
}
