package com.limehello.jecko.text.csv;

import java.util.List;
import java.util.ArrayList;

public class CSVLexer {
  private String input;
  private int position;
  private List<CSVToken> tokens;
  public CSVLexer() {
    tokens = new ArrayList<>();
  }
  public List<CSVRecord> tokenize() {
    tokens.clear();
    while (position < input.length()) {
      
    }
  }
}
