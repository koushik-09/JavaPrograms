package koushik.practice;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        //arr1 and arr2 must be sorted
        int[] arr1 = {1,2,3,9};
        int[] arr2 ={4,5,6};
        System.out.println(Arrays.toString(mergeArray(arr1,arr2)));
    }
    public static int[] mergeArray(int[] arr1,int[] arr2){
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
