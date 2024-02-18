package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class palindrome {
    public static void main(String[] args) {
        String str="tattarrattat";
        System.out.println(longestPalindrome(str));
    }
    public static int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        HashSet<Character> set =new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        if(set.size()==1) return 1;
        int[] freq=new int[52];
        for(int i=0;i<s.length();i++){
            if(97<= s.charAt(i) && s.charAt(i)<=122) freq[s.charAt(i)-97]++;
            else freq[(s.charAt(i)-65)+26]++;
        }
        System.out.println(Arrays.toString(freq));
        int ans=0;
        int maxodd=0;
        boolean temp=true;
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2!=0){
                if(maxodd<freq[i]){
                    maxodd=freq[i];
                }
            }
            if(freq[i]%2==0){
                ans+=freq[i];
            }
        }
        return ans+maxodd;
    }
}
