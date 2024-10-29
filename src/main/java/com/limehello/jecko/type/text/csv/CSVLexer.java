package com.limehello.jecko.type.text.csv;

import java.util.ArrayList;
import java.util.List;
import com.limehello.jecko.type.text.csv.CSVToken;
import com.limehello.jecko.type.text.csv.CSVTokenType;

public class CSVLexer {
  private String input;
  private int position;
  public CSVLexer(String input) {
    this.input = input;
    this.position = 0;
  }
  public List<CSVToken> tokenize() {
    List<CSVToken> tokens = new ArrayList<>();
    StringBuilder currentToken = new StringBuilder();
    CSVTokenType currentType = CSVTokenType.SPACE;
  }
}
