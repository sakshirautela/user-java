public class VehicalCar {
    {
        System.out.println("Non static block invoked");
    }
    static{
        System.out.println("Static block invoked");
    }
    VehicalCar(){
        System.out.println("Constructor invoked");
    }
    public static void main(String args[]){
        VehicalCar obj = new VehicalCar();
    }
}
        