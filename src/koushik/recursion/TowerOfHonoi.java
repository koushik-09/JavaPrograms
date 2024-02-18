package koushik.recursion;

public class TowerOfHonoi {
    public static void main(String[] args) {
        towerOfHonoi(124,"S","H","D");
    }
    public static void towerOfHonoi(int n,String src,String helper,String dest){
        if(n == 1){
            System.out.println("Transfer disk " +n+" from "+src +" to "+dest);
            return;
        }
        towerOfHonoi(n-1,src,dest,helper);
        System.out.println("Transfer disk " +n+" from "+src +" to "+dest);
        towerOfHonoi(n-1,helper,src,dest);
    }
}
