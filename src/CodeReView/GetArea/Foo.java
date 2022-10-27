package CodeReView.GetArea;

public class Foo {
    int arg1;
    String arg2;
    double arg3;
    int arg4;
    String arg5;
    int arg6;
    String arg7;
    Foo() {
    }

    public static void main(String[] args) {
        Foo myFoo = new Foo();

        myFoo.arg1 = 12;
        myFoo.arg2 = "Wow";
        myFoo.arg3 = 3.24;
        myFoo.arg4 = 78;
        myFoo.arg5 = "Usage";
        myFoo.arg6 = 19;
        myFoo.arg7 = "qwerty";

        System.out.println(myFoo.arg2);
        System.out.println(myFoo.arg6);
    }
}
