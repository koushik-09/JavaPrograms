package koushik.temp;
import java.util.*;
public class Accenture2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int i=0;
        while(n!=0){
            String str = a+""+i;
            int x=Integer.parseInt(str);
            if(x%b==0){
                n--;
                a=x;
                i=0;
            }
            else
                i++;
        }
        System.out.println(a);
    }
}
