package koushik.recursion;

import java.util.*;

public class Recursion { 
    public static void main(String[] args) {
        int[] arr = {1};
//        reverse(arr,0);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(isPalindrome("bbbbb",0));
//        System.out.println(fibonacci(200));
//        subsequence(0,new ArrayList<>(),new int[]{1,2,3},3);
        System.out.println(subSequenceSum(0,new int[]{1,1,1},0,2,0));
    }
    private static boolean isPalindrome(String str,int i){
        if(i>str.length()/2){
            return true;
        }
        if(str.charAt(i)!=str.charAt(str.length()-1-i)){
            return false;
        }
        return isPalindrome(str,i+1);
    }

    private static void reverse(int[] arr,int i) {
        if(i== arr.length/2){
            return;
        }
        int temp=arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i]=temp;
        reverse(arr,i+1);
    }
    private static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    private static void subsequence(int i,ArrayList<Integer> list,int[] arr,int n){
        if(i==n){
            System.out.println(list);
            return;
        }
        subsequence(i+1,list,arr,n);
        list.add(arr[i]);
        subsequence(i+1,list,arr,n);
        list.remove(list.size()-1);

    }
    private static int subSequenceSum(int i,int[] arr,int sum,int tar,int count){
        if(sum==tar){
            return 1;
        }
        if(i==arr.length){
//            System.out.println(list);
            return 0;
        }

//        list.add(arr[i]);
        sum+=arr[i];
        int l= subSequenceSum(i+1,arr,sum,tar,count);
        sum-=arr[i];
//        list.removeLast();
        int r = subSequenceSum(i+1,arr,sum,tar,count);
        return l+r;
    }

}
