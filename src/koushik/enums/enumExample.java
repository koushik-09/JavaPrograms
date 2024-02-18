package koushik.enums;

public class enumExample {
    //used for limiting the no.of objects we create for a class
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

        Week() {
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        Week week;
        week =Week.Monday;
        //System.out.println(week);
    }
}
