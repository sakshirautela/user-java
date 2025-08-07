package SOLIDpriciple;
class Rectangle{
    int l;
    int b;
    Rectangle(int l,int b){
        this.l=l;
        this.b=b;
    }
    int area(){
        return  l*b;
    }
    int parameter(){
        return 2*(l+b);
    }
}
public class SingleResponsbility {
    public static void main(String[] args) {
        Rectangle r=new Rectangle(2,3);
        System.out.println(r.area());
        System.out.println(r.parameter());
    }
}
