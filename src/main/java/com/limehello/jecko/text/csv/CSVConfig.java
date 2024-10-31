package com.limehello.jecko.text.csv;

public class CSVConfig {
  
  private char delimiter = ',';
  private char quoteChar = '"';
  private char escapeChar = '"';
  private boolean ignoreSurroundingSpaces = true;
  
  public char getDelimiter() {
    return delimiter;
  }

  public char getQuoteChar() {
    return quoteChar;
  }

  public char getEscapeChar() {
    return escapeChar;
  }

  public boolean getIgnoreSurroundingSpaces() {
    return ignoreSurroundingSpaces;
  }

  public void setDelimiter(char ch) {
    delimiter = ch;
  }

  public void setQuoteChar(char ch) {
    quoteChar = ch;
  }

  public void setEscapeChar(char ch) {
    escapeChar = ch;
  }

  public void setIgnoreSurroundingSpaces(boolean flag) {
    ignoreSurroundingSpaces = flag;
  }
}
