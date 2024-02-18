package koushik.temp;
import java.util.*;
public class Accenture1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        temp(str);
//        System.out.println(Integer.toString(1).charAt(0));
    }
    public static void temp(String str){
        int[] arr = new int[2];
        int ind=0;
        String[] list = str.split("=");
        str=list[0];
        String str1="";
        String str2="";
        String str3=list[1];
        char op='a';
        boolean temp1=false;
        while(ind<str.length()){
            if(!temp1){
                if(helper(str.charAt(ind))){
                    str1=str1+str.charAt(ind);
                }
                else{
                    op=str.charAt(ind);
                    temp1=true;
                    ind++;
                    continue;
                }
            }
            else{
                str2+=str.charAt(ind);
            }

            ind++;
        }
        System.out.println(str1+" "+str2+" "+str3+" "+op);
        for(int i=0;i<=9;i++){
            String x="";
            x=str1.replace('?', Integer.toString(i).charAt(0));
            int num1=Integer.parseInt(x);
            int num2=Integer.parseInt(str2);
            int[] arr1 = eval(num1,num2,str3,op);
            if(arr1[0]!=-1){
                arr[0]=i;
                arr[1]=arr1[1];
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int[] eval(int a,int b,String str,char ch){
        int[] arr = new int[2];
        int res=0;
        switch(ch){
            case '*'-> res= a *b;
            case '-'-> res= a -b;
            case '/'-> res= a /b;
            case '+'-> res= a +b;
            case '%'-> res= a %b;
        }
        String temp=res+"";
        int ind=0;
        while(ind<temp.length()){
            if(str.charAt(ind)!='?'){
                if(temp.charAt(ind)!=str.charAt(ind)){
                 arr[0]=-1;
                }
            }
            ind++;
        }
        ind=0;
        while(ind<str.length()){
            if(str.charAt(ind)=='?'){
                arr[1]=temp.charAt(ind)-'0';
            }
            ind++;
        }
        return arr;
    }
    public static boolean helper(char ch){
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('1','2','3','4','5','6','7','8','9','0','?'));
        return list.contains(ch);
    }
}
