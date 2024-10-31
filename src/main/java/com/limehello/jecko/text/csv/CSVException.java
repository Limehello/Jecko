package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVExceptionType;
import java.io.IOException;

public class CSVException extends IOException {
  public CSVException(CSVExceptionType errorType) {
    super(buildMessage());
  }
  public String buildMessage(CSVExceptionType type) {
    switch (type) {
      case "
    }
  }
}
