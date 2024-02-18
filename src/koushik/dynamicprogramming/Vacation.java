package koushik.dynamicprogramming;

import javax.xml.transform.stax.StAXSource;
import java.util.Arrays;

public class Vacation {
    public static void main(String[] args) {
        int[][] arr = {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        System.out.println(maxPoints(arr.length-1,arr,3,dp));
    }
    public static int maxPoints(int ind,int[][] arr,int last,int[][] dp){
        if(ind==0){
            int max=-1;
            for(int i=0;i< arr[0].length;i++){
                if(i!=last){
                    if(arr[ind][i]>max){
                        max=arr[ind][i];
                    }
                }
            }
            return max;
        }
        if(dp[ind][last]!=-1) return dp[ind][last];
        int max=-1;
        for(int i=0;i<arr[0].length;i++){
            if(i!=last){
                int point =  arr[ind][i]+maxPoints(ind-1,arr,i,dp);
                max=Math.max(max,point);
            }
        }
        dp[ind][last]=max;
        return max;
    }
}
