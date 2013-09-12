package edu.mmor.l1.Functions;

/**
 * Created with IntelliJ IDEA.
 * User: DTSHNICK
 * Date: 10.09.13
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
public class Function13 extends Function {
    @Override
    public double calculate(double x) {
        return -Math.pow(Math.pow(x, 2), 1 / 3.) -
                ((1 - Math.pow(x, 2) < 0) ? -Math.pow(Math.pow(x, 2) - 1, 1 / 3.) : Math.pow(1 - Math.pow(x, 2), 1 / 3.));
    }
}
