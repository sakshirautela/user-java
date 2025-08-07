public class DocumentEditor {
    String documentroot = "";
    Document doc;
    Persistence p;

    public DocumentEditor(Document d, Persistence p){
        this.p=p;
        this.doc=d;
    }
    void addImage(String img){
        doc.addElement(new ImageElement(img));
    }
    void addText(String img){
        doc.addElement(new TextElement(img));
    }
    public String getDocumentroot(){
        if(documentroot.isBlank()){
            documentroot =doc.render();
        }
        return documentroot;
    }
    public void saveDocument(){
        p.save(documentroot);
    }
}
