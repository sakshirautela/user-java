class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String res=s.trim();
        System.out.println(res+"@");
        int len=0;
        for(int i=0;i<res.length();i++) {
            if(res.charAt(i)==' '){
                len=0;
            }
            else{
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world   "));
    }
}