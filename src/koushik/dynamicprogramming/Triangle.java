package koushik.dynamicprogramming;
import java.util.*;
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
//        List<Integer> l = new ArrayList<>(List.of(2));
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3,4)));
        triangle.add(new ArrayList<>(List.of(6,5,7)));
        triangle.add(new ArrayList<>(List.of(4,1,8,3)));
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
//        System.out.println(minimumTotal(0,0,triangle.size()-1,triangle));
        System.out.println(minimumTotal(0,0,triangle.size()-1,triangle,dp));
    }
    public static int minimumTotal(int i,int j,int ind,List<List<Integer>> triangle) {
        if(i==ind) return triangle.get(i).get(j);
        int d1 = triangle.get(i).get(j)+minimumTotal(i+1,j,ind,triangle);
        int d2 = triangle.get(i).get(j)+minimumTotal(i+1,j+1,ind,triangle);
        return Math.min(d1,d2);
    }
    public static int minimumTotal(int i,int j,int ind,List<List<Integer>> triangle,int[][] dp) {
        if(i==ind) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];

        int d1 = triangle.get(i).get(j)+minimumTotal(i+1,j,ind,triangle,dp);
        int d2 = triangle.get(i).get(j)+minimumTotal(i+1,j+1,ind,triangle,dp);
        return dp[i][j] = Math.min(d1,d2);
    }
}
