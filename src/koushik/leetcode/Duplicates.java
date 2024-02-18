package Leetcode;

import java.util.*;

public class Duplicates {
    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int i=0;
        while(i<nums.length){
            if(nums[i]!=-1 && nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
            if(nums[i]!=-1 && nums[i]!=i+1 && nums[nums[i]-1]==nums[i]){
                list.add(nums[i]);
                nums[i]=-1;
                //i++;
            }
            if(nums[i]==-1 || nums[i]==i+1){
                i++;
            }
        }
        return list;
    }
}
