public class LookandSayPattern {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        // code here
        if(n==1){
            return "1";
        }
        StringBuilder str=new StringBuilder();
        str.append("1");
        StringBuilder sb=new StringBuilder();
        while (n>1) {
            n--;
            int count=1;
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i)!=str.charAt(i-1)){
                    sb.append(Integer.toString(count)+str.charAt(i-1));
                    count=1;
                }else{
                    count++;
                }
            }
            sb.append(Integer.toString(count));
            sb.append(str.charAt(str.length()-1));
            str=new StringBuilder();
            System.out.println(sb);
            str.append(sb);
            sb=new StringBuilder();
        }

        return str.toString();
    }
}