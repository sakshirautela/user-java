import java.util.Scanner;

public class MaximumScore {
    public static void main (String[] args){
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int diff=Integer.MAX_VALUE;
            int score=0;
            int n = sc.nextInt();
            int a = 0, b = 0;
            int[] nums1=new int[n];
            int[] nums2=new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                nums2[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int num1= nums1[i];
                int num2 = nums2[i];
                if (num1 - num2 < diff) {
                    diff = num1 - num2;
                    a = num1;
                    b = num2;
                }
                score += num1;
            }
            score-=a;
            score+=b;
            System.out.println(score);
        }
    }
}
