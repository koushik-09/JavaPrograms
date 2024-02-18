package koushik.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A frog is at 0 it wants to reach to the n
 * the frog can jump either 1 step or 2 steps ahead
 * every time frog jumps it consumes some energy
 * given an array energy where energy consumed from jumping i to j is abs(energy[i] - energy[j]) where 0<=i<j<=n
 * return the minimum energy consumed for reaching n
 */
public class FrogJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] energy = {7,4,4,2,6,6,3,4};
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(frogJump(n-1,energy,dp));
    }

    private static int frogJump(int n, int[] energy,int[] dp) {
        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];
        int l = frogJump(n-1,energy,dp) + Math.abs(energy[n] - energy[n-1]);
        int r = Integer.MAX_VALUE;
        if(n>1){
            r = frogJump(n-2,energy,dp) + Math.abs(energy[n] - energy[n-2]);
        }
        return dp[n]=Math.min(l,r);
    }
}
