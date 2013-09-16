package edu.mmor.l1.MethodsOfOptimization;

import edu.mmor.l1.Functions.Function;

/**
 * Created with IntelliJ IDEA.
 * User: DTSHNICK
 * Date: 10.09.13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
public class GoldenRatio implements IMethod {
    public GoldenRatio(double intervalStart, double intervalEnd, double epsilon)
    {
        this.intervalStart  = intervalStart;
        this.intervalEnd    = intervalEnd;
        this.epsilon        = epsilon;
    }

    @Override
    public double calculate(Function function)
    {
        double x1 = intervalStart + 0.382 * (intervalEnd - intervalStart);
        double x2 = intervalStart + 0.618 * (intervalEnd + intervalStart);
        double result;
        double y1 = function.calculate(x1);
        double y2 = function.calculate(x2);

        while ((intervalEnd - intervalStart) < epsilon)
        {
            if (y1 <= y2)
            {
                intervalStart = x1;
//                intervalEnd=intervalEnd;
                x1 = x2;
                y1 = function.calculate(x1);
                x2 = intervalStart + 0.618 * (intervalEnd - intervalStart);
                y2 = function.calculate(x2);
            }
            else
            {
//                intervalStart=intervalStart;
                intervalEnd = x2;
                x2 = x1;
                y2 = function.calculate(x2);
                x1 = intervalStart + 0.382 * (intervalEnd - intervalStart);
                y1 = function.calculate(x1);
            }
        }
        result = (intervalStart + intervalEnd) / 2;
        return result;
    }

    // -----------------------------------------------------------------------------------

    private double intervalStart;
    private double intervalEnd;
    private double epsilon;
}
