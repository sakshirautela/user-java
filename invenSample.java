 class Product {
    void fun(){
        System.out.println("cxab");
    }
    String name;
    float price;
    int id;

    Product() {
        this.name = name;
        this.price = price;
        this.id = id;
    }

}

public class invenSample extends Product  {
     void fun(){
        int sum=90;
        System.out.println(sum);
    }
    //static final int a = 0;

    public static void main(String args[]) {
        //a = 10;
        fun();
        String word = "Flag";
        int count1 = 0;
        int count2 = 0;
        int ch = word.charAt(0);
        if (ch >= 65 && ch <= 90) {
            System.out.println("found");
        }
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if ((ch >= 65 && ch <= 90)) {
                count1++;
            } else if ((ch >= 97 && ch <= 122)) {
                count2++;
            }

        }
        if (count1 == (word.length())) {
            System.out.println("found");
        } else if (count2 == (word.length())) {
            System.out.println("found");
        }
        // System.out.println("not found");
        // System.out.println("false");
    }
}
