package koushik.dynamicprogramming;

import java.util.*;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(noOfSteps(0,n,dp));
    }
    private static int noOfSteps(int t,int n,int[] dp){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];

        return dp[n]=noOfSteps(t+1,n-1,dp) + noOfSteps(t+2,n-2,dp);
    }
}
