import java.util.ArrayList;
import java.util.List;

public class Document {
    List<DocumentElement> li=new ArrayList<>();
    void addElement(DocumentElement el){
        li.add(el);
    }
    String render(){
        StringBuilder sb=new StringBuilder();
        for(DocumentElement d:li){
            sb.append(d.render());
        }
        return sb.toString();
    }
}
