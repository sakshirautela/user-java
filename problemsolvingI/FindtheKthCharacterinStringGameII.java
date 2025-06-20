public class FindtheKthCharacterinStringGameII {
    public static char kthCharacter(int k, int[] operations) {
        StringBuilder str=new StringBuilder();
        str.append('a');
        for (int i =0;i< operations.length;i++) {
            int len=str.length();
            if (operations[i] == 0) {
                str.append(str);
            } else {
                for (int j = 0; j < len; j++) {
                    if (str.charAt(j) == 'z') {
                        str.append('a');
                    } else {
                        str.append((char) (str.charAt(j) + 1));
                    }
                }
            }
        }
        return (str.charAt(k - 1));
    }

    public static void main(String args[]) {
        System.out.println(kthCharacter(5, new int[] {0,1,0,1}));
    }
}
