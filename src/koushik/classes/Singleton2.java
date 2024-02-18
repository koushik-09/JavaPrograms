package koushik.classes;

public class Singleton2 {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance(1,"koushik");
        Singleton obj2=Singleton.getInstance(2,"kittu");
        System.out.println(obj.num);
//        System.out.println(obj2.name+" "+obj2.num);
    }
}
