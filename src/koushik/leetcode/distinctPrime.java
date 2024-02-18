package koushik.leetcode;
import java.util.*;
public class distinctPrime{
    public static void main(String[] args) {
        int[] arr ={2,4,3,7,10,6};
        System.out.println(distinctPrimeFactors(arr));
//        System.out.println(isPrime(33113968374981l));
//        System.out.println(nextPrime(13l));
    }
    public static int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        for(int i : nums){
            temp.add(i);
        }
        for(int i : temp){
            primeFactors(i,set);
        }
        return set.size();
    }

    public static void primeFactors(int n,HashSet<Integer> set){
        int prime=2;
        while(n>1){
            if(isPrime(n)){
                set.add(n);
                return;
            }
            else{
                if(n%prime==0){
                    while((n%prime)==0){
                        n=n/prime;
                        set.add(prime);
                    }

                }
                prime=nextPrime(prime);
            }
        }
    }
    public static int nextPrime(int n){
        n++;
        while(true){
            int c=0;
            for(int i=2;i<(int)(Math.sqrt(n)+1);i++){
                if(n%i==0){
                    c=1;
                    break;
                }
            }
            if(c==0){
                return n;
            }
            else n++;
        }
    }
    public static boolean isPrime(int n){
        for(int i=2;i<(int)(Math.sqrt(n)+1);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
