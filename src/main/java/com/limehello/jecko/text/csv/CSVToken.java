package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVTokenType;

public class CSVToken {
    private String value;
    private CSVTokenType type;
    public CSVToken(String value, CSVTokenType type) {
        this.value = value;
        this.type = type;
    }
    public CSVTokenType getType() {
        return type;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "CSVToken(type=" + type.toString() + ", value=" + value + ")";
    }
}
