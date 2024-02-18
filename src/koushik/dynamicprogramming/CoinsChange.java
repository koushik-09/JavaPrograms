package koushik.dynamicprogramming;

import javax.swing.*;
import java.util.Arrays;

// link https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471?interviewProblemRedirection=true
//link https://leetcode.com/problems/coin-change/description/
public class CoinsChange {
    public static void main(String[] args) {
        int[] denominations = {1,2,3};
        int value = 4;
        int[][] dp = new int[denominations.length][value+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        System.out.println(tabulation(denominations.length-1,value,denominations,dp));
    }

    private static int tabulation(int i,int tar,int[] coins,int[][] dp){
        for(int t = 0;t<=tar;t++){
            if(t % coins[0]==0) dp[0][t]=t/coins[0];
            else dp[0][t]=(int)1e7;
        }
        for(int ind = 1;ind < coins.length; ind++){
            for(int t = 0; t <= tar; t++){
                int notTake = dp[i-1][tar];
                int take = Integer.MAX_VALUE;
                if(coins[i]<=tar){
                    take = 1 + dp[i][tar-coins[i]];
                }
                dp[i][tar] = Math.min(take , notTake);
            }
        }
        return dp[coins.length-1][tar];
    }

    private static int countWaysToMakeChange(int i,int tar,int[] deno,int[][] dp){
        if(i == 0){
            if(tar % deno[0]==0) return 1;
            return 0;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int notTake = countWaysToMakeChange(i-1,tar,deno,dp);
        int take = 0;
        if(deno[i]<=tar){
            take = countWaysToMakeChange(i,tar-deno[i],deno,dp);
        }
        return dp[i][tar] = take + notTake;
    }

    private static int countWaysToMakeChange(int i,int tar,int[] deno){
        if(i == 0){
            if(tar % deno[0]==0) return 1;
            return 0;
        }
        int notTake = countWaysToMakeChange(i-1,tar,deno);
        int take = 0;
        if(deno[i]<=tar){
            take = countWaysToMakeChange(i,tar-deno[i],deno);
        }
        return take + notTake;
    }
}
