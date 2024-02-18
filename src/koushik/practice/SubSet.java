package koushik.practice;
import java.util.*;
public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
//        System.out.println(permutations(arr));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,1,arr.length)));
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> permutations(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        subSets(ans,new ArrayList<>(),arr,2);
        return ans;
    }
    public static void subSets(List<List<Integer>> ans,List<Integer> l1,int[] arr,int x){
        if(arr.length==0) {
            ans.add(l1);
            return;
        }
        if(l1.isEmpty()){
            l1.add(arr[0]);
            arr=Arrays.copyOfRange(arr,1,arr.length);
        }
        for(int i=0;i< x;i++){
            l1.add(i,arr[0]);
            System.out.println(l1);
            subSets(ans,l1,Arrays.copyOfRange(arr,1,arr.length),++x);
            x--;
        }
    }
//    static List<List<Integer>> ans = new ArrayList<>();
    public static List<int[]> subsets(int[] nums) {
        ArrayList<int[]> list = new ArrayList<>();
        temp(new int[0],nums,list);
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] a : list){
            
        }
        return list;
    }
    public static void temp(int[] arr1, int[] arr2, List<int[]> list){
        if(arr2.length==0){
            list.add(arr1);
            return;
        }
        temp(arr1,Arrays.copyOfRange(arr2,1,arr2.length),list);
        int[] t1 = new int[arr1.length+1];
        for(int i=0;i<arr1.length;i++){
            t1[i]=arr1[i];
        }
        t1[t1.length-1]=arr2[0];
        temp(t1,Arrays.copyOfRange(arr2,1,arr2.length),list);
    }
}
