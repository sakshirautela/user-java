abstract class  unique{
    abstract protected void fun();
    void fun2(){
        System.out.print("hello");
    }
}
class emp extends unique{

    //public Object fun2;
    @Override
    public void fun() {
        System.out.println("overridden....");        
    }
   
}
public class Interface {
    public static void main(String...xty){
       //unique sc = new unique();
        System.out.println("Sucessful.....");
        emp obj=new emp();
        obj.fun();
        obj.fun2();

    }
}
