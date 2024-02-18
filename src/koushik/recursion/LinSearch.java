package koushik.recursion;

import java.util.ArrayList;

public class LinSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,8,9};
        System.out.println(linearSearch(arr,0,15));
        ArrayList<Integer> list = new ArrayList<>();
        linearSearchAll(arr,0,8,list);
        System.out.println(list);
        System.out.println(linearSearchAll2(arr,0,8));
    }
    public static int linearSearch(int[] arr,int ind,int target){
        if(ind==arr.length){
            return -1;
        }
        if(arr[ind]==target){
            return ind;
        }
        return linearSearch(arr,++ind,target);
    }
    public static void linearSearchAll(int[] arr,int ind,int target,ArrayList<Integer> list){
        if(ind==arr.length){
            return;
        }
        if(arr[ind]==target){
            list.add(ind);
        }
        linearSearchAll(arr,++ind,target,list);
    }
    public static ArrayList<Integer> linearSearchAll2(int[] arr, int ind, int target){
        ArrayList<Integer> list =new ArrayList<>();
        if(ind==arr.length){
            return list;
        }
        if(arr[ind]==target){
            list.add(ind);
        }
        ArrayList<Integer> temp = linearSearchAll2(arr,++ind,target);
        list.addAll(temp);
        return list;
    }
}
