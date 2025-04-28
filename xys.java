package com.learn.java.problemsolving;


class sample {
    static class abc {
        public void print() {
            System.out.println("this is vipin Bhandari");
        }

        public void print1() {
            System.out.println("this is vipin Bhandari87675");
        }
    }
    // private sample(){

    // }
   
}

public class xys {
    static sample b;

    public static void main(String args[]) {
        b = new sample();
        sample.abc hh = new sample.abc();
        hh.print1();
        hh.print();

    }
}

//

