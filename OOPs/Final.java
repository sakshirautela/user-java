package OOPs;
class Aa{

    final void print(int n){
        System.out.println("aa");
    }
}
class Bb extends Aa{
//    @Override
//    void print(int n){
//        System.out.println("bb");
//    }
}
public class Final {
    static void main() {
        Aa a=new Aa();
        Bb b=new Bb();
        a.print(1);
        b.print(2);
    }
}
