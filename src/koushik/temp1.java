package koushik;

import java.util.*;

public class temp1 {
    public static void main(String[] args) {
        // The array elements
        int arr[] = {1,1,0,0,0,1,1,1};
//        System.out.println("The subarrays are-");
//        SubArrays(arr, 0, 0,-1);
        System.out.println(findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {
        Map < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public static void SubArrays(int[] arr, int head, int tail,int length) {

        if (tail == arr.length)
            return;
        else if (head > tail) {
            SubArrays(arr, 0, tail + 1,length);
        } else {
            int z = 0;
            int o = 0;

            for (int i = head; i < tail; i++)
                System.out.print(arr[i] + " ");
            System.out.println(arr[tail]);
            SubArrays(arr, head + 1, tail,length);
        }
        return;
    }
}