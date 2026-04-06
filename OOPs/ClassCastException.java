package OOPs;
class A{
    int a;
    A(){
        init();
    }
    void init(){
        a=1;
        System.out.println(a);
    }
}
class B extends A{
    int b;
    B(){
        init();
    }
//    void init(){
//        b=2;
//        System.out.println(b);
//    }
}
public class ClassCastException {
    static void main() {
        A a = new A();
        B b = new B();

        //B c=(B)a; give class cast exception because b is not  instace of a;
        A c=(A)b; // b is instace of a
         Object s="abc";
        System.out.println((String)s ); // Object is parent
    }
}
