package Leetcode;

public class day {
    public static void main(String[] args){
        System.out.println(dayOfYear("2016-02-29"));
    }
    public static int dayOfYear(String date) {
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        boolean isLeap=leapYear(Integer.parseInt(date.substring(0,4)));
        int l=1,h=Integer.parseInt(date.substring(5,7));
        int ans=0;
        if(h>1) {
            for (int i = l; i <h; i++) {
                ans = ans + days[i - 1];
            }
            ans=ans+Integer.parseInt(date.substring(8,10));
            if(isLeap && (h>2 || Integer.parseInt(date.substring(8,10))==29)) ans+=1;
        }
        else{
            ans=Integer.parseInt(date.substring(8,10));
        }
        return ans;
    }
    public static boolean leapYear(int n){
        if(n%400==0) return true;
        if(n%100==0) return false;
        if(n%4==0) return true;
        else return false;
    }
}
