public class Sumofallsubstringsofanumber {
    public static void main(String[] args) {
        System.out.println(sumSubstrings("421"));
    }
     public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        int sum = 0;
        int prev = 0;
        for(int i=0 ; i<n ; i++){
            int x = s.charAt(i) - '0';
            
            prev = (prev*10) + x*(i+1);
            
            sum += prev;
        }
        
        return sum;
    }
    public static int sumSubstrings2(String s) {
        // code here
        int sum=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=i;j<n;j++){
                num=num*10+(s.charAt(j)-'0');
                sum+=num;
            }
        }
        return sum;
    }
}