package problemsolvingIII;

public class CountSortedDigitGroupings {
    static void main() {
        System.out.println(validGroups("1119"));
    }

    public static int validGroups(String s) {
        // code here
        return validGroupsHelper(s,0,0);
    }

    private static int validGroupsHelper(String s, int i, int sum) {
        if(i==s.length()){
            return 1;
        }
        int cursum=0;
        int res=0;
        for(int j=i;j<s.length();j++){
            cursum+=(s.charAt(j)-'0');
            if(cursum>=sum){
                res+= validGroupsHelper(s,j+1,cursum);
            }
        }
        return res;
    }
}
