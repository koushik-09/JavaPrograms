package Leetcode;

public class zigzagConversion {
    public static void main(String[] args) {
        String str ="Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        int n=3;
        System.out.println(str.length());
        System.out.println(convert(str,n));
    }
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;
        int cn=(numRows*2)+(numRows-2);
        int r=(s.length()%numRows==0)? (s.length()/numRows) : ((s.length()-1+(cn-(s.length()-1)%cn))/cn);
        int c=numRows;
        char[][] arr = new char[c*r+1][c];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]='0';
            }
        }
        int ind=0;
        int i=0,j=0;
        while(ind<s.length()){
            if(i==0 || i%(c-1)==0){
                arr[i][j]=s.charAt(ind);
                ind++;
            }
            else if((i+j)%(c-1)==0){
                arr[i][j]=s.charAt(ind);
                ind++;
            }
            j++;
            if(j==numRows){
                i++;
                j=0;
            }
        }
        String ans="";
        System.out.println(arr.length+" "+arr[0].length);
        for(int x=0;x<arr[0].length;x++){
            for(int y=0;y<arr.length;y++){
                if(arr[y][x]!='0'){
                    ans=ans+arr[y][x];
                }
            }
            //System.out.println();
        }
        return ans;
    }
}
