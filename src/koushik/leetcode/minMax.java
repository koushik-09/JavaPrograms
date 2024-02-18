package koushik.leetcode;

public class minMax {
    public static void main(String[] args) {
        int[] nums = {4,6,12,5,7,3,5};
        System.out.println(minimizeArrayValue(nums));
    }
    public static int  minimizeArrayValue(int[] nums) {
        int curmax=maxNum(1, nums.length, nums)[0];
        if(nums[0]>=curmax){
            return nums[0];
        }
        return temp(nums,-1,curmax,maxNum(1, nums.length, nums)[1],curmax);

    }
    public static int temp(int[] nums,int prevmax,int curmax,int ind,int min){
//        if(nums[0]>=curmax){
//            return min;
//        }
        nums[ind]--;
        nums[ind-1]++;
        prevmax=curmax;
        curmax=maxNum(1,nums.length,nums)[0];
        ind=maxNum(1,nums.length,nums)[1];
        if(curmax<min){
            min=curmax;
        }
        if(nums[0]<curmax) {
            return temp(nums, prevmax, curmax, ind, min);
        }
        return min;
    }
    public static int[] maxNum(int s,int e,int[] arr){
        int[] max=new int[2];
        for(int i=s;i<e;i++){
            if(arr[i]>max[0]){
                max[0]=arr[i];
                max[1]=i;
            }
        }
        return max;
    }
}
