public class MakeExamples {
    public static void main(String[] args) {
        byte x=127;
        x++;
        ++x;
        System.out.println(x);
        int[] arr={222,220,022};
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
        int y=20;
        y=y*2;
        System.out.println(y);

        boolean a=false;
        boolean b=true;
        boolean c=(a==b);
        System.out.println(c);

        short s=10;
        s=(short) (s*10);
        System.out.println(s);
        int[] arr2={1,0,1};
        for(int i=0;i<arr2.length;i++){
            arr2[i]=arr2[(arr2[i]+3)%arr2.length];
        }
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]);
        }

        int ab=10;
        char ch='a';
        System.out.println(ab+ch);
    }
}
