package koushik.classes;

import java.util.*;
import java.util.Arrays;

public class Temp {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("the","sky","is","blue"));
        System.out.println(list);
        String str=join(list);
        System.out.println(str.substring(0,str.length()-1));
    }
    public static String join(List<String> list){
        if(list.isEmpty()){
            return "";
        }
        return join(list.subList(1,list.size()))+list.get(0)+" ";
    }
}
