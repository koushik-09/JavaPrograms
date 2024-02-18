package Leetcode;

public class detectcapital {
    public static void main(String[] args) {
        String str="Tol";
        System.out.println(detectCapitalUse(str));
    }
    public static boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        if(65<=word.charAt(0) && word.charAt(0)<=90){
            if(97<=word.charAt(1)&&word.charAt(1)<=122){
                for(int i=1;i<word.length();i++){
                    if(!(97<=word.charAt(i)&&word.charAt(i)<=122)) return false;
                }
                return true;
            }
            else if(65<=word.charAt(1) && word.charAt(1)<=90){
                for(int i=1;i<word.length();i++){
                    if(97<=word.charAt(i)&&word.charAt(i)<=122) return false;
                }
                return true;
            }
        }
        for(int i=0;i<word.length();i++){
            if(65<=word.charAt(i) && word.charAt(i)<=90) return false;
        }
        return true;
    }
}
