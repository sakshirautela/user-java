package SOLIDpriciple;


class Product {
    int price;
    String name;

    Product(int p, String n) {
        this.price = p;
        this.name = n;
    }
}

interface Persistent {
    void save(Product p) ;
}

class SaveToMongo implements Persistent {
    public void save( Product p) {
        System.out.println(p.name + " saved to mongo");
    }
}

class SaveToSQL implements Persistent {
    public void save( Product p) {
        System.out.println(p.name + " saved to SQL");
    }
}

class AddToDB {
    Persistent p ;
    AddToDB(Persistent p){
        this.p=p;
    }
    void addProduct(Product product){
        p.save(product);
    }
}

public class OpenClosePrinciple {
    public static void main(String[] args) {
        Product p=new Product(1000,"Java");
        AddToDB s=new AddToDB(new SaveToMongo());
        s.addProduct(p);
        AddToDB m=new AddToDB(new SaveToSQL());
        m.addProduct(p);
    }
}
