package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import java.util.ArrayList;
import java.util.List;

public class CSVRecord {
  private List<CSVToken> tokens;
  public CSVRecord(ArrayList<CSVToken> tokens) {
    this.tokens = tokens;
  }
}
