import java.util.Scanner;
public class largestFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, k = 0, sum = 0, s1 = 0, t, temp = 0, j;
        long c[] = new long[1000009];
        long s[] = new long[100009];
        System.out.println("Enter a no");
        t = sc.nextInt();
        for (int l = 0; l < t; l++)
        {
            n = sc.nextInt();
            for (i = 0; i < n; i++)
                c[i] = sc.nextLong();
            for (i = 0; i < n; i++) {
                for (j = i + 1; j < n; j++) { if (c[i] > c[j])
                    {
                        temp = (int) c[i];
                        c[i] = c[j];
                        c[j] = temp;
                    }
                }
            }
            sum = 0;
            k = 0;
            for (i = 0; i < n; i++)
            {
                sum = (int) (sum + c[i]);
                s[k] = sum;
                k++;
            }
            s1 = 0;
            for (i = 1; i < k; i++)
                s1 = (int) (s1 + s[i]);
            System.out.println(s1);
        }
    }

}