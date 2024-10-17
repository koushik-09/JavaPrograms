package koushik.dynamicprogramming;

import java.util.ArrayList;

public class StringPermutations {
    
    // Function to find permutations of a string with spaces
    public static void permute(String str, int index, String current, ArrayList<String> result) {
        if (index == str.length()) {
            result.add(current);
            return;
        }
        permute(str, index + 1, current + " " + str.charAt(index), result);
        permute(str, index + 1, current + str.charAt(index), result);
    }
    
    // Function to print all permutations of a string with spaces
    public static void printPermutations(String str) {
        ArrayList<String> result = new ArrayList<>();
        permute(str, 0, "", result);
        for (String permutation : result) {
            System.out.println(permutation);
        }
    }
    
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Permutations of " + str + " with spaces:");
        printPermutations(str);
    }
}
