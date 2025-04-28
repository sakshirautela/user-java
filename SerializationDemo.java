import java.io.FileOutputStream;
// import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class EmployeeSerialize implements Serializable {
   private static final long serialVersionUID = 1L;
   public String name;
   public String address;
   public int number;

   public void mailCheck() {
      System.out.println("Mailing a check to " + name + " " + address);
   }
}

public class SerializationDemo {
   public static void main(String[] args) {
      EmployeeSerialize e = new EmployeeSerialize();
      e.name = "Dakshi";
      e.address = "Rudraprayag";
      e.number = 101;

      try {
         FileOutputStream fileOut = new FileOutputStream("EmployeeSerialize.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
      } catch (Exception i) {
         System.out.println(i);
      }
   }
}
