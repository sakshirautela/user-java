import java.util.*;
public class FindDifferentUniqueBinaryString {
    public String findDifferentBinaryString2(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    public static String findDifferentBinaryString(String[] nums) {
        String res="";
        HashSet<Integer> hs=new HashSet<>();
        int n=nums.length;
        for(String s : nums){
            int idx=0,bin=0;
            while(s.length()>0){
                bin+=(s.charAt(n-idx-1)=='0')?0:Math.pow(2,idx);
                idx++;
                s=s.substring(0,n-idx);
            }
            hs.add(bin);
        }
        System.err.println(hs);
        int m=(int)Math.pow(2,n);
        for(int i=0;i<m;i++) {
            if(!hs.contains(i)){
                while(i>-1){
                    res=((i%2==0)?"0":"1")+res;
                    i/=2;
                    if(res.length()==nums.length){
                        break;
                    }
                }
                if(res.length()==nums.length){
                        break;
                    }
            }
        }
        return res;
        
    }
    public static void main(String[] args){
        System.out.println(findDifferentBinaryString(new String[]{"00","01"}));
    }
}