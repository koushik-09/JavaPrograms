package koushik.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSorted {
    public static void main(String[] args) {
        int[] l = {6, 2, 4, 10};
        int min = 100001;

        // Finding the minimum absolute difference
        for (int i = 1; i < l.length; i++) {
            int diff = Math.abs(l[i - 1] - l[i]);
            if (min > diff) {
                min = diff;
            }
        }

        // Sort the array
        Arrays.sort(l);

        // Find all pairs with the minimum absolute difference
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < l.length - 1; i++) {
            for (int j = i + 1; j < l.length; j++) {
                if (Math.abs(l[i] - l[j]) == min) {
                    String s = l[i] + " " + l[j];
                    ans.add(s);
                }
            }
        }

        // Print the results
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
