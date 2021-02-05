package com.fq.thread.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter_01 {

    private static final List<Character> symbols = new ArrayList<>(Arrays.asList('+','-','*','/','%','(',')'));
    public static void main(String[] args) {
        String expression = readExpression();
        Map<Character, Integer> expressionRelValue = readValue(expression);
        int result = run(expression, expressionRelValue);
        System.out.println("运算结果("+expression+")="+result);
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

    private static int run(String expression, Map<Character, Integer> expressionRelValue){
        char[] chars = expression.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char var = chars[i];
            switch (var){
                case '+':
                    stack.push(stack.pop()+run(expression.substring(i+1), expressionRelValue));
                    return stack.pop();
                case '-':
                    stack.push(stack.pop()-run(expression.substring(i+1), expressionRelValue));
                    return stack.pop();
                case '(':
                    stack.push(run(expression.substring(i+1), expressionRelValue));
                    return stack.pop();
                case ')':
                    break;
                default:
                    stack.push(expressionRelValue.get(var));
                    break;
            }
        }
        return stack.pop();
    }
}