package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVTokenType;

public class CSVToken {
  private char value;
  private CSVTokenType type;
  public CSVToken(char value, CSVTokenType type) {
    this.value = value;
    this.type = type;
  }
  public CSVTokenType getType() {
    return CSVTokenType;
  }
  public String getValue() {
    return value;
  }
  @Override
  public String toString() {
    return "CSVToken(type=" + 
  }
}
