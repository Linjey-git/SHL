package net.seho.shl;

import net.seho.shl.parser.Lexer;
import net.seho.shl.parser.Parser;
import net.seho.shl.parser.Token;
import net.seho.shl.parser.ast.Expression;

import java.util.List;

/**
 * @Author _se.ho
 * @create 2022-07-22
 **/

public class Main {
    public static void main(String[] args) {
        final String input = "2 + 246";
        final List<Token> tokens = new Lexer(input).tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }

        final List<Expression> expressions = new Parser(tokens).parse();
        for (Expression expr : expressions) {
            System.out.println(expr + " " + expr.eval());
        }
    }
}
