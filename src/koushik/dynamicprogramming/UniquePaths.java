package koushik.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m=3;
        int n=7;
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        System.out.println(uniquePaths(0,0,m,n,dp));
    }
    private static int uniquePaths(int s,int e,int m,int n,int[][] dp){
        if(s==m-1 && e==n-1){
            return 1;
        }
        if(s>m-1 || e>n-1){
            return 0;
        }
        if(dp[s][e]!=-1) return dp[s][e];
        int d = uniquePaths(s+1,e,m,n,dp);
        int r = uniquePaths(s,e+1,m,n,dp);
        return dp[s][e]=d+r;
    }
}
