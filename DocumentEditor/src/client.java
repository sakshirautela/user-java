public class client {
    public static void main(String[] args) {
        Document doc=new Document();
        Persistence p=new SaveToFile();
        Persistence db=new SaveToDB();
        DocumentEditor de=new DocumentEditor(doc,p);
        de.addText("hello i am sakshi \n");
        de.addImage("picture.jpg");
        de.addText("hello i am sakshi");
        System.out.println(de.getDocumentroot());
        de.saveDocument();
        db.save(de.getDocumentroot());
    }
}
