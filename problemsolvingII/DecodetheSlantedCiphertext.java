public class DecodetheSlantedCiphertext {
    static void main() {
        System.out.println(decodeCiphertext("ch ie pr", 3));
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }
        int n = encodedText.length();
        //int cols = (n + rows - 1) / rows;
//        int cols=(n/rows)+(n%rows==0?0:1);
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < cols; k++) {
            int i = 0;
            int j = k;
            while (i < rows && j < cols) {
                sb.append(encodedText.charAt((i * (cols)) + j));
                i++;
                j++;
            }
        }
        int idx = sb.length() - 1;
        while (idx >= 0 && sb.charAt(idx) == ' ') {
            sb.deleteCharAt(idx);
            idx--;
        }

        return sb.toString();
    }

    public static String decodeCiphertextTLE(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int len = encodedText.length();

        if (len == 0)
            return encodedText;

        int cols = (int) Math.ceil((double) len / rows);

        char[][] matrix = new char[rows][cols];
        char[] encodedArr = encodedText.toCharArray();
        int e = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedArr[e++];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;

            while (r < rows && c < cols) {
                sb.append(matrix[r][c]);
                r++;
                c++;
            }
        }

        return sb.toString().stripTrailing();
    }
}
