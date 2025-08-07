
public class TextElement implements DocumentElement{

    String text;
    public TextElement(String text){
        this.text=text;
    }
    @Override
    public String render() {
        return text;
    }
}
