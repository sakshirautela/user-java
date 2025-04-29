class AConstctor{
    AConstctor(String s){
        System.out.println("AConstctor"+" "+s);
    }
}
class BConstctor extends AConstctor{
    BConstctor(){
        super("hello");
        System.out.println("BConstctor");
    }
}
public class ConstructorInterview {
    public static void main(String[] args) {
        
        AConstctor b=new BConstctor();
    }
}
