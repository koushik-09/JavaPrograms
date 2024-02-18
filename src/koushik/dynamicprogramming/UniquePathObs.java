package koushik.dynamicprogramming;

import java.util.Arrays;

//unique path with obstacles
public class UniquePathObs {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,1},{0,0}};
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        System.out.println(uniquePath(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid,dp));
    }
    private static int uniquePath(int s,int e,int m,int n,int[][] arr,int[][] dp){
        if(s==m-1 && e==n-1){
            if(arr[s][e]==1){
                return 0;
            }
            return 1;
        }
        if(s>m-1 || e>n-1) return 0;
        if(arr[s][e]==1) return 0;
        if(dp[s][e]!=-1) return dp[s][e];


        int d=uniquePath(s+1,e,m,n,arr,dp);
        int r = uniquePath(s,e+1,m,n,arr,dp);
        return dp[s][e]=d+r;
    }
}
