// class GenericExp <T> extends Exception{

// }
// class DetailedException<T> extends Exception {
//     private T details;

//     public DetailedException(String message, T details) {
//         super(message);
//         this.details = details;
//     }

//     public T getDetails() {
//         return details;
//     }
// }
public class GenericExceptions {
    public static void main(String[] args) {
        // try {
        //     throw new DetailedException<Integer>("An error occurred", 404);
        // } catch (DetailedException<Integer> e) {
        //     System.out.println(e.getMessage());  // Output: An error occurred
        //     System.out.println(e.getDetails());  // Output: 404
        // }
    }
}
/*
 * class CustomException<T> extends Exception {
    private final T errorCode;

    public CustomException(String message, T errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public T getErrorCode() {
        return errorCode;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (CustomException<Integer> e) {
            System.out.println("Caught an exception with error code: " + e.getErrorCode());
        }
    }

    public static void throwException() throws CustomException<Integer> {
        throw new CustomException<>("Something went wrong", 1001);
    }
}
 */
