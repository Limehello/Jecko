package com.limehello.jecko.text.csv;

import java.io.IOException;

public class CSVException extends IOException {
  public CSVException(String message) {
    super(message);
  }
  public CSVException(String message, Throwable e) {
    super(message, e);
  }
}
