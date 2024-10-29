package com.limehello.jecko.type.text.csv;

public final class Token {
  enum Type {
    INVALID,
    TOKEN,
    EOF,
    EORECORD,
    COMMENT
  }
}
