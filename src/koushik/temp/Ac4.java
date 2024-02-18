package koushik.temp;
import java.util.*;
public class Ac4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        int totalSum=((r*c)*(r*c+1))/2;
        for(int i=0;i<n;i++){
            char ch =sc.next().charAt(0);
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(ch=='c'){
                int res=((2*x*r)+(r*(r-1)*c))/2;
                if(y>1){
                    totalSum=totalSum+(res*(y-1));
                }
                else if(y==0 || y==-1){
                    totalSum=totalSum-res;
                }
                else{
                    y=y*(-1);
                    totalSum=totalSum-(res*y);
                }
            }
            if(ch=='r'){
                int r1sum=(c*(c+1))/2;
                int res=r1sum;
                if(x>1){
                    res=c*c*x+r1sum;
                }
                if(y>1){
                    totalSum=totalSum+(res*(y-1));
                }
                else if(y==0 || y==-1){
                    totalSum=totalSum-res;
                }
                else{
                    y=y*(-1);
                    totalSum-=res*y;
                }
            }
        }
        System.out.println(totalSum);

    }
}
