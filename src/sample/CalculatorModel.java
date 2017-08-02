package sample;

import java.util.Stack;

/**
 * Created by marco on 31/07/2017.
 */
public class CalculatorModel {

    private String expression;
    private String polish;
    private Stack<Double> stack;
    private String operators = "-+*/^";
    private OperationModel operationModel;

    public CalculatorModel(String expression){
        this.expression = expression;
        this.polish = "";
        this.stack = new Stack<Double>();
        operationModel = new OperationModel();
    }

    public String calculate() {

        if (validator()) {
            polish = convertToPolish(expression);
            for (int i = 0; i < polish.length(); i++) {

                switch (polish.charAt(i)) {
                    case '+': operationModel.sum(stack);
                        break;
                    case '-': operationModel.substraction(stack);
                        break;
                    case '*': operationModel.multiplication(stack);
                        break;
                    case '/': operationModel.divition(stack);
                        break;
                    case '^': operationModel.pow(stack);
                        break;
                    case ' ':
                        break;
                    default:
                        String temp = "";
                        for (int j = i; polish.charAt(j) != ' '; j++) {
                            temp += polish.charAt(j);
                            i++;
                        }

                        stack.push(Double.parseDouble(temp));
                        break;
                }
            }

            double result = stack.pop();

            System.out.println(result);
            return "" + result;
        } else
            return "Syntax error!";
    }

    private boolean validator(){
        return bracketsValidator() && expressionValidator();
    }

    private boolean bracketsValidator() {
        int open = 0;

        for (int i = 0; i < expression.length(); i++)
            if (expression.charAt(i) == '(') {
                for (int j = 0; j < operators.length(); j++)
                    if (i + 1 == expression.length() || expression.charAt(i + 1) == operators.charAt(j) ||
                            expression.charAt(i + 1) == ')')
                        return false;
                open++;
            }
            else if (expression.charAt(i) == ')') {
                if (0 >= open)
                    return false;
                else {
                    for (int j = 0; j < operators.length(); j++) {
                        if (i + 1 == expression.length() || expression.charAt(i + 1) == operators.charAt(j) ||
                                expression.charAt(i + 1) == ')')
                            break;

                        if (j + 1 == operators.length())
                            return false;
                    }
                    open--;
                }
            }

        return open == 0;
    }

    private boolean expressionValidator() {

        for (int i = 0; i < operators.length(); i++)
            if (operators.charAt(i) == expression.charAt(0) ||
                    operators.charAt(i) == expression.charAt(expression.length() - 1))
                return false;

        for (int i = 1; i < expression.length() - 1; i++)
            for (int j = 0; j < operators.length(); j++)
                if (operators.charAt(j) == expression.charAt(i)) {
                    for (int k = 0; k < operators.length(); k++)
                        if (operators.charAt(k) == expression.charAt(i + 1))
                            return false;

                    break;
                }

        return true;
    }

    private String convertToPolish(String e) {

        String p = "";

        for (int i = 0; i < e.length(); i++) {

            if (e.charAt(i) == '(') {
                i++;
                String temp = "";
                int bracketCount = 0;

                for (int j = 1; e.charAt(j) != ')' || bracketCount != 0; j++) {

                    temp += e.charAt(j);
                    if (e.charAt(j) == '(')
                        bracketCount++;
                    else if (e.charAt(j) == ')')
                        bracketCount--;

                    i++;
                }

                temp += "";
                p += convertToPolish(temp);
            } else {
                if (i == 0)
                    for (int j = 0; (j < e.length() && e.charAt(j) != '+' && e.charAt(j) != '-' && e.charAt(j) != '*' &&
                            e.charAt(j) != '/' && e.charAt(j) != '^'); j++)
                        p += e.charAt(j);

                if (e.charAt(i) == '+' || e.charAt(i) == '-' || e.charAt(i) == '*' || e.charAt(i) == '/' ||
                        e.charAt(i) == '^') {

                    p += " ";
                    char operator = e.charAt(i);

                    if (e.charAt(i + 1) ==  '(') {
                        i++;
                        String temp = "";
                        int bracketCount = 0;
                        for (int j = i + 1; e.charAt(j) != ')' || bracketCount != 0; j++) {
                            temp += e.charAt(j);

                            if (e.charAt(j) == '(')
                                bracketCount++;
                            else if (e.charAt(j) == ')')
                                bracketCount--;

                            i++;
                        }

                        temp += "";
                        p += convertToPolish(temp);
                        p += " ";
                        p += operator;

                    } else {
                        for (int j = i + 1; (j < e.length() && e.charAt(j) != '+' && e.charAt(j) != '-' && e.charAt(j) != '*' &&
                                e.charAt(j) != '/' && e.charAt(j) != '^'); j++)
                            p += e.charAt(j);

                        p += " ";
                        p += e.charAt(i);
                    }

                }


            }

        }

        return p;
    }
}
