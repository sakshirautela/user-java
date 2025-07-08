public class FindLuckyIntegerinanArray {
    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{}));
    }
    public static int findLucky(int[] arr) {
        int[] freq=new int[501];
        for(int num:arr){
            freq[num]++;
        }
        int result=-1;
        for(int i=1;i<=500;i++){
            if(freq[i]==i){
                result=i;
            }
        }
        return result;
    }
    static {
        for (int i = 0; i < 100; i++) {
            findLucky(new int[0]);
        }
    }
    public static int findLucky2(int[] arr) {
        if (arr.length == 0) return -1;
        
        int[] obeme = new int[501];

        for (int el : arr) {
            obeme[el] += 1;
        }

        for (int i = 500; i > 0; i--) {
            if (i == obeme[i]) return i;
        }

        return -1;
    }
}