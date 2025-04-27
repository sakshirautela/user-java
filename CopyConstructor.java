
// Java Program for Copy Constructor
class Copy {
    
    // data members of the class
    String name;
    int id;

    // Parameterized Constructor
    Copy(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    // Copy Constructor
    Copy(Copy obj2)
    {
        this.name = obj2.name;
        this.id = obj2.id;
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        // This would invoke the parameterized constructor
        System.out.println("First Object");
        Copy geek1 = new Copy("Sweta", 68);
        System.out.println("GeekName: " + geek1.name+ " and GeekId: " + geek1.id);

        System.out.println();

        // This would invoke the copy constructor
        Copy geek2 = new Copy(geek1);
        geek2.id=78;
        System.out.println("Copy Constructor used Second Object");
        System.out.println("GeekName: " + geek2.name+ " and GeekId: " + geek2.id);
    }
}