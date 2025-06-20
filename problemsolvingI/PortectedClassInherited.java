//import PortectedClass;
//public class PortectedClassInherited extends InnerProtected { //give error

public class PortectedClassInherited extends PortectedClass {
    void useProtectedInner() {
        InnerProtected inner = new InnerProtected(); // Allowed (subclass access)
        inner.display();
        @SuppressWarnings("unused")
        class C{
            public static void hello(){
                class D{
                    
                }
            }
        }
    }
}
