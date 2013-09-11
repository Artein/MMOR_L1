package edu.mmor.l1.MethodsOfOptimization;

import edu.mmor.l1.Functions.Function;
import edu.mmor.l1.MethodsOfOptimization.IMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 10.09.13
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class MethodOfQuadraticApproximation implements IMethod {
    public MethodOfQuadraticApproximation(double intervalStart, double intervalEnd, double epsilon, double dx)
    {
        this.intervalStart  = intervalStart;
        this.intervalEnd    = intervalEnd;
        this.epsilon        = epsilon;
        this.dx             = dx;
    }

    public double calculate(Function function)
    {
        double  x1      = intervalStart,
                x2      = x1 + dx,
                f1      = function.calculate(x1),
                f2      = function.calculate(x2),
                x3      = (f1 > f2) ? (x1 + 2 * dx) : (x1 - dx),
                f3      = function.calculate(x3),
                a1      = (f2 - f1) / (x2 - x1),
                a2      = (1 / (x3 - x2)) * ((f3 - f1) / (x3 - x1) - (f2 - f1) / (x2 - x1)),
                xOptim  = (1 / (2 * a2)) * (a2 * x2 + a2 * x1 - a1),
                fmin, xmin;

        do {
            f3 = function.calculate(x3);
            if (f1 < f2 && f1 < f3) {
                fmin = f1;
                xmin = x1;
            } else if (f2 < f1 && f2 < f3) {
                fmin = f2;
                xmin = x2;
            } else {
                fmin = f3;
                xmin = x3;
            }

//            if (xmin)
        } while (Math.abs(fmin - function.calculate(xOptim)) > epsilon &&
                    Math.abs(xmin - xOptim) > epsilon);

        return xmin;
    }

    // -------------------------------------------------------------------------------

    private double dx; // delta x
    private double intervalStart;
    private double intervalEnd;
    private double epsilon;
}
