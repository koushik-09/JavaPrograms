package koushik;

public class Temp implements TempInterface{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
    public void helloWorld(){
        System.out.println("hello world");
    }
}
class ABC{
    public static void main(String[] args) {
        Temp obj = new Temp();
        obj.sayHello();
        obj.helloWorld();
    }
}
