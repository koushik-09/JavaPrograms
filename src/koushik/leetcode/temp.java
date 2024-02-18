package Leetcode;

public class temp {
    public static void main(String[] args) {
        String str="dkd";
        String ans="";
        int i=0,j=0;
        int c=0;
        while(i<str.length() && j<str.length()){
            if(str.charAt(i)==str.charAt(j)){
                c++;
                j++;
            }
            else if(str.charAt(i) != str.charAt(j)){
                ans+=c;
                i++;
                c=0;
            }
        }
        if(j==str.length()){
            ans+=c;
        }
        System.out.println(ans);
    }
}
