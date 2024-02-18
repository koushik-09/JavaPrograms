package koushik.dynamicprogramming;

import java.util.Arrays;

public class SubSetSumK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int[][] dp = new int[nums.length+1][k+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        System.out.println(subSetSum(0,0,k,nums,dp));
    }
    private static int subSetSum(int ind, int sum, int k, int[] nums,int[][] dp){
        if(sum==k){
            return 1;
        }
        if(ind==nums.length){
            return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        sum+=nums[ind];
        int l = subSetSum(ind+1,sum,k,nums,dp);
        sum-=nums[ind];
        int r = subSetSum(ind+1,sum,k,nums,dp);
        return dp[ind][sum] = l+r;
    }
}