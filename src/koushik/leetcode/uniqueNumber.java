package Leetcode;

import java.util.*;
public class uniqueNumber {
    public static void main(String[] args) {
        int[] arr={-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        int min=arr[0];
        for(int i:arr){
            if(i<min) min=i;
        }
        int max=arr[0];
        for(int i:arr){
            if(i>max) max=i;
        }
        int[] freq=new int[max-min+1];
        for(int i:arr){
            freq[i-min]++;
        }
        System.out.println(Arrays.toString(freq));
        for(int i=0;i<freq.length-1;i++){
            for(int j=i+1;j<freq.length;j++){
                if(freq[i]!=0 && freq[i]==freq[j]) return false;
            }
        }
        return true;
    }
}
