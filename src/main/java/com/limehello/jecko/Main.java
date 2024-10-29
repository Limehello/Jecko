package com.limehello.jecko;

import com.limehello.jecko.type.text.csv.CSVToken;
import com.limehello.jecko.type.text.csv.CSVTokenType;
import com.limehello.jecko.type.text.csv.CSVLexer;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    String csvInput = "\"John Doe\",29,\"New York\",\"He said, \"\"Hello\"\"\",true, \"Extra, comma\"";
    CSVLexer lexer = new CSVLexer(csvInput);
    List<CSVToken> tokens = lexer.tokenize();
    for (CSVToken token : tokens) {
      System.out.println(token);
    }
  }
}
