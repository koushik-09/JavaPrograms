package koushik.recursion;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr = {1,2,7,5};
        System.out.println(sorted(arr,0));
    }
    public static boolean sorted(int[] arr,int ind){
        if(ind==arr.length-1){
            return true;
        }
        if(arr[ind]<arr[ind+1]){
            return sorted(arr,++ind);
        }
        return false;
    }
}
