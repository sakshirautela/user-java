import java.util.ArrayList;

public class UnionofTwoSortedwithDuplicates {
    public static void main(String[] args) {
        System.out.println(findUnion(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 3 }));
    }

    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int i = 0, j = 0;
        int m = a.length;
        int n = b.length;
        ArrayList<Integer> al = new ArrayList<>();
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                if (al.size() == 0 ||(al.size() > 0 && al.get(al.size() - 1) != a[i])) {
                    al.add(a[i]);
                }
                i++;
            } else {
                if (al.size() == 0 || (al.size() > 0 && al.get(al.size() - 1) != b[j])) {
                    al.add(b[j]);
                }
                j++;
            }
        }
        while (i < m) {
            if (al.size() == 0 ||(al.size() > 0 && al.get(al.size() - 1) != a[i])) {
                al.add(a[i]);
            }
            i++;
        }
        while (j < n) {
            if (al.size() == 0 || (al.size() > 0 && al.get(al.size() - 1) != b[j])) {
                al.add(b[j]);
            }
            j++;
        }
        return al;
    }
}
