package Leetcode;

public class Maxones {
    public static void main(String[] args) {
        int[] nums={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ind=0,count=0,max=0;
        while(ind<nums.length){
            if(nums[ind]==0){
                if(count>max){
                    max=count;
                }
                count=0;
            }
            else{
                count++;
            }
            ind++;
        }
        return count;
    }
}
