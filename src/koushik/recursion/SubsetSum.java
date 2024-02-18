package koushik.recursion;

import java.util.*;
import java.util.stream.Collector;

public class SubsetSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1,2,3};
        helper(0,arr,0,list);
        Collections.sort(list);
        System.out.println(list);
    }
    private static void helper(int ind,int[] arr,int sum,List<Integer> list){
        if(ind==arr.length){
            list.add(sum);
            return;
        }
        sum+=arr[ind];
        helper(ind+1,arr,sum,list);
        sum-=arr[ind];
        helper(ind+1,arr,sum,list);
    }
}
