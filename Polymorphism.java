// Method overloading By using
// Different Types of Arguments

// Class 1
// Helper class
class Helper {
    int b;
    int a;
    int c;

    public Helper(int a, int b) {

    }

    public Helper(int a, int b, int c) {

    }

    // Method with 2 integer parameters
    static int Multiply(int a, int b) {
        // Returns product of integer numbers

        return a * b;
    }

    // Method 2
    // With same name but with 2 double parameters
    static double Multiply(double a, double b) {
        // Returns product of double numbers
        return a * b;
    }
}

// Class 2
// Main class
public class Polymorphism {
    // Main driver method
    public static void main(String[] args) {
        System.out.println("str" + "b");
        // Calling method by passing
        // input as in arguments
        int a = 5;
Integer b = 10;
Integer c = a + b;  // Unboxing, addition, then autoboxing
// Instead of a + b for complex numbers
//ComplexNumber result = a.add(b);
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(5.5, 6.3));
    }
}
