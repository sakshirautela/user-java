package Exceptions;

public class ExceptionHandling extends Exception {
    public ExceptionHandling(){//String message) {
        super("This is a custom exception message.");
    }

    public static void main(String[] args) {
        try {
            throw new ExceptionHandling();
        } catch (ExceptionHandling e) {
            System.out.println(e.getMessage());
        }
    }
    
}
