package Leetcode;

public class Main {
    public static void main(String[] args) {
        String str="baccad";
        String ans="";
        char ch='a';
        System.out.println(skipChar(str,ans,ch,0));
    }
    public static String skipChar(String str,String ans,char ch,int ind){
        if(ind==str.length()) return ans;
        if(str.charAt(ind)==ch){
            return skipChar(str,ans,ch,++ind);
        }
        else
//            ans+=str.charAt(ind);
            return skipChar(str,ans+str.charAt(ind),ch,++ind);
    }
}