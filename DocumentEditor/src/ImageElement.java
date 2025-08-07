public class ImageElement implements  DocumentElement{
    private final String path;
    public ImageElement(String text){
        this.path =text;
    }
    @Override
    public String render() {
        return '['+ path +']';
    }
}
