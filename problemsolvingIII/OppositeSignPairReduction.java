package problemsolvingIII;

import java.util.ArrayList;
import java.util.Stack;

public class OppositeSignPairReduction {
    static void main() {
        System.out.println(reducePairs(new int[]{5,-5,-2,-10}));
    }

    public static ArrayList<Integer> reducePairs(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : arr) {
            while (!res.isEmpty() && res.getLast() * num<0) {
                int last=res.getLast();
                if(Math.abs(last) <Math.abs(num)){
                    res.removeLast();
                    num=res.getLast();
                }
                if(Math.abs(num) ==Math.abs(last)){
                    res.removeLast();
                }
            }
            res.add(num);
        }
        return res;
    }
}