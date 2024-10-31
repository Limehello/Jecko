package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import com.limehello.jecko.text.csv.CSVException;
import java.util.ArrayList;
import java.util.List;

public class CSVLexer {
  private String input;
  private int position;
  private CSVToken currentToken;
  private List<CSVToken> tokens;
  private boolean ignoreWhitespace;
  
  public CSVLexer() {
    tokens = new ArrayList<>();
    ignoreWhitespace= true;
  }
  public List<String> tokenize(String input) throws CSVException {
    this.input = input;
    this.position = 0;
    this.currentToken = new CSVToken(input.charAt(position), );
  }
  private void nextToken() throws CSVException {
    
  }
  private boolean hasMoreTokens() {
    return position < input.length();
  }
  private void skipWhitespace() {
    while (hasMoreTokens() && Character.isWhitespace(currentChar)) {
      position++;
    }
  }
}
