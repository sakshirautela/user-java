import java.util.Arrays;
public class SmallestPalindromicRearrangementI {
    public static void main(String[] args) {
        System.out.println(new SmallestPalindromicRearrangementI().smallestPalindrome("yey"));                  
    }
    public String smallestPalindrome(String s) {
        char[] ch=s.toCharArray();
        int[] freq=new int[26];
        for(char c:ch){
            freq[c-'a']++;
        }
        int oddCount=-1;
        Arrays.sort(ch);
        int n=ch.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i+=2){
            if(freq[ch[i]-'a']%2!=0){
                oddCount=i;
                continue;
            }
            sb.append(ch[i]);                                           
        }
        if(oddCount==-1){
            return sb.toString()+sb.reverse().toString();
        }
        for(int i=1;i<n;i+=2){
            if(freq[ch[i]-'a']%2!=0){
                oddCount=i;
                continue;
            }
            sb.append(ch[i]);                                           
        }
        sb.append(ch[oddCount]);
        for(int i=n-2;i>=0;i-=2){
            sb.append(ch[i]);                                           
        }
        return sb.toString();
    }
}