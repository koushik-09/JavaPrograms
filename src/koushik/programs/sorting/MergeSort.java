package koushik.programs.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    private static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int m =arr.length/2;
        int[] left=  mergeSort(Arrays.copyOfRange(arr,0,m));
        int[] right=  mergeSort(Arrays.copyOfRange(arr,m,arr.length));
        return mergeArray(left,right);
    }
    private static int[] mergeArray(int[] arr1,int[] arr2){
        
        int i=0,j=0;
        int[] ans = new int[arr1.length+arr2.length];
        int ind=0;
        while(i< arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                ans[ind++]=arr1[i++];
            }
            else if(arr1[i]>=arr2[j]){
                ans[ind++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            ans[ind++]=arr1[i++];
        }
        while(j< arr2.length){
            ans[ind++]=arr2[j++];
        }
        return ans;
    }
}
