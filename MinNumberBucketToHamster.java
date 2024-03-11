public class MinNumberBucketToHamster {
    public static int minimumBuckets(String hamsters) {
        int count = 0;
        int n = hamsters.length();
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if(i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    count++;
                    i=i+2;
                } else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.') {
                    count++;
                }else{
                    return -1;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(minimumBuckets("HH.."));
    }
}