package Leetcode;

import java.util.Arrays;

public class example {
    public static void main(String[] args) {
        char[] chr = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chr));
    }
    public static int compress(char[] chars) {
        String str="";
        for(int i=0;i<chars.length; ){
            str=str+chars[i];
            int count=0;
            int j=i;
            while(chars[i]==chars[j]){
                count++;
                j++;
                if(j== chars.length) {
                    break;
                }
            }
            if(count!=1) {
                str = str + count;
            }
                i = j;
        }
        System.out.println(str);
        int ind=0;
        for(int i=0;i<str.length();i++){
            chars[ind++]=str.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
        return str.length();
    }
}
