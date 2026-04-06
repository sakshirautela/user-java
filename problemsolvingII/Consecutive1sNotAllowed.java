public class Consecutive1sNotAllowed {
    static void main() {
        System.out.println(countStrings(3));
    }

    static int countStrings(int n) {
        // code here
        int count = 0;
        int z=1,o=1;
        while (n>0){
            count=z+o;
            z=o;
            o=count;
            n--;
        }
        return count;
    }
}