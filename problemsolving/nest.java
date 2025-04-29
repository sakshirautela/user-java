
class sampleclass {
    public static class rrr extends sampleclass {

    }

    public void uye() {
        System.out.println("first");

    }

    public void uye1() {
        System.out.println("cgh");
    }

    private sampleclass() {

    }

    public static sampleclass getObj() {

        return new sampleclass();
    }

}

public class nest {
    static sampleclass.rrr obj;

    public static void main(String args[]) {
        obj = new sampleclass.rrr();
        obj.uye();
        obj.uye1();
        sampleclass n= sampleclass.getObj();
        n.uye();
        n.uye1();
    }
}
