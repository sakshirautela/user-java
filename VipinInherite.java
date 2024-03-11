class A{
    public void method() {
        System.out.println("hello");
    }
}
class B extends A{
    public void method() {
        System.out.println("hello");
    }
}
public class VipinInherite {
    public static void main(String[] args){
        B obj=new B();
        obj.method();
    }
}
