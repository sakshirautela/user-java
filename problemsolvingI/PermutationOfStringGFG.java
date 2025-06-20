
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationOfStringGFG {
    Set<String> ans;

    public ArrayList<String> findPermutation(String s) {
        ans = new HashSet<>();
        solve(0, s.length(), s.toCharArray());
        return new ArrayList<>(ans);
    }

    void solve(int i, int n, char a[]) {
        if (i == n) {
            ans.add(new String(a));
            return;
        }

        for (int j = i; j < n; j++) {
            swap(i, j, a);
            solve(i + 1, n, a);
            swap(i, j, a);
        }
    }

    void swap(int i, int j, char a[]) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
