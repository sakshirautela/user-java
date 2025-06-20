public class j {
    static boolean b1, b2;

    public static void main(String[] args) {
        int x = 0;
        if (!b1) {                     // true (b1 is false initially)
            if (!b2) {                 // true (b2 is also false initially)
                b1 = true;             // b1 becomes true
                x++;                   // x = 1
                // if (5 > 6) {           // false
                //     x++;              // not executed
                // }
                if (!b1)               // false (b1 is true)
                    x = x + 10;       // not executed
                else if (b2 = true)    // assignment, sets b2 = true → condition is true
                    x = x + 100;      // x = 1 + 100 = 101
                else if (b1 | b2)      // skipped due to else-if
                    x = x + 1000;
            }
            System.out.println(x);     // prints: 101
        }
    }
}
