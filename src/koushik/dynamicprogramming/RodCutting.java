package koushik.dynamicprogramming;

import java.util.Arrays;

//link https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284?interviewProblemRedirection=true
public class RodCutting {
    public static void main(String[] args) {
        int[] price = {25, 79, 59, 63 ,65, 6, 46 ,82};
       // 25 79 59 63 65 6 46 82
        int n = 8;
        int[][] dp = new int[price.length][n+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        System.out.println(cutRod(n-1,n,price));
//        System.out.println(cutRod(n-1,n,price,dp));
    }
    private static int cutRod(int i,int len,int[] price,int[][] dp){
        if(i == 0){
            return len * price[0];
        }
        if(dp[i][len] != -1) return dp[i][len];
        int notCut = cutRod(i-1,len,price,dp);
        int cut = Integer.MIN_VALUE;
        if(len >= (i+1)){
            cut = price[i]+cutRod(i,len-(i+1),price,dp);
        }
        return dp[i][len] = Math.max(notCut,cut);
    }
    private static int cutRod(int i,int len,int[] price){
        if(i == 0){
                return len * price[0];
        }
        int notCut = cutRod(i-1,len,price);
        int cut = Integer.MIN_VALUE;
        if(len >= i){
            cut = price[i]+cutRod(i,len-(i+1),price);
        }
        return Math.max(notCut,cut);
    }
}
