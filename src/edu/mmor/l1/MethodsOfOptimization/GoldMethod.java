package edu.mmor.l1.MethodsOfOptimization;

import edu.mmor.l1.Functions.Function;

/**
 * Created with IntelliJ IDEA.
 * User: DTSHNICK
 * Date: 10.09.13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
public class GoldMethod implements IMethod {

    @Override
    public double method(double a, double b, double eps, Function function)
    {
        double x1;
        double x2;
        x1=a+0.382*(b-a);
        x2=a+0.618*(b+a);
        double result;
        double y1;
        double y2;
        y1=function.calculate(x1);
        y2=function.calculate(x2);

        while ((b-a)<eps)
        {
            if (y1<=y2)
            {
                a=x1;
                b=b;
                x1=x2;
                y1=function.calculate(x1);
                x2=a+0.618*(b-a);
                y2=function.calculate(x2);
            }
            else
            {
                a=a;
                b=x2;
                x2=x1;
                y2=function.calculate(x2);
                x1=a+0.382*(b-a);
                y1=function.calculate(x1);
            }
        }
        result=(a+b)/2;
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
