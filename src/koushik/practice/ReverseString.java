package koushik.practice;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("abcd",""));
    }
    public static String reverse(String s1,String s2){
        if(s1.length()==0){
            return s2;
        }
        return reverse(s1.substring(1),s1.charAt(0)+s2);
    }
}
