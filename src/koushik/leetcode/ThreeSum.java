package koushik.leetcode;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr ={-1,0,1,0};
        System.out.println(threeSum(arr));
     }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        int min=-1,max=0;
        for(int i : nums){
            if(i<=min){
                min=i;
            }
        }
        for(int i : nums){
            if(i>=max){
                max=i;
            }
        }
        int[] f1 = new int[max-min+1];
        int[] f2 = new int[max-min+1];
        for(int i : nums){
            f1[i-min]++;
            f2[i-min]++;
        }
        int temp=0;
        for(int i=0;i<f1.length;i++){
            temp=0;
            if(f1[i]>0){
                List<Integer> list = new ArrayList<>();
                temp=(i+min);
                list.add(temp);
                f1[i]--;
                f2[i]--;
                for(int j=i;j<f1.length;j++){
                    if(f1[j]>0){
                        list.add(j+min);
                        temp=(temp+(j+min))*-1;
                        if(min<=(temp) && (temp)<=max){
                            if(f2[(temp)-min]>0){
                                list.add((temp));
                                break;
                            }
                            else{
                                list.clear();
                            }
                        }
                        else{
                            list.clear();
                        }
                    }
                }
                if(list.size() == 3){
                    Collections.sort(list);
                    if(!ans.contains(list)){
                        ans.add(list);
                    }
                }
                f1[i]++;
            }
        }
        return ans;
    }
}
