import java.util.HashMap;

public class BalancingConsonantsandVowelsRatio {
    public static void main(String[] args) {
        System.out.println(countBalanced(new String[]{"aeio", "aa", "bc", "ot", "cdbd"}));
    }

    public static int countBalanced(String[] arr) {
        // code here
        int result = 0;
        int n=arr.length;
        int[][] pre=new int[n][2];
        for (int i = 0; i <n ; i++) {
            String s=arr[i];
            int vowel=0;
            int cont=0;
            for(char ch:s.toCharArray()){
                if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    vowel++;
                }else{
                    cont++;
                }
            }
            pre[i][1]=(i==0)?vowel:vowel+pre[i-1][1];
            pre[i][0]=(i==0)?cont:cont+pre[i-1][0];
            if(pre[i][0]==pre[i][1]){
                result=Math.max(pre[i][1],result);
            }
        }
        return result;
    }
}
