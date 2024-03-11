import java.util.ArrayList;
public class class2 {
    public String fname;
    public String lname;
    public static void main(String[] args) {
        cbz  obj=new cbz();
        class2 n=new class2();
        n.fname = "x";
        n.lname = "y";
        obj.method(n);
        // System.out.println(n.fname);
        // System.out.println(n.lname);
        int str=1;
        obj.method2(str);
        System.out.println(str);

    }
}
class cbz{
    public void method(class2 a){
        a.fname="vipin";
        a.lname = "vipin";
    }
    
    public void method2(int a) {
        a= 2;
    }
}
