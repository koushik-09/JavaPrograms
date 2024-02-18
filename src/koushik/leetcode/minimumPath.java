package Leetcode;

public class minimumPath {
    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(arr));
    }
    public static int minPathSum(int[][] grid) {
        int ans =temp(grid,1,0,0);
        return ans;
    }
    public static int temp(int[][] mat,int cost,int i,int j){
        if(i==mat.length && j==mat[0].length){
            return cost;
        }
//        else{
//            if((i+1)< mat.length){
//                cost+=mat[i+1][j];
//                Leetcode.temp(mat,cost,++i,j);
//                //System.out.println(cost);
//            }
//            if((j+1)< mat.length){
//                cost+=mat[i][j+1];
//                Leetcode.temp(mat,cost,i,++j);
//                //System.out.println(cost);
//            }
//        }
        else{
            if((i+1)<mat.length && (j+1)==mat[0].length){
                return temp(mat,cost+mat[i+1][j],++i,j);
            }
            else if((i+1)==mat.length && (j+1)<mat.length){
                return temp(mat,cost+mat[i][j+1],i,++j);
            }
//            else{
//                return Leetcode.temp(mat,cost+mat[i+1][j],++i,j);
//                //return Leetcode.temp(mat,cost+mat[i][j+1],i,++j);
//            }
        }
        System.out.println(cost);
        return cost;
    }
}
