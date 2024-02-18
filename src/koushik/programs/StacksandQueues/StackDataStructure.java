package koushik.programs.StacksandQueues;

import java.util.Stack;

public class StackDataStructure {
    public static void main(String[] args) {
        String str="(()[]{([]){()}})";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0)==')' ||s.charAt(0)=='}'||s.charAt(0)==']' ){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' ||s.charAt(i)=='{'||s.charAt(i)=='[' ){
                stack.push(s.charAt(i));
            }
            else if(!stack.isEmpty() && s.charAt(i)==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(!stack.isEmpty() && s.charAt(i)==']' && stack.peek()=='['){
                stack.pop();
            }
            else if(!stack.isEmpty() && s.charAt(i)=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
