class ReverseStrIII {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] c=words[i].toCharArray();
            int a=0;
            int e=c.length-1;
            while(a<e){
                char temp=c[a];
                c[a++]=c[e];
                c[e--]=temp;
            }
            words[i]=new String(c);
        }
        String res="";
        for (int i = 0; i < words.length; i++) {
            res=res+words[i]+" ";
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
     public String reverseWords2(String s) {
        char c []=s.toCharArray();
        int start=0;
        int end=0;

        while(start<c.length){
            while(end<c.length && c[end]!=' '){
                end++;
            }

            reverse(start, end-1, c);
            start=end+1;
            end=start;
        }
        return new String(c);
    }
    public void reverse(int l , int r, char c[]){
        while(l<r){
            char temp=c[l];
            c[l++]=c[r];
            c[r--]=temp;
        }
    }
}