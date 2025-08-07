import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(1));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int totalen = 1 << n;
        for (int i = 0; i < totalen; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
        public List<Integer> grayCode2(int n) {
            return new AbstractList<>() {
                @Override
                public int size() {
                    return 1 << n;
                }

                @Override
                public Integer get(int index) {
                    return index ^ (index >> 1);
                }
            };
        }
}
