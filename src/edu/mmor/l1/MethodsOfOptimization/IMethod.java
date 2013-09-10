package edu.mmor.l1.MethodsOfOptimization;

import edu.mmor.l1.Functions.Function;

/**
 * Created with IntelliJ IDEA.
 * User: DTSHNICK
 * Date: 10.09.13
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
public interface IMethod {
    double method (double a, double b,double eps, Function function);
}
