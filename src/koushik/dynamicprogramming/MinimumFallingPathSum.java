package koushik.dynamicprogramming;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int min = 1000000;
//        for(int i=0;i<matrix[0].length;i++){
//            min=Math.min(min,minFallingPathSum(matrix.length-1,i, matrix.length-1,matrix,dp ));
//        }
        System.out.println(min);
//        System.out.println(minFallingPathSum(0,0, matrix.length-1,matrix));
    }
    private static int minFallingPathSum(int i,int j,int ind,int[][] arr,int[][] dp){
        if(j<0 || j>ind) return 100001;
       if(i==0) return arr[i][j];
       if(dp[i][j]!=-1) return dp[i][j];

       int s = arr[i][j]+minFallingPathSum(i-1,j,ind,arr,dp);
       int ld = arr[i][j]+minFallingPathSum(i-1,j-1,ind,arr,dp);
       int rd = arr[i][j]+minFallingPathSum(i-1,j+1,ind,arr,dp);

       return dp[i][j] = Math.min(Math.min(s,ld),rd);
    }
}
