package koushik.dynamicprogramming;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] wt = {3,4,5};
        int[] profit = {30,50,60};
        int W = 12;
        int[][] dp  = new int[wt.length][W+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
//        System.out.println(maxProfit(wt.length-1,W,wt,profit,dp));
        System.out.println(tabulation(wt.length-1,W,wt,profit,dp));
    }

    private static int maxProfit(int ind,int totWt,int[] wt,int[] profit,int[][] dp){
        if(ind==0){
            if(wt[0]<=totWt){
                return profit[0];
            }
            return 0;
        }
        if(dp[ind][totWt]!=-1) return dp[ind][totWt];
        int notTake = maxProfit(ind-1,totWt,wt,profit,dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=totWt){
            take = profit[ind]+maxProfit(ind-1,totWt-wt[ind],wt,profit,dp);
        }
        return dp[ind][totWt] = Math.max(notTake,take);
    }

    private static int tabulation(int ind,int totWt,int[] wt,int[] profit,int[][] dp){
        for(int w=wt[0];w<=totWt;w++){
            dp[0][w]=profit[0];
        }
        for(int i=1;i<wt.length;i++){
            for(int w=0;w<=totWt;w++){
                int notTake = dp[ind-1][totWt];
                int take = Integer.MIN_VALUE;
                if(wt[ind]<=totWt){
                    take = profit[ind]+dp[ind-1][totWt-wt[ind]];
                }
                dp[ind][totWt] = Math.max(take,notTake);
            }
        }
        return dp[wt.length-1][totWt];
    }

    private static int maxProfit(int ind,int totWt,int[] wt,int[] profit){
        if(ind==0){
            if(wt[0]<=totWt){
                return profit[0];
            }
            return 0;
        }
        int notTake = maxProfit(ind-1,totWt,wt,profit);
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=totWt){
            take = profit[ind]+maxProfit(ind-1,totWt-wt[ind],wt,profit);
        }
        return Math.max(notTake,take);
    }
}
