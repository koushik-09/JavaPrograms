package koushik.recursion;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {0,1};
        helper(arr,new int[arr.length],ans,new ArrayList<>());
        System.out.println(ans);
    }

    private static void helper( int[] arr, int[] visited, List<List<Integer>> ans, List<Integer> list) {
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i< arr.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                list.add(arr[i]);
                helper(arr,visited,ans,list);
                visited[i]=0;
                list.removeLast();
            }
        }
    }
}
