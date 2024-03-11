public class LaxocarphicalLargestTwoStringMerge {
    public static String largestMerge(String s, String t) {
        String merge="";
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.substring(i).compareTo(t.substring(j))>0){
                merge+=s.charAt(i);
                i++;
            }
            else{
                merge+=t.charAt(j);
                j++;
            }
        }
        while (i<s.length()) {
            merge+=s.charAt(i);
            i++;
        }
        while (j<t.length()) {
            merge+=t.charAt(j);
            j++;
        }
        return merge;
    }
    public static void main(String[] args){
        System.out.println(largestMerge("abcabc","abdcaba"));
    }
}