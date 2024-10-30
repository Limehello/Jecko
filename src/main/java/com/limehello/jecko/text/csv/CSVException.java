package com.limehello.jecko.text.csv;

public class CSVException extends IOException {
  public CSVException(String message) {
    super(message);
  }
  public CSVException(String message, Throwable e) {
    super(message, e);
  }
}
