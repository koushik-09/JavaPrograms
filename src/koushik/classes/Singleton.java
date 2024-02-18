package koushik.classes;

public class Singleton {
    int num;
    String name;
    private Singleton(int num,String name){
        this.num=num;
        this.name=name;
    }
    private static Singleton inst;
    public static  Singleton getInstance(int n,String name){
        if(inst==null){
            Singleton obj = new Singleton(n,name);
        }
        return inst;
    }
}
