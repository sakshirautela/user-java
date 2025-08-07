import java.io.FileWriter;

public class SaveToFile implements Persistence {
    @Override
    public void save(String data) {
        try{
            FileWriter wf=new FileWriter("docs.txt");
            wf.write(data);
            wf.close();
            System.out.println("docs is saved");
        }catch (Exception e){
            System.out.println("error is occurring");
        }
    }
}
