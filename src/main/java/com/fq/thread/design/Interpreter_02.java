package com.fq.thread.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter_02 {

    private static final List<Character> symbols = new ArrayList<>(Arrays.asList('+','-','*','/','%','(',')'));
    public static void main(String[] args) {
        String expression = readExpression();
        Map<Character, Integer> expressionRelValue = readValue(expression);
        AbstractExpression abstractExpression = run(expression, expressionRelValue);
        System.out.println("运算结果("+expression+")="+abstractExpression.interpreter(expressionRelValue));
    }

    private static String readExpression() {
        System.out.print("请输入表达式：");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static Map<Character, Integer> readValue(String expression){
        Map<Character, Integer> expressionRelValue = new HashMap<>();
        if(null!=expression && !"".equals(expression)){
            char[] chars = expression.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char var = chars[i];
                if(!symbols.contains(var)){
                    System.out.print(var+"=");
                    Scanner scanner = new Scanner(System.in);
                    expressionRelValue.put(var,Integer.valueOf(scanner.next()));
                }
            }
        }
        return expressionRelValue;
    }

    private static AbstractExpression run(String expression, Map<Character, Integer> expressionRelValue){
        char[] chars = expression.toCharArray();
        Stack<AbstractExpression> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char var = chars[i];
            switch (var){
                case '+':
                    return stack.push(new AddExpression(stack.pop(),run(expression.substring(i+1), expressionRelValue)));
                case '-':
                    return stack.push(new SubExpression(stack.pop(),run(expression.substring(i+1), expressionRelValue)));
                case '(':
                    return stack.push(new LeftParenthesesExpression(run(expression.substring(i+1), expressionRelValue)));
                case ')':
                    break;
                default:
                    stack.push(new VarExpression(var));
                    break;
            }
        }
        return stack.pop();
    }

    abstract static class AbstractExpression{
        public abstract int interpreter(Map<Character, Integer> map);
    }

    static class VarExpression extends AbstractExpression{
        private char key;

        public VarExpression(char key) {
            this.key = key;
        }

        @Override
        public int interpreter(Map<Character, Integer> map) {
            return map.get(this.key);
        }
    }

    abstract static class SymbolExpression extends AbstractExpression{
        private AbstractExpression left;
        private AbstractExpression right;

        public SymbolExpression(AbstractExpression left, AbstractExpression right) {
            this.left = left;
            this.right = right;
        }
    }

    static class AddExpression extends SymbolExpression{

        public AddExpression(AbstractExpression left, AbstractExpression right) {
            super(left, right);
        }

        @Override
        public int interpreter(Map<Character, Integer> map) {
            return super.left.interpreter(map)+super.right.interpreter(map);
        }
    }

    static class SubExpression extends SymbolExpression{

        public SubExpression(AbstractExpression left, AbstractExpression right) {
            super(left, right);
        }

        @Override
        public int interpreter(Map<Character, Integer> map) {
            return super.left.interpreter(map)-super.right.interpreter(map);
        }
    }

    static class LeftParenthesesExpression extends SymbolExpression{

        public LeftParenthesesExpression(AbstractExpression right) {
            super(null, right);
        }

        @Override
        public int interpreter(Map<Character, Integer> map) {
            return super.right.interpreter(map);
        }
    }

}