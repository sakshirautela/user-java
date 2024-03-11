class FirstOccurance {
    public static int strStr(String haystack, String needle) {
        
        int i=1;
        int j=1;
        int idx=i;
        while(j<needle.length() && i<haystack.length()){
            if(needle.charAt(j)==haystack.charAt(i) && needle.charAt(j-1)==haystack.charAt(i-1)){
                i++;
                idx=i;
                j++;
            }
            else{
                i++;
            }
        }
        if(j==needle.length()){
            return idx-j;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issipi"));
    }
}