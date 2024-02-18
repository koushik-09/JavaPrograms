package Leetcode;//pending
import java.util.*;

public class degreeOfArray {
    public static void main(String[] args) {
        int[] nums={1,2,2,3,1,4,2,1,1};
        System.out.println(findShortestSubArray(nums));
    }
    public static int findShortestSubArray(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int freq=0;
        for(int i:nums ){
            if(i==nums[0]) freq++;
        }
        //set.remove(nums[0]);
        ArrayList<Integer> ele = new ArrayList<>();
        for(int i : set){
            int temp=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==i){
                    temp++;
                }
            }
            if(temp>=freq){
                freq=temp;
                ele.add(i);
            }
            else if(temp<freq){
                ele.clear();

            }
        }
        //System.out.println(ele +" "+ freq);
        int minlen=Integer.MAX_VALUE;
        for(int x : ele){
            int temp=freq;
            int len=0;
            for(int i=0;i<nums.length;i++){
                if(len==0 && nums[i]==x){
                    len++;
                    temp--;
                }
                else if(len!=0 && temp!=0 && nums[i]!=x){
                    len++;
                }
                else if(len!=0 && temp!=0 && nums[i]==x){
                    len++;
                    temp--;
                }
                if(temp==0){
                    break;
                }
            }
            if(len<minlen) minlen=len;
        }

        return minlen;
    }
}
