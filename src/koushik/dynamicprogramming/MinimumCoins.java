package koushik.dynamicprogramming;

import java.util.Arrays;

//link https://www.codingninjas.com/studio/problems/minimum-elements_3843091?interviewProblemRedirection=true
public class MinimumCoins {
    public static void main(String[] args) {
        int[] denominations = {1,2,3};
        int target = 7;
        int[][] dp = new int[denominations.length][target+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        System.out.println(minCoins(denominations.length-1,target,denominations,dp));
    }

    private static int minCoins(int i,int tar,int[] d,int[][] dp){
        if(i==0){
            if(tar%d[0]==0) return tar/d[0];
            return 10000001;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int notTake = minCoins(i-1,tar,d,dp);
        int take = Integer.MAX_VALUE;
        if(d[i]<=tar){
            take = 1 + minCoins(i,tar-d[i],d,dp);
        }
        return dp[i][tar] = Math.min(take,notTake);
    }

    //recursion
    private static int minCoins(int i,int tar,int[] d){
        if(i==0){
            if(tar%d[0]==0) return tar/d[0];
            return 10000001;
        }
        int notTake = minCoins(i-1,tar,d);
        int take = Integer.MAX_VALUE;
        if(d[i]<=tar){
            take = 1 + minCoins(i,tar-d[i],d);
        }
        return Math.min(take,notTake);
    }
}
