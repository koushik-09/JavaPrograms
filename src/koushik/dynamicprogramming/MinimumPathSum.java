package koushik.dynamicprogramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        int[][] grid = {{1,2,3},{4,5,6}};
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        System.out.println(minPathSum(0,0, grid.length, grid[0].length, grid));
    }
    private static int minPathSum(int s,int e,int m,int n,int[][] arr){
        if(s==m-1 && e==n-1){
            return arr[s][e];
        }
        if(s>m-1 || e>n-1){
            return 0;
        }
        int d= Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if(s<m-1){
            d = arr[s][e] + minPathSum(s+1,e,m,n,arr);
        }
        if(e<n-1){
            r = arr[s][e] + minPathSum(s,e+1,m,n,arr);
        }
        return Math.min(d,r);
    }
}
