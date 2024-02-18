package Leetcode;

public class deleteColums {
    public static void main(String[] args) {
        String[] strs={"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs));
    }
    public static int minDeletionSize(String[] strs) {
        //int j=0,col=0;
//        for(int i=0;i<strs[0].length();i++){
//            while(j<strs[0].length()){
//                if(strs[0].charAt(i)<strs[j].charAt(i)) continue;
//                else{
//                    col++;
//                    j++;
//                    break;
//                }
//                j++;
//            }
//        }
        int col=0;
        for(int i=0;i<strs[0].length();i++){
            int j=0;
            while(j< strs.length){
                if(j!=0 && strs[0].charAt(i)<strs[j].charAt(i)){
                    continue;
                }
                else{
                    col++;
                }
                j++;
            }
        }
        return col;
    }
}
