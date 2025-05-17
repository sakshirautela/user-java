package LamdaExpressions;

@FunctionalInterface
interface InnerVariablesScopeInLambdaexp {
    String getSalary();
}

public class VariablesScopeInLambdaexp {
     static int a = 10;

    public static void main(String[] args) {
        int b = 20;
        InnerVariablesScopeInLambdaexp obj = () -> {
            int c = 30;
            return "100, " + c + ", " + b + ", " + a;
        };

        System.out.println(obj.getSalary());
    }
}
