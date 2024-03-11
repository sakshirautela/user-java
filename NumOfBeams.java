import java.util.ArrayList;

public class NumOfBeams {
    public static int numberOfBeams(String[] bank) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < bank.length; i++) {
            int count=getCount(bank[i]);
            if(count>0) numbers.add(count);
        }
        if(numbers.size()<=1){
            return 0;
        }
        int count = 0;
        for (int i = 1; i < numbers.size(); i++) {
            count+=numbers.get(i)*numbers.get(i-1);
        }
        return count;
    }
    private static int getCount(String str) {
        int count = 0;
        for(char ch:str.toCharArray()){
            count+=(ch-'0');
        }
        return count;
    }
    public static int numberOfBeams2(String[] bank){
        int prevcount = 0;
        int ans = 0;
        for (int i = 0; i < bank.length; i++) {
            int count = getCount(bank[i]);
            if (count == 0) {
                continue;
            }
            ans += (count * prevcount);
            prevcount = count;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(numberOfBeams2(new String[]{"001","111","000"}));
    }
}