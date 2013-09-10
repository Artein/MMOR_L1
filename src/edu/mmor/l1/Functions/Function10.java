package edu.mmor.l1.Functions;

/**
 * Created with IntelliJ IDEA.
 * User: DTSHNICK
 * Date: 10.09.13
 * Time: 20:28
 * To change this template use File | Settings | File Templates.
 */
public class Function10 extends Function {
    @Override
    public double calculate(double x) {
        double result;
        result=-Math.pow(x,2)*(x+1)*Math.pow(x-2,1/3);
        return result;
    }
}
