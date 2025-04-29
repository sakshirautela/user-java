
class AVI{
    public void method() {
        System.out.println("hello");
    }
}
class BVI extends AVI{
    public void method() {
        System.out.println("hello");
    }
}
public class VipinInherite {
    public static void main(String[] args){
        BVI obj=new BVI();
        obj.method();
    }
}
