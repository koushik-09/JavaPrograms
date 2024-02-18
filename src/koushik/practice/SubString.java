package koushik.practice;

import java.util.ArrayList;

public class SubString {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        subStrings("","abc",list);
        System.out.println(list);
    }
    public static void subStrings(String s1,String s2,ArrayList<String> list){
        if(s2.length()==0){
            list.add(s1);
            return;
        }
        subStrings(s1,s2.substring(1),list);
        subStrings(s1+s2.charAt(0),s2.substring(1),list);
    }
}
