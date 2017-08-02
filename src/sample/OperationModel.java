package sample;

import java.util.Stack;

/**
 * Created by marco on 01/08/2017.
 */
public class OperationModel {

    public OperationModel(){}

    public double sum(Stack<Double> s) {
        double res, num1, num2;
        num2 = s.pop();
        num1 = s.pop();
        res = num1 + num2;
        s.push(res);
        return res;
    }

    public double substraction(Stack<Double> s) {
        double res, num1, num2;
        num2 = s.pop();
        num1 = s.pop();
        res = num1 - num2;
        s.push(res);
        return res;
    }

    public double multiplication(Stack<Double> s) {
        double res, num1, num2;
        num2 = s.pop();
        num1 = s.pop();
        res = num1 * num2;
        s.push(res);
        return res;
    }

    public double divition(Stack<Double> s) {
        double res, num1, num2;
        num2 = s.pop();
        num1 = s.pop();
        res = num1 / num2;
        s.push(res);
        return res;
    }

    public double pow(Stack<Double> s) {
        double res, num1, num2;
        num2 = s.pop();
        num1 = s.pop();
        res = Math.pow(num1, num2);
        s.push(res);
        return res;
    }

}
