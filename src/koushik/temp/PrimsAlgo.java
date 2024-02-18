package koushik.temp;

import java.util.*;
import java.io.CharArrayReader;
import java.io.IOException;

public class PrimsAlgo {
    public static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {4, 5, 2, 25, 7, 18};
        int[] result = nextGreaterElement(nums);
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}

