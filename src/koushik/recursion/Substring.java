package koushik.recursion;

import java.util.*;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        String ans="";
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            Arrays.fill(freq,0);
            String temp="";
            for(int j=i;j<str.length();j++){
                if((freq[(int)str.charAt(j)-97]==0)){
                    freq[(int)str.charAt(j)-97]++;
                    temp+=str.charAt(j);
                }
                else{
                    if(ans.length()<temp.length()){
                        ans=temp;
                        temp="";
                        Arrays.fill(freq,0);
                        j--;
                    }
                    else{
                        temp="";
                        Arrays.fill(freq,0);
                    }
                }
                if(j==str.length()-1){
                    if(ans.length()<temp.length()){
                        ans=temp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
