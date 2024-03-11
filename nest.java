class sample {
    public static class rrr extends sample {

    }

    public void uye() {
        System.out.println("first");

    }

    public void uye1() {
        System.out.println("cgh");
    }

    private sample() {

    }

    public static sample getObj() {

        return new sample();
    }

}

public class nest {
    static sample.rrr obj;

    public static void main(String args[]) {
        obj = new sample.rrr();
        obj.uye();
        obj.uye1();
        sample n=sample.getObj();
        n.uye();
        n.uye1();
    }
}
