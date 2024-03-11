class minMaxDifference {
    public static void main(String[] args) {
        int num =  11891;
        int max =0 ,min =0;
        int i = 1;
        int num2 = num;
        while (num > 0) {
            int rem = num % 10;
            if (rem == 1 || rem == 0) {
                rem = 9;
            }
            max = rem * i + max;
            num = num / 10;
            i = i * 10;
        }
        int j = 1;
        while (num2 > 0) {
            int rem = num2 % 10;
            if (rem == 1 || rem == 9) {
                rem = 0;
            }
            min = rem * j + min;
            num2 = num2 / 10;
            j = j * 10;
        }
        int n = max - min;
        System.out.println(n);
    }
}