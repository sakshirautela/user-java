public class GenericTest1 {
    public static <E> void printArray(E[] array){
        for ( E obj : array) {
            System.out.println(obj);
        }
    }
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "a","n","x" };
        printArray(intArray);
        printArray(stringArray);
    }
}
