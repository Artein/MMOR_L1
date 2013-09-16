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
public class QuadraticApproximation implements IMethod {
    // TODO: Add delta x like a parameter
    public QuadraticApproximation(double intervalStart, double intervalEnd, double epsilon) {
        this.intervalStart  = intervalStart;
        this.intervalEnd    = intervalEnd;
        this.epsilon        = epsilon;
    }

    private double calculateWavedX(double x1, double x2, double x3, double f1, double f2, double f3)
            throws ArithmeticException{
        double r23 = Math.pow(x2, 2) - Math.pow(x3, 2),
               r31 = Math.pow(x3, 2) - Math.pow(x1, 2),
               r12 = Math.pow(x1, 2) - Math.pow(x2, 2),
               s23 = x2 - x3,
               s31 = x3 - x1,
               s12 = x1 - x2;

        // returns 0.5 * (beta) / (alpha)
        double beta  = f1 * r23 + f2 * r31 + f3 * r12,
               alpha = f1 * s23 + f2 * s31 + f3 * s12;
        if (alpha != 0) {
            return 0.5 * (beta) / (alpha);
        } else {
            throw new ArithmeticException("ERROR: Divide by null by calculating waved point");
        }
    }

    @Override
    // TODO: Reorganize this method
    public double calculate(Function function) {

        double x1, x2 = -1000000.0d, x3 = -100000.0d, dx, f1 = -1000000.0d, f2 = -100000.0d, f3, xMin, fMin, xSt = -1000000.0d;
        int step = 0;
        x1 = intervalStart;
        boolean isFromBegin = true;

        // TODO: Is I must to get dx from outside?
        dx = 2 * epsilon;

        while (true) {
            System.out.println("\n\nИТЕРАЦИЯ " + (++step));
            if (isFromBegin) {
                x2 = x1 + dx;
                System.out.println("x2 = x1 + dx = " + x2);
                f1 = function.calculate(x1);
                f2 = function.calculate(x2);
                System.out.println("f1 = " + f1 + ", f2 = " + f2);

                // find and calculate [x3;f3]
                if (f1 > f2) {
                    x3 = x1 + 2 * dx;
                    System.out.println("(f1 > f2) -> x3 = " + x3);
                } else {
                    x3 = x1 - dx;
                    System.out.println("(f1 < f2) -> x3 = " + x3);
                }
            }
            isFromBegin = true;

            f3 = function.calculate(x3);
            System.out.println("f3 = " + f3);

            if (f1 < f2 && f1 < f3) {
                fMin = f1;
                xMin = x1;
                System.out.println("fMin = min{" + f1 + "; " + f2 + "; " + f3 + "} = " + fMin);
                System.out.println("xMin = x1 = " + xMin);
            } else if (f2 < f1 && f2 < f3) {
                fMin = f2;
                xMin = x2;
                System.out.println("fMin = min{" + f1 + "; " + f2 + "; " + f3 + "} = " + fMin);
                System.out.println("xMin = x2 = " + xMin);
            } else {
                fMin = f3;
                xMin = x3;
                System.out.println("fMin = min{" + f1 + "; " + f2 + "; " + f3 + "} = " + fMin);
                System.out.println("xMin = x3 = " + xMin);
            }

            System.out.println("Вычисляем точку минимума интерполяционного полинома:");
            try {
                xSt = calculateWavedX(x1, x2, x3, f1, f2, f3);
                System.out.println("xSt = " + xSt);
                System.out.println("fSt = " + function.calculate(xSt));
            } catch (ArithmeticException ex) {
                // denominator equals to null while calculating waved X
                x1 = xMin;
                System.out.println("xSt = " + xSt);
                System.out.println("fSt = " + function.calculate(xSt));
                continue;
            }

            System.out.println("Проверка окончания поиска:");
            if (Math.abs((fMin - function.calculate(xSt)) / function.calculate(xSt)) <= epsilon
                    && Math.abs((xMin - xSt) / xSt) <= epsilon) {
                System.out.println("Условие выполняется");
                xMin = xSt;
                break;
            } else if (xSt >= x1 && xSt <= x3) {
                System.out.println("Условие не выполняется. Точка лежит внутри интервала");
                if (function.calculate(xSt) < fMin) {
                    System.out.println("(fSt < fMin) - (" + function.calculate(xSt) + " < " + fMin + ")");
                    if (xSt < x2) {
                        x3 = x2;
                        x2 = xSt;
                        System.out.println("Новые точки: x1 = " + x1 + ", x2 = xSt = " + xSt + ", x3 = " + x3);
                    } else {
                        x1 = x2;
                        x2 = xSt;
                        System.out.println("Новые точки: x1 = " + x1 + ", x2 = xSt = " + xSt + ", x3 = " + x3);
                    }
                    f1 = function.calculate(x1);
                    f2 = function.calculate(x2);
                    isFromBegin = false;
                    continue;
                } else {
                    x1 = xSt;
                    isFromBegin = true;
                    continue;
                }
            } else {
                System.out.println("Условие не выполняется. Точка НЕ лежит внутри интервала");
                x1 = xSt;
                continue;
            }
        }

        return xMin;
    }

    // -------------------------------------------------------------------------------

    private double intervalStart;
    // TODO: Check, why end of interval is never used
    private double intervalEnd;
    private double epsilon;
}
