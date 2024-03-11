class sample {
    public static class abc {
        public void print() {
            System.out.println("this is vipin Bhandari");
        }

        public static void print1() {
            System.out.println("this is vipin Bhandari87675");
        }
    }
    // private sample(){

    // }
   
}


public static class xys {
    static sample b;

    public static void main(String args[]) {
        b = new sample();
        sample.abc hh = new sample.abc();
        hh.print1();
        hh.print();

    }
}

//

