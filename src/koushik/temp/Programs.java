package koushik.temp;
import javax.lang.model.type.ArrayType;
import java.util.*;
public class Programs {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        binaryToDecimal();
//        removeDuplicates();
//        System.out.println(linearSearch(new int[]{1,2,3,4,5},3));
//        System.out.println(recursiveLinearSearch(new int[]{1,2,3,4,5},0,-1));
//        cube();
//        seperateNumbers();
//        rangeNumbers();
//        System.out.println(squareRoot(80));
        swapArray();
    }
    private static void swapArray(){
        int[] arr1 ={1,2,3,4,5};
        int[] arr2 = {6,7,8,9,
                10};
        for(int i=0;i<arr1.length;i++){
            arr1[i]=arr1[i]+arr2[i];
            arr2[i]=arr1[i]-arr2[i];
            arr1[i]=arr1[i]-arr2[i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    private static int squareRoot(int n){
        int s=1;
        int e=n/2;
        int m=s+(e-s)/2;
        while(s<=e){
            m=s+(e-s)/2;
            if(m==n/m){
//                System.out.println(m);
                return m;
            }
            else if(m > n/m){
                e=m-1;
            }
            else if(m < n/m){
                s = m + 1;
            }
        }
        if(m > n/m){
            return m-1;
        }
        return m;
    }
    private static void rangeNumbers(){
        for(int i=100;i<=200;i++){
            int temp=i;
            int sum=0;
            while(temp>0){
                int rem=temp%10;
                sum+=rem;
                temp=temp/10;
            }
            if(sum%2==0){
                System.out.print(i+" ");
            }
        }
    }
    private static void seperateNumbers(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int evenCount=0;
        int oddCount=0;
        for(int i : arr){
            if(i%2==0){
                evenCount++;
                continue;
            }
            oddCount++;
        }
        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];
        evenCount=0;
        oddCount=0;
        for(int i : arr){
            if(i%2==0){
                even[evenCount++]=i;
            }
            else{
                odd[oddCount++]=i;
            }
        }
        System.out.println(Arrays.toString(even));
        System.out.println(Arrays.toString(odd));
    }
    private static void cube(){
        int n = sc.nextInt();
        System.out.println((int)Math.pow(n,3));
    }
    private static int linearSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    private static int recursiveLinearSearch(int[] arr,int ind,int target){
        if(ind==arr.length){
            return -1;
        }
        if(arr[ind]==target){
            return ind;
        }
        return recursiveLinearSearch(arr,++ind,target);
    }
    private static void removeDuplicates(){
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int min=arr[0];
        int max=arr[0];
        for(int i : arr){
            if(i<min) min=i;
        }
        for(int i : arr){
            if(i>max) max=i;
        }
        int[] freq = new int[max+(-1*min)+1];
        for(int i : arr){
            freq[i-min]++;
        }
        int count=0;
        for(int i : freq){
            if(i>0){
                count++;
            }
        }
        int ind=0;
        int[] ans = new int[count];
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                ans[ind++]=i+(min);
            }
        }
        System.out.println(Arrays.toString(ans));

    }
    private static void binaryToDecimal(){
        String num = sc.nextLine();
        int dec=0;
        int i=0;
        while(num.length()!=0){
            String rem=num.charAt(num.length()-1)+"";
            dec=dec+Integer.parseInt(rem)*(int)Math.pow(2,i);
            num=num.substring(0,num.length()-1);
            ++i;
        }
        System.out.println(dec);
    }
}
