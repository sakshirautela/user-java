package Exceptions;

public class WithoutExceptionClass<T> {

    T value;

    public WithoutExceptionClass(T value) {
        this.value = value;
    }

    public void performOperation() {
        try {
            // Just an example to cause an exception for demonstration
            int result = 5 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }

    public static void main(String[] args) {
        WithoutExceptionClass<Integer> obj = new WithoutExceptionClass<>(10);
        obj.performOperation();
    }
}
