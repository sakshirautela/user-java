interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

class C implements A, B {
    @Override
    public void show() {
        //A.super.show(); // Explicitly choose A's implementation
        B.super.show();
    }
}

public class MultiLevelInheritanceConcept extends C {
    public static void main(String[] args) {
        C obj=new C();
        obj.show();
    }
}
