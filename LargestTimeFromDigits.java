import java.util.ArrayList;

class LargestTimeFromDigits {
    public static String largestTimeFromDigits(int[] arr) {
        String str="";
        for (int i = 0; i < arr.length; i++){
            str+=arr[i];
        }
        ArrayList<Integer> al=new ArrayList<>();
        permute("",str,al);
        System.out.println(al);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < al.size(); i++) {
            max=Math.max(max,al.get(i));
        }
        String result=Integer.toString(max);
        String FinallyStr=result.substring(0,2)+":"+result.substring(2);
        return FinallyStr;
    }
    public static void permute(String ans,String str,ArrayList<Integer> al){
        if(str.length()==0){
            al.add(Integer.parseInt(ans));
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permute(ans+ch,newStr,al);
        }
    }
    public static void main(String[] args) {
        int[] array={1,2,3,4};
        System.out.println(largestTimeFromDigits(array));
    }
}