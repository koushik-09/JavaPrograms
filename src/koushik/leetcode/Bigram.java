package Leetcode;

import java.util.Arrays;

public class Bigram {
    public static void main(String[] args) {
        String text="we will we will rock you";
        String first="we";
        String second="will";
        System.out.println(Arrays.toString(findOcurrences(text,first,second)));
    }
    public static String[] findOcurrences(String text, String first, String second) {
        String[] temp =text.split("\\s");
        System.out.println(Arrays.toString(temp));
        int ind=0;
        for(int i=0;i<temp.length-2;i++){
            if(temp[i].equals(first)){
                if(temp[i+1].equals(second)){
                    temp[ind++]=temp[i+2];
                }
            }
        }
        return Arrays.copyOfRange(temp,0,ind);
    }
}
