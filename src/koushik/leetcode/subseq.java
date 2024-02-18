package Leetcode;

public class subseq {
    public static void main(String[] args) {
        String ip="abc";
        String op="";
        subseq(ip,op);
    }
    public static void subseq(String ip,String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }
        subseq(ip.substring(1),op+ip.charAt(0));
        subseq(ip.substring(1),op);
    }
}
