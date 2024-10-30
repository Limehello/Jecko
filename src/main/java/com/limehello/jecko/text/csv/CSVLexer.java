package com.limehello.jecko.text.csv;

import com.limehello.jecko.text.csv.CSVToken;
import com.limehello.jecko.text.csv.CSVTokenType;
import java.util.ArrayList;
import java.util.List;

public class CSVLexer {
    private String input;
    private int position;
    public CSVLexer(String input) {
        this.input = input;
        this.position = 0;
    }
    public List<CSVToken> tokenize() {
        List<CSVToken> tokens = new ArrayList<>();
        this.position = 0;

        while (position < input.length()) {
            char currentChar = input.charAt(position);

            if (Character.isWhitespace(currentChar)) {
                position++; // Ignore whitespace
            } else if (currentChar == ',') {
                tokens.add(new CSVToken(String.valueOf(currentChar), CSVTokenType.COMMA));
                position++;
            } else if (currentChar == '\n') {
                tokens.add(new CSVToken(String.valueOf(currentChar), CSVTokenType.NEWLINE));
                position++;
            } else if (currentChar == '"') {
                position++; // Skip the quote
                StringBuilder tokenValue = new StringBuilder();
                while (position < input.length() && input.charAt(position) != '"') {
                    tokenValue.append(input.charAt(position));
                    position++;
                }
                if (position < input.length()) {
                    position++; // Skip the closing quote
                }
                tokens.add(new CSVToken(tokenValue.toString(), CSVTokenType.TOKEN));
            } else {
                StringBuilder tokenValue = new StringBuilder();
                while (position < input.length() && !Character.isWhitespace(input.charAt(position)) 
                       && input.charAt(position) != ',' && input.charAt(position) != '\n' && input.charAt(position) != '"') {
                    tokenValue.append(input.charAt(position));
                    position++;
                }
                tokens.add(new CSVToken(tokenValue.toString(), CSVTokenType.TOKEN));
            }
        }
        return tokens;
    }
}
