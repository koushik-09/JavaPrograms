package koushik.programs.searching;

public class BinarySearch {
    public static void main(String[] args) {

    }
    public static int binarySearch(int[] arr,int target){
        int s=0,e=arr.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m]<target){
                s=m+1;
            }
            else if(arr[m]>target){
                e=m-1;
            }
            else
                return m;
        }
        return -1;
    }
}
