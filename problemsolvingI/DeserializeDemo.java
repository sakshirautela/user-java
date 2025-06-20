import java.io.FileInputStream;
// import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeserializeDemo {

   public static void main(String [] args) {
      Employee e = null;
      try {
         FileInputStream fileIn = new FileInputStream("EmployeeSerialize.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         System.out.println("readed");
         in.close();
         fileIn.close();
      } catch (Exception i) {
         System.out.println(i);
      }

      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Address: " + e.address);
      System.out.println("Number: " + e.number);
   }
}
class Employee implements Serializable  {

   private static final long serialVersionUID = 1L;
   public String name;
   public String address;
   public int number;
   
   public void mailCheck() {
      System.out.println("Mailing a check to " + name + " " + address);
   }

}
