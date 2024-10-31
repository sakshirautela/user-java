public class CawlerLogFolder {
    public static int minOperations(String[] logs) {
        int changes = 0;
        for (String str : logs) {
            if (str.endsWith("../")) {
                changes--;
            }
            else if (!str.endsWith("./") ) {
                changes++;
            }
            if (changes < 0) {
                changes = 0;
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new String[] {}));
    }
}