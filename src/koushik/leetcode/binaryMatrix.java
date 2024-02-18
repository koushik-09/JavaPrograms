package Leetcode;

public class binaryMatrix {
    public static void main(String[] args) {
        int[][] arr = {{0,0},{0,0},{1,0}};
        System.out.println(numSpecial(arr));
    }
    public static int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    if(rowCheck(mat,i) && colCheck(mat,j)) count++;
                }
            }
        }
        return count;
    }
    public static boolean rowCheck(int[][] mat,int r){
        int count=0;
        for(int i=0;i<mat[0].length;i++){
            if(mat[r][i]==1){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }
    public static boolean colCheck(int[][] mat,int c){
        int count=0;
        for(int i=0;i<mat[0].length;i++){
            if(mat[i][c]==1){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }
}
