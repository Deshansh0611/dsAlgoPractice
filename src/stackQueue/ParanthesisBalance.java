package stackQueue;

import java.util.Stack;

public class ParanthesisBalance {
    public static void main(String[] args) {
        String input = "[({{{()}}})]";
        System.out.println("Paranthesis balance check for " + input + " " + checkParanthesisBalance(input));
    }

    static boolean checkParanthesisBalance(String x)
    {
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i<x.length(); i++){
            char currChar = x.charAt(i);
            if(currChar == '['
                    || currChar == '{' || currChar == '(') {
                s.push(currChar);
                continue;
            }
            if(s.isEmpty())
                return false;
            char recent = s.pop();
            switch(currChar) {
                case ']':
                    if(!(recent == '['))
                        return false;
                    break;
                case '}':
                    if(!(recent == '{'))
                        return false;
                    break;
                case ')':
                    if(!(recent == '('))
                        return false;
                    break;
            }
        }
        return (s.isEmpty())? true: false;
    }
}
