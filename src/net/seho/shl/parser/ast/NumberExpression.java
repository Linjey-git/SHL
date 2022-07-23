package net.seho.shl.parser.ast;

/**
 * @Author _se.ho
 * @create 2022-07-22
 **/

public class NumberExpression implements Expression {

    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double eval() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
