package koushik.temp;

import java.util.Arrays;
import java.util.Scanner;

class Ac3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int n = sc.nextInt();
        if(n==0){
            System.out.println(str);
            return;//s h i v a
        }
        n =n% str.length();
        char[] strs = str.toCharArray();
        while (n!=0){
            for(int i=0;i< strs.length;i++){
                char temp=strs[i];
                strs[i]=strs[strs.length-1];
                strs[strs.length-1]=temp;
            }
            n--;
        }
        str="";
        for(char ch : strs){
            str+=ch;
        }
        System.out.println(str);
    }
}
