package Leetcode;

public class Decrypt {
    public static void main(String[] args) {
        String s="1326#";
        System.out.println(freqAlphabets(s));
    }
    public static String freqAlphabets(String s) {
        int ind=s.length()-1;
        String ans="";
        while(ind>=0){
            if(s.charAt(ind)=='#'){
                String temp="";
                temp=temp+s.charAt(ind-2)+s.charAt(ind-1);
                ind-=3;
                ans=(char)(96+Integer.parseInt(temp))+ans;
            }
            else{
                ans=(char)(96+Integer.parseInt(String.valueOf(s.charAt(ind))))+ans;
                ind--;
            }
        }
        return ans;
    }
}
