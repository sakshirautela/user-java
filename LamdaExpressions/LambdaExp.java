package LamdaExpressions;

@FunctionalInterface
interface MyLambda {
    String sayHello();
}

public class LambdaExp {
    public static void main(String[] args) {
        MyLambda str = () -> "hello lambda exp";
        System.out.println(str.sayHello());
    }
}
