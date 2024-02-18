package Leetcode;

public class coins {
    public static void main(String[] args) {
        int n=15;
        System.out.println(arrangeCoins(n));
    }
    public static int arrangeCoins(int n) {
        return noOfRows(n,1,0);
    }
    public static int noOfRows(int n,int next,int row){
        if(n<next) return row;
        return noOfRows(n-next,next+1,++row);
    }
}
