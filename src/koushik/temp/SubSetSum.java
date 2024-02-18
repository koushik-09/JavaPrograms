package koushik.temp;
import java.util.*;
public class SubSetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        int sum=sc.nextInt();
        int[][] mat = new int[n+1][sum+1];
        for(int i=0;i<mat.length;i++){
            mat[i][0]=1;
        }
        int upSum=0;
        for(int i=1;i< mat.length;i++){
            upSum+=arr[i];
            for(int j=1;j<mat[0].length;j++){
                if(j<arr[i]){
                    mat[i][j]=mat[i-1][j];
                    continue;
                }
                int temp=j;
                while(temp<=upSum && temp!=0){
                    if(temp==arr[i]){
                        mat[i][j]=1;
                        temp=temp-arr[i];
                    }
                    else{
                        int t2=temp-arr[i];
                        if(t2>=0 && t2<=sum){
                            if(mat[i-1][t2]==1){
                                mat[i][j]=1;
                                temp-=t2;
                            }
                            else{
                                temp=0;
                            }
                        }
                        else{
                            temp=0;
                        }
                    }
                }
            }
        }
        for(int[] i : mat){
            System.out.println(Arrays.toString(i));
        }
    }
}
