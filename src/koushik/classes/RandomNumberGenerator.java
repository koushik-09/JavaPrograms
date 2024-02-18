package koushik.classes;
import java.util.*;

public class RandomNumberGenerator {
    Random random = new Random();
    public int[] generateRandom(int n){
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(1000);//gives random number in 0-999 range
        }
        return arr;
    }
}
