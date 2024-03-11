interface ITest{
    void print1();
    

}
interface ITest2{
    void print1();
    

}
public class TestInterface   {
    // TestInterface(ITest abc, ITest2 zys){

    // }
    public static void main(String args[]){
         Test n=new Test();
         Test n1=new Test();
         n1.name="vipin";
         n.name="xys";
         n.printname();

         n.printname1();
         n1.printname();
         n1.printname1();
        // ITest2 obj=new Test();
        // obj.print1();
    }
}
class Test implements ITest,ITest2  {
    public String name ="";
    public void print1(){
        System.out.println("print 1");
    }
    // static {   //No, we cannot create a Static constructor in java ,can't create constructor static
    //     System.out.println("staic block");
    //     name="vipin";
    // }
    public void printname(){
        System.out.println(name);
    }
    public void printname1(){
        System.out.println(name);
    }
}
// class Test1  {
//     public void print1(){
//         ITest s1=new Test();
//         ITest2 s2=new Test();
//         TestInterface sc=new TestInterface(s1, s2) ;
//         System.out.println("print 1");
//     }
// }

