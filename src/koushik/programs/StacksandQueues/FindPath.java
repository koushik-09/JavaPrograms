package koushik.programs.StacksandQueues;

import java.util.Stack;

public class FindPath {
    public static void main(String[] args) {
        String str="/./";
        System.out.println(simplifyPath(str));
    }
    public static String simplifyPath(String path) {
        Stack<Character> stack =new Stack<>();
        String ans="";
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='/'){
                if((!stack.isEmpty()) && stack.peek()!='/'){
                    stack.push(path.charAt(i));
                }
                if(stack.isEmpty()){
                    stack.push(path.charAt(i));
                }
            }
            else if(path.charAt(i)=='.'){
                int j=i;
                int c=0;
                while(j<path.length() && path.charAt(j)=='.'){
                    c++;
                    j++;
                }
                if(c==1){
                    i=j;
                }
                else if(c==2){
                    
                }
                else{
                    while(i<path.length() && path.charAt(i)=='.'){
                        stack.push(path.charAt(i));
                        i++;
                    }
                    i--;
                }
            }
            else{
                stack.push(path.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            ans=stack.peek()+ans;
            stack.pop();
        }
        System.out.println(ans.substring(0,ans.length()-1));
        if(ans.length()>1 && ans.charAt(ans.length()-1)=='/'){
            return ans.substring(0,ans.length()-1);
        }

        return ans;
    }
}
