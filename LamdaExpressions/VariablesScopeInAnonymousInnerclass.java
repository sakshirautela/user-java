package LamdaExpressions;

public class VariablesScopeInAnonymousInnerclass {
     static int a=10;
    public static void main(String[] args) {
        int b=20;
        Employee em=new Employee() {
            int c=30;
            @Override
            public String getSalary() {
                return "100,"+Integer.toString(c)+","+Integer.toString(b)+","+Integer.toString(a);// ashoudl be static because innerclass is also a static refrence
            }

            @Override
            public String getDesignation() {
                return "Enginnering";
            }
            
        };
        System.out.println(em.getSalary());
    }
}
