package Leetcode;

import java.util.*;
public class replacePattern {
    public static void main(String[] args) {
        String[] word ={"abc","cba","xyx","yxx","yyx"};
        String pattern ="abc";
        System.out.println(findAndReplacePattern(word,pattern));
        //System.out.println(unique("abc"));
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> list = new ArrayList<>();
        String temp=pattern(pattern);
        int t=unique(pattern);
        for(String str : words){
            if(unique(str)==t) {
                if (pattern(str).equals(temp)) {
                    list.add(str);
                }
            }
        }
        return list;
    }
    public static String pattern(String str){
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
        return ans;
    }
    public static int unique(String str){
        int c=0;
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            freq[(int)str.charAt(i)-97]++;
        }
        for(int i:freq){
            if(i>0) c++;
        }
        return c;
    }
}
