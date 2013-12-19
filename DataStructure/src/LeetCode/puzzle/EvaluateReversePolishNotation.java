package LeetCode.puzzle;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/6/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */



public class EvaluateReversePolishNotation {


    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0)
            return 0;

        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < tokens.length; i++) {
            String curT = tokens[i];

            if(curT.equals("+") || curT.equals("-") || curT.equals("*") || curT.equals("/")) {
                int operandTwo = Integer.parseInt(stack.pop());
                int operandOne = Integer.parseInt(stack.pop());
                int res = 0;

                if(curT.equals("+"))
                    res = operandOne+operandTwo;

                if(curT.equals("-"))
                    res = operandOne-operandTwo;

                if(curT.equals("*"))
                    res = operandOne * operandTwo;

                if(curT.equals("/"))
                    res = operandOne / operandTwo;

                stack.push(String.valueOf(res));

            } else {
                stack.push(curT);
            }

        }

        return Integer.parseInt(stack.peek());

    }

    public static void main (String[] args) {
        EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
//        String[] tokens = {"4", "13", "5", "/", "+"};
//        String[] tokens = {"0", "3", "/"};
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.print(s.evalRPN(tokens));
    }


}































