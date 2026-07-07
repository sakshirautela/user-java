package Contest;

import java.util.ArrayList;
import java.util.List;

public class WeeklyContest505 {
    static void main() {
//        System.out.println(sumOfGoodIntegers(4, 5));
        System.out.println(generateValidStrings(4, 5));
    }

    public static int sumOfGoodIntegers(int n, int k) {
        int x = (Math.max(n, k)) * 2;
        int res = 0;
        while (x > 0) {
            if (Math.abs(n - x) <= k && (n & x) == 0) {
                res += x;
            }
            x--;
        }
        return res;
    }

    public static List<String> generateValidStrings(int n, int k) {
        List<String> list = new ArrayList<>();
        generateValidStringsHelper(n, k, list, "",0,0,-1);
        return list;
    }

    private static void generateValidStringsHelper(int n, int k, List<String> list, String s, int i, int cost,int prev) {
        if(i==n){
            if(cost<=k){
                list.add(s);
            }
            return;
        }
        if(prev==1){
            generateValidStringsHelper(n, k, list, s+'0', i+1,cost,0);
        }else{
            generateValidStringsHelper(n, k, list, s+'0', i+1,cost,0);
            generateValidStringsHelper(n, k, list, s+'1', i+1,cost+i,1);
        }
    }

}