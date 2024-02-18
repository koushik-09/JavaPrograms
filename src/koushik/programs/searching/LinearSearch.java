package koushik.programs.searching;

public class LinearSearch {
    public static void main(String[] args) {

    }
    public static int linearSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
