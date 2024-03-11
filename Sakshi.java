class  Demo{
    int data;
    private Demo(){
        this.data=data;
    }
    public static  Demo getObjet(){
        return new Demo();
    }
}

public class Sakshi{
    
    public static void main(String args[]){
        //SDemo obj=new SDemo();
        
        Demo n=Demo.getObjet();
    }
}