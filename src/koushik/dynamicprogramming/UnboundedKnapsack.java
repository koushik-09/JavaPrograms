package koushik.dynamicprogramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = {3,4,5};
        int[] profit = {30,50,60};
        int W = 12;
        int[][] dp = new int[wt.length][W+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        System.out.println(maxProfit(wt.length-1,W,wt,profit,dp));
    }

    private static int maxProfit(int i,int totWt,int[] wt,int[] profit,int[][] dp){
        if(i == 0){
            return (totWt/wt[0])*profit[0];
        }
        if(dp[i][totWt]!=-1) return dp[i][totWt];
        int notTake = maxProfit(i-1,totWt,wt,profit,dp);
        int take = Integer.MIN_VALUE;
        if(wt[i] <= totWt){
            take =profit[i] + maxProfit(i,totWt-wt[i],wt,profit,dp);
        }
        return dp[i][totWt] = Math.max(take,notTake);
    }
    private static int maxProfit(int i,int totWt,int[] wt,int[] profit){
        if(i == 0){
            return (totWt/wt[0])*profit[0];
        }
        int notTake = maxProfit(i-1,totWt,wt,profit);
        int take = Integer.MIN_VALUE;
        if(wt[i] <= totWt){
            take =profit[i] + maxProfit(i,totWt-wt[i],wt,profit);
        }
        return Math.max(take,notTake);
    }
}
