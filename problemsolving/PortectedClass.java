
public class PortectedClass {
    // Protected inner class
    protected class InnerProtected {
        void display() {
            System.out.println("Protected Inner Class");
        }
    }

    // Accessible in the same package
    public void createInner() {
        InnerProtected inner = new InnerProtected();
        inner.display();
    }
}
