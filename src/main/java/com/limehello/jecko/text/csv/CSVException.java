package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVExceptionType;
import java.io.IOException;

public class CSVException extends IOException {
  private int position;
  public CSVException(CSVExceptionType errorType, String defaultMsg, int position) {
    this.position = position;
    super(buildMessage(errorType, position, defaultMsg));
  }
  public String buildMessage(CSVExceptionType type, int position, String defaultMsg) {
    switch (type) {
      case "UNCLOSED_QUOTES":
        return "Unclosed quotes at position: " + position;
      case "SPACES_BETWEEN":
        return "Spaces within unquoted value at position: " + position;
      case "INVALID_CHARACTER"
        return "Invalid character from unavailable charset at position: " + position;
      default:
        return defaultMsg;
    }
  }
  public int getPosition() {
    return position;
  }
}
