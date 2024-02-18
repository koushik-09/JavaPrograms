package Leetcode;

public class luckyInt {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
    public static int findLucky(int[] arr) {
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        int[] freq=new int[max+1];
        for(int i:arr){
            freq[i]++;
        }
        max=-1;
        for(int i=1;i< freq.length;i++){
            if(freq[i]==i){
                if(freq[i]>max) max=freq[i];
            }
        }
        return 0;
    }
}
