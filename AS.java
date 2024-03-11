abstract class asd{
   static int abc=5;
     void sum(){
        System.out.println("static method called");
    }
}    
public class AS extends asd {
    public static void main(String ...args){
        AS obj=new AS();
        System.out.println(asd.abc=90);
        
        obj.sum();
        //asd obj=new asd();
    }
    
}
