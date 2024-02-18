package koushik.leetcode;

public class VowelCount {
    public static void main(String[] args) {
        System.out.println(maxVowels("aeiou",2));
    }
    public static int maxVowels(String str, int k) {
        int vowel=0,i=0,j=0;
        int max=0,temp=0;
        while(j<k-1){
            if(str.charAt(j)=='a' || str.charAt(j)=='e' || str.charAt(j)=='i' ||str.charAt(j)=='o' || str.charAt(j)=='u'){
                temp++;
            }
            j++;
        }
        max=temp;
        while(j<str.length()){
            i++;
            j++;
            if(j<str.length() && (str.charAt(j)=='a' || str.charAt(j)=='e' || str.charAt(j)=='i' ||str.charAt(j)=='o' || str.charAt(j)=='u')){
                temp++;
            }
            if(str.charAt(i-1)=='a' || str.charAt(i-1)=='e' || str.charAt(i-1)=='i' ||str.charAt(i-1)=='o' || str.charAt(i-1)=='u'){
                temp--;
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;

    }
}
