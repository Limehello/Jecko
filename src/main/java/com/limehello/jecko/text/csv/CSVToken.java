package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVTokenType;

public class CSVToken {
  private String value;
  private CSVTokenType type;
  public CSVToken(CSVTokenType type, String value) {
    this.type = type;
    this.value = value;
  }
  public CSVTokenType getType() {
    return type;
  }
  public String getValue() {
    return value;
  }
  @Override
  public String toString() {
    return "CSVToken(type=" + type.toString()
      + ", value=" + value + ")";
  }
}
