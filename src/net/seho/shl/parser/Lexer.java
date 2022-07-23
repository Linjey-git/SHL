package net.seho.shl.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author _se.ho
 * @create 2022-07-22
 **/

public final class Lexer {

    private static final String OPERATOR_CHARS = "+-*/";
    private static final TokenType[] OPERATORR_TOKENS = {
            TokenType.PLUS, TokenType.MINUS,
            TokenType.STAR, TokenType.SLASH
    };

    private final String input;
    private final int lenght;
    private final List<Token> tokens;

    private int pos;

    public Lexer(String input) {
        this.input = input;
        lenght = input.length();

        tokens = new ArrayList<>();
    }

    public List<Token> tokenize() {
        while (pos < lenght) {
            final char current = peek(0);
            if (Character.isDigit(current)) {
                tokenizeNumber();
            } else if (OPERATOR_CHARS.indexOf(current) != -1) {
                tokenizeOperator();
            } else {
                //символи які не считуємо
                next();
            }
        }
        return tokens;
    }

    private void tokenizeOperator() {
        final int position = OPERATOR_CHARS.indexOf(peek(0));
        addToken(OPERATORR_TOKENS[position]);
        next();
    }

    public void tokenizeNumber() {
        final StringBuilder buffer = new StringBuilder();
        char current = peek(0);
        while (Character.isDigit(current)) {
            buffer.append(current);
            current = next();
        }
        addToken(TokenType.NUMBER, buffer.toString());
    }

    private char next() {
        pos++;
        return peek(0);
    }

    private char peek(int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= lenght) {
            return '\0';
        }
        return input.charAt(position);
    }

    private void addToken(TokenType type) {
        addToken(type, " ");
    }

    private void addToken(TokenType type, String text) {
        tokens.add(new Token(type, text));
    }
}
