package koushik.dynamicprogramming;

import java.util.Arrays;


public class CherryPickup2 {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        int[][][] dp = new int[grid.length+1][grid[0].length+1][grid[0].length+1];
        for(int[][] ar : dp){
            for(int[] a : ar){
                Arrays.fill(a,-1);
            }
        }
        System.out.println(cherryPickup(0,0,grid[0].length-1,grid.length-1,grid,dp));

    }
    private static int cherryPickup(int i,int j1,int j2,int m,int[][] grid,int[][][] dp){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return -1000001;
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        if(i==m){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int max=-1;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2 = -1;dj2<=1;dj2++){
                if(j1==j2){
                    max=Math.max(max,grid[i][j1]+cherryPickup(i+1,j1+dj1,j2+dj2,m,grid,dp));
                }
                else{
                    max= Math.max(max,grid[i][j1]+grid[i][j2]+cherryPickup(i+1,j1+dj1,j2+dj2,m,grid,dp));
                }
            }
        }
        return dp[i][j1][j2] = max;
    }

    // Recursive Approach (TLE)
    // Time complexity : O(3^n * 3^n)
    // Space complexity : O(N) (stack space)
    private static int cherryPickup(int i,int j1,int j2,int m,int[][] grid){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return -1000001;
        }
        if(i==m){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int max=-1;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2 = -1;dj2<=1;dj2++){
                if(j1==j2){
                    max=Math.max(max,grid[i][j1]+cherryPickup(i+1,j1+dj1,j2+dj2,m,grid));
                }
                else{
                    max= Math.max(max,grid[i][j1]+grid[i][j2]+cherryPickup(i+1,j1+dj1,j2+dj2,m,grid));
                }
            }
        }
        return max;
    }
}
