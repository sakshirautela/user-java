import java.util.Arrays;

public class CasespecificSortingofStrings {
    public static void main(String[] args) {
        System.out.println(caseSort("GEekS"));
    }
    public static String caseSort(String s) {
        // code here
        int n=s.length();
        char[] ch=s.toCharArray();
        boolean isUpper[]=new boolean[n];
        for(int i=0;i<n;i++){
            char c=ch[i];
            if(c>=65 && c<=91){
                isUpper[i]=true;
            }
        }
        Arrays.sort(ch);
        StringBuilder sb=new StringBuilder();
        int l=-1;
        int u=0;
        for (int k = 0; k < n; k++) {
            if(ch[k]>=95){
                l=k;
                break;
            }
        }
        for (int k = 0; k < n; k++) {
            if(isUpper[k]){
                sb.append(ch[u]);
                u++;
            }else{
                sb.append(ch[l]);
                l++;
            }
        }
        return sb.toString();
    }
}