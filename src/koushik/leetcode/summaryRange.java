package Leetcode;

import java.util.*;
public class summaryRange {
    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(summaryRanges(arr));
    }
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        int ind=0;
        boolean x= true;
        while(x){
            int t=nums[ind];
            ind++;
            int t1=t;
            while(ind<nums.length && (t+1)==nums[ind]){
                t=nums[ind];
                ind++;
            }
            if(t==t1){
                list.add(""+t1);
            }
            else{
                list.add(""+t1+"->"+t);
            }
            if(ind>= nums.length) x=false;
        }
        return list;
    }
}
