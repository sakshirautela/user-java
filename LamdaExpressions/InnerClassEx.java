package LamdaExpressions;

public class InnerClassEx {
    public static void main(String[] args) {
        Employee em=new Employee(){

            @Override
            public String getSalary() {
                return "100";
            }

            @Override
            public String getDesignation() {
                return "Engineer";
            }
            
        };
        System.out.println(em.getDesignation());
    }
}
