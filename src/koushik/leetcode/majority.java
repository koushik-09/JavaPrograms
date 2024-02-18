package Leetcode;

import java.util.*;
public class majority {
    public static void main(String[] args) {
        int[] arr= {-1,1,1,1,2,1};
        System.out.println(majorityElement(arr));
    }
    public static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i : nums){
            if(i>max) max=i;
        }
        for(int i : nums){
            if(i<min) min=i;
        }
        if(min>-1){
            int[] freq = new int[max+1];
            for(int i : nums){
                freq[i]++;
            }
            for(int i=0;i<freq.length;i++){
                if(freq[i]>(nums.length/3)){
                    list.add(i);
                }
            }
        }
        else{
            int[] freq= new int[max+(-1*min)+1];
            for(int i  : nums){
                freq[i-min]++;
            }
            for(int i=0;i<freq.length;i++){
                if(freq[i]>(nums.length/3)){
                    list.add(i+min);
                }
            }
            System.out.println(Arrays.toString(freq));
        }
        return list;
    }
}
