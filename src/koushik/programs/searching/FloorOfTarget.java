package koushik.programs.searching;

public class FloorOfTarget {
    public static void main(String[] args) {
        int[] arr= {2,7,11,15};
        int target=33;
        System.out.println(floorBS(arr,target));
    }
    public static int floorBS(int[] nums,int x) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]>=x)
                r=m-1;
            else
                l=m+1;
        }
        return l-1;
    }
}
