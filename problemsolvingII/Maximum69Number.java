public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(69));
    }

    public static int maximum69Number(int num) {
        int result = 0;
        String s = Integer.toString(num);
        boolean ischange = false;
        for (char ch : s.toCharArray()) {
            if (!ischange && ch == '6') {
                ischange = true;
                result=result*10+9;
            }else{
                result=result*10+(ch-'0');
            }
        }
        return result;
    }
}
