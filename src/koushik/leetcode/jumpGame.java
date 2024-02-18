package koushik.leetcode;

public class jumpGame {
    public static void main(String[] args) {
//        int[] arr= {2,3,1,1,4};
        System.out.println(bulbSwitch(12));
    }
    public static int bulbSwitch(int n) {
        int count=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i+=n){
            arr[i]=1;
        }
//        for(int i=1;i<=n;i++){
//            for(int j=0;j<n;j+=i){
//                if(arr[j]==0){
//                    arr[j]=1;
//                }
//                else{
//                    arr[j]=0;
//                }
//            }
//        }
        for(int i : arr){
            if(i==1){
                count++;
            }
        }
        return count;
    }
//    static int ind=0;
//    static int min=0;
//    static int cost=0;
//    public static int jump(int[] nums) {
//        if(nums[ind]==0 || nums[ind]==nums[nums.length-1]){
//            return Math.max(cost, min);
//        }
//        else{
//            for(int i=ind+1;i<=nums[ind];i++){
//
//
//            }
//        }
    }
