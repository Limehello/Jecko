package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVExceptionType;
import java.io.IOException;

public class CSVException extends IOException {
  public CSVException(CSVExceptionType errorType, int position) {
    super(buildMessage(errorType, position));
  }
  public String buildMessage(CSVExceptionType type, int position) {
    switch (type) {
      case "UNCLOSED_QUOTES":
        return "Unclosed quotes at position: " + position;
      case "SPACES_BETWEEN":
        return "Spaces within unquoted value at position: " + position;
      case "
    }
  }
}
