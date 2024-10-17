package koushik.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> arr = new ArrayList<>();
        subSets(list,arr,0);
//        subSetOfSizeK(list,arr,0,2);
//        subSetSumEqualK(list,arr,0,0,5);
//        System.out.println(subSetProductSum(list,arr,0,0,3));
//        System.out.println(subSetMinMaxSum(list,arr,0,2));
//        System.out.println(subSetSumDivisibleByK(list,arr,0,2,0));
//        stringSubSet("ggg",new ArrayList<>(),"",0);
//        stringSpacePermutations("abc","",0);
//        caseChange("abc","",0);
//        stringPermutation("ABC","");
    }
    public static void subSets(List<Integer> list,List<Integer> arr,int i) {
        if(i==list.size()){
            System.out.println(arr);
            return;
        }
        arr.add(list.get(i));
        subSets(list,arr,i+1);
        arr.remove(arr.size()-1);
        subSets(list,arr,i+1);
    }
    public static void subSetOfSizeK(List<Integer> list,List<Integer> arr,int i,int k){
        if(i==list.size()){
            if( arr.size()==k) {
                System.out.println(arr);
            }
            return;
        }
        arr.add(list.get(i));
        subSetOfSizeK(list,arr,i+1,k);
        arr.remove(arr.size()-1);
        subSetOfSizeK(list,arr,i+1,k);
    }
    public static void subSetSumEqualK(List<Integer> list,List<Integer> arr,int i,int c,int k){
        if(i==list.size()){
            if(c==k){
                System.out.println(arr);
            }
            return;
        }
        arr.add(list.get(i));
        c+= list.get(i);
        subSetSumEqualK(list,arr,i+1,c,k);
        c-=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        subSetSumEqualK(list,arr,i+1,c,k);
    }
    public static int subSetProductSum(List<Integer> list,List<Integer> arr,int i,int c,int k){
        if(i==list.size()){
            if(arr.size()==k){
                int prod =1;
                for(int x : arr){
                    prod*=x;
                }
                return prod;
            }
            return 0;
        }
        arr.add(list.get(i));
        int a = subSetProductSum(list,arr,i+1,c,k);
        arr.remove(arr.size()-1);
        int b = subSetProductSum(list,arr,i+1,c,k);
        return a+b;
    }
    public static int subSetMinMaxSum(List<Integer> list,List<Integer> arr,int i,int k){
        if(i==list.size()){
            if( arr.size()==k) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int x : arr){
                    if(x<min){
                        min=x;
                    }
                }
                for(int x : arr){
                    if(x>max){
                        max=x;
                    }
                }
                return max-min;
            }
            return 0;
        }
        arr.add(list.get(i));
        int l = subSetMinMaxSum(list,arr,i+1,k);
        arr.remove(arr.size()-1);
        int r = subSetMinMaxSum(list,arr,i+1,k);
        return l+r;
    }
    public static int subSetSumDivisibleByK(List<Integer> list,List<Integer> arr,int i,int k,int count){
        if(i==list.size()){
            System.out.println(arr);
            int sum = 0;
            for(int x : arr){
                sum+=x;
            }
            if(sum!=0 && sum%k==0){
               return 1;
            }
            return 0;
        }
        arr.add(list.get(i));
        int l = subSetSumDivisibleByK(list,arr,i+1,k,count);
        arr.remove(arr.size()-1);
        int r = subSetSumDivisibleByK(list,arr,i+1,k,count);
        return l+r;
    }
    public static void stringSubSet(String str,List<String> list,String temp,int i){
        if(i==str.length()){
            if(!list.contains(temp)){
                list.add(temp);
                System.out.println("\""+temp+"\"");
            }
            return;
        }
        temp+=str.charAt(i);
        stringSubSet(str,list,temp,i+1);
        temp=temp.substring(0,temp.length()-1);
        stringSubSet(str,list,temp,i+1);
    }
    public static void stringSpacePermutations(String str,String temp,int i){
        if(i==str.length()){
            System.out.println(temp);
            return;
        }
        stringSpacePermutations(str,temp+" "+str.charAt(i),i+1);
        stringSpacePermutations(str,temp+str.charAt(i),i+1);
    }
    public static void caseChange(String str,String temp,int i){
        if(i==str.length()){
            System.out.println(temp);
            return;
        }
        caseChange(str,temp+Character.toLowerCase(str.charAt(i)),i+1);
        caseChange(str,temp+Character.toUpperCase(str.charAt(i)),i+1);
    }
    public static void stringPermutation(String str,String temp){
        if(str.isEmpty()){
            System.out.println(temp);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            stringPermutation(remaining, temp + ch);
        }
    }
}
