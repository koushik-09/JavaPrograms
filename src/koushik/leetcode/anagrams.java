package koushik.leetcode;
import koushik.classes.RandomNumberGenerator;

import java.util.*;
//if time complexity is ignored
public class anagrams {
    public static void main(String[] args) {
        RandomNumberGenerator x=  new RandomNumberGenerator();
        String[] arr= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i< strs.length;i++) {
            if (!Objects.equals(strs[i], "-1")) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                int[] freq1 = new int[26];
                for (int x = 0; x < strs[i].length(); x++) {
                    freq1[((int) strs[i].charAt(x) - 97)]++;
                }
                for (int j = i + 1; j < strs.length; j++) {
                    if (!Objects.equals(strs[j], "-1")) {
                        int[] freq2 = new int[26];
                        for (int x = 0; x < strs[j].length(); x++) {
                            freq2[((int) strs[j].charAt(x) - 97)]++;
                        }
                        boolean isAnagram = false;
                        for (int y = 0; y < freq1.length; y++) {
                            if (freq1[y] == freq2[y]) {
                                if (y == freq1.length - 1) {
                                    isAnagram = true;
                                } else
                                    continue;
                            } else {
                                break;
                            }
                        }
                        if (isAnagram) {
                            temp.add(strs[j]);
                            strs[j] = "-1";
                        }
                    }
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
