import java.io.File;
import java.lang.*;
class FileHanding{
      public static void main(String args[]){
        File myfile = new File("Sample.txt");
        try{
          if(myfile.createNewFile()){
            System.out.println("File is created sucessfully");
          }
          else{
            System.out.println("File is not created");
          }
        }
        catch(Exception e){
          System.out.println("error occured"+e);
        }
      }
}
