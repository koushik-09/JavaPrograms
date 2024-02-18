package Leetcode;

public class kokoBanana {
    public static void main(String[] args) {
        int[] arr=  {159061844,517725047,376711793,557608450,386051217,915761849,443805917,541997964,420003629};
        int h= 771473915;
        System.out.println(minEatingSpeed(arr,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int ans=0;
        int e=Integer.MIN_VALUE;
        int sum=0;
        for(int i: piles){
            sum+=i;
            if(i>e) e=i;
        }
        int s= (sum%h==0) ? (sum/h) : ((sum+(h-(sum%h)))/h);
        while(s<=e){
            int m=s+(e-s)/2;
            ans=m;
            int temp=0;
            for(int i : piles){
                temp=temp+((i%m==0) ? (i/m) : ((i+(m-(i%m)))/m));
            }
            if(temp==h){
                e=m;
            }
            else if(temp<h){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
}
