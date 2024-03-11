public class TCS {
    public static void main(String...args) {
        int n = args.length - 1;
        int q = Integer.MAX_VALUE; // Initialize q to a very large value
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(args[i]);
            if (num < q) {
                q = num;
            }
        }
	boolean isFound=false;
        long p = q; // Start with p equal to q
        while (true) {
            if (isPrime(p) && hasRemainder(p, args, q)) {
              isFound=true;
                break;
            }
            p++;
        }
		if(isFound) {
          System.out.println(p);
        }
        System.out.println("None");
    }

    static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean hasRemainder(long p, String[] args, int q) {
        for (String arg : args) {
            int num = Integer.parseInt(arg);
            if (num != q && p % num != q) {
                return false;
            }
        }
        return true;
    }
}
