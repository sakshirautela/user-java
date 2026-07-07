package problemsolvingIII;

public class RotatingtheBox {
    static void main() {
        char[][] box = rotateTheBox(new char[][]{{'#', '.', '#'}, {'#', '.', '#'}});
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] newBox = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newBox[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            int idx = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (idx>=0 && newBox[i][j] == '#') {
                    newBox[i][j] = '.';
                    newBox[idx][j] = '#';
                    idx--;
                }else if(newBox[i][j] == '*') {
                    idx=i-1;
                }
            }
        }
        return newBox;
    }
}