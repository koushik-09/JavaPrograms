package koushik.dynamicprogramming;

import java.util.*;

public class HouseRobbers {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};

         //first and last houses are not neighbours
        int[] dp  = new int[arr.length+1];
        Arrays.fill(dp,-1);
        System.out.println(houseRobber(arr.length-1,arr,dp));

         //first and last houses not neighbours
        int[] temp1 = Arrays.copyOfRange(arr,0,arr.length-1);
        int[] temp2 = Arrays.copyOfRange(arr,1,arr.length);
        Arrays.fill(dp,-1);
        int a1 = houseRobber(temp1.length-1,temp1,dp);
        Arrays.fill(dp,-1);
        int a2 = houseRobber(temp2.length-1,temp2,dp);
        System.out.println(Math.max(a1,a2));
    }


    private static int houseRobber(int ind,int[] arr,int[] dp){
        if(ind==0) return arr[0];
        if(ind<0) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int p = arr[ind] + houseRobber(ind-2,arr,dp);
        int np = houseRobber(ind-1,arr,dp);
        return Math.max(p,np);
    }
}
