package koushik.programs.sorting;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int[] arr,int s,int e){
        if(e-s == 1){
            return;
        }
        int m =s+(e-s)/2;
        mergeSort(arr,0,m);
        mergeSort(arr,m,e);
        mergeArray(arr,0,m,e);
    }
    private static void mergeArray(int[] arr,int s,int m,int e){
        int[] temp=new int[e-s];
        int i=s;
        int j=m;
        int ind=0;
        while(i<m && j<e){
            if(arr[i]<arr[m]){
                temp[ind++]=arr[i++];
            }
            else{
                temp[ind++]=arr[j++];
            }
        }
        while(i<m){
            temp[ind++]=arr[i++];
        }
        while(j<e){
            temp[ind++]=arr[j++];
        }
        for(int x=0;x<temp.length;x++){
            arr[s+x]=temp[x];
        }
    }
}
