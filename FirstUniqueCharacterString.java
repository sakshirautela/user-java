public class FirstUniqueCharacterString {
    public static int firstUniqChar(String s) {
        int idx=Integer.MAX_VALUE;
        int count[]=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        for(int i=0;i<count.length;i++){
            char ch=(char)(i+'a');
            if(count[i]==1 && s.indexOf(ch)<idx){
                idx=s.indexOf(ch);
            }
        }
        return (idx==Integer.MAX_VALUE?-1:idx);
    }
    public static void main(String[] args) {
        String str="leetcode";
        System.out.println(firstUniqChar(str));
    }
    public int firstUniqCharII(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }   
}
