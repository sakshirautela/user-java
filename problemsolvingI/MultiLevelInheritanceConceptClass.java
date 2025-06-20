class Cat {
    public void show() {
        System.out.println("A");
    }
}

class Dog {
    public void show() {
        System.out.println("B");
    }
}

class Both {//implements Dog, Cat {
    //Dog dog=new Dog();
    public void show() {
        //A.super.show(); // Explicitly choose A's implementation
        //Dog.super.show();
    }
}

public class MultiLevelInheritanceConceptClass  {
    public static void main(String[] args) {
        C obj=new C();
        obj.show();
    }
}
