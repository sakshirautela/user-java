class ReverseStrII {
    public static String reverseStr(String s, int k) {
        char[] c=s.toCharArray();
        for (int i=0; i<c.length;i+=2*k){
            int start=i;
            int end=Math.min(i+k-1,c.length-1);
            while (start<end){
                //swap
                char temp=c[start]; c[start]=c[end];
                c[end]=temp;
                start++;
                end--;
            }
        }
        return new String(c);
    }
    static void reverse(char[] arr, int i, int j){
       while(i<j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    }
    public String reverseStr2(String s, int k) {
      int i=0; int n=s.length();
      char[] arr=s.toCharArray();
      while(i<n){
          int j=Math.min(i+k-1,n-1);
          reverse(arr,i,j);
          i=i+2*k;
      }
      String str=new String(arr);

      return str;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 8));
    }
}