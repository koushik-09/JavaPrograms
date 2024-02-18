package Leetcode;

public class firstOccurence {
    public static void main(String[] args) {
        String haystack="mississippi";
        String needle="issipi";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        for(int i=0;i<haystack.length()-(needle.length()-1);i++){
            int j=0;
            int t=i;
            while(j<needle.length()){
                if(haystack.charAt(t)!=needle.charAt(j)){
                    break;
                }
                j++;
                t++;
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
