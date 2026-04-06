import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(2^1);
        System.out.println(1^ 1>>1);
        System.out.println(2>>1);
        System.out.println(graycode(2));
    }

    static public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        int totalen = 1 << n;
        for (int i = 0; i < totalen; i++) {
            String a= Integer.toBinaryString(i^(i>>1));
            while(a.length()<n){
                a="0"+a;
            }
            list.add(a);
        }
        System.out.println();
        return list;
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
