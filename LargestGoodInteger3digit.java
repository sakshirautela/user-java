public class LargestGoodInteger3digit {
        public static boolean isTrue(String str){
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)!=str.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
    public static String largestGoodInteger(String num) {
        int start=0;
        int end=3;
        String res="";
        while(end<=num.length()){
            if(isTrue(num.substring(start,end))){
                res=(res.compareTo(num.substring(start,end))>=0)?res:num.substring(start,end);
            }
            start++;
            end=start+3;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
    }
    public String largestGoodInteger2(String num) {
        if (num.indexOf("999") != -1) {
            return "999";
        } else if (num.indexOf("888") != -1) {
            return "888";
        } else if (num.indexOf("777") != -1) {
            return "777";
        } else if (num.indexOf("666") != -1) {
            return "666";
        } else if (num.indexOf("555") != -1) {
            return "555";
        } else if (num.indexOf("444") != -1) {
            return "444";
        } else if (num.indexOf("333") != -1) {
            return "333";
        } else if (num.indexOf("222") != -1) {
            return "222";
        } else if (num.indexOf("111") != -1) {
            return "111";
        } else if (num.indexOf("000") != -1) {
            return "000";
        }

        return "";
        
    }
}