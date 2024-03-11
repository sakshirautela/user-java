class FindOccurrences {
    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        else if(haystack.length()<needle.length()){
            return -1;
        }
        int start=0;
        int flag=-1;
        int end=needle.length();
        while(end<=haystack.length()){
            if(needle.equals(haystack.substring(start, end))){
                flag=start;
                break;
            }
            start++;
            end++;
        }
        return flag;
    }
    public static void main(String[] args) {
        System.out.println(strStr("leetcode","sa"));
    }
}
