package koushik.dynamicprogramming;

public class CherryPickup {
    public static void main(String[] args) {
        int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
        System.out.println(cherryPickup(0,0,grid.length-1,grid));
    }
    private static int cherryPickup(int i,int j,int n,int[][] grid){
        if(i==n && j==n){
            if(grid[i][j]==-1){
                return -1000001;
            }
            return grid[i][j];
        }
        if(grid[i][j]==-1) return -1000001;
        if(j>=n) return -1;
        int d=Integer.MIN_VALUE;
        int r=Integer.MIN_VALUE;
        if(i<n){
            d = grid[i][j]+cherryPickup(i+1,j,n,grid);
        }
        if(j<n){
            r = grid[i][j]+cherryPickup(i,j+1,n,grid);
        }
        return Math.max(d,r);
    }
}
