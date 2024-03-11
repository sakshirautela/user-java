class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        boolean res=false;
        String s1="";        
        String s2="";
        for(int i=0;i<n/2;i++){
            s2="";
            s1+=s.charAt(i);
            for(int j=i+1;j<n;j++){
                s2+=s.charAt(j);
                System.out.println(s1 +" "+s2+" ");
                if(s1.equals(s2)){
                    res= true;
                    break;
                }
            }
        }
        if(!s1.equals(s2)){
            return false;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(repeatedSubstringPattern("ababba"));
    }
}