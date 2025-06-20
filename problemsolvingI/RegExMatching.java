public class RegExMatching {
    public static void main(String[] args) {
        System.out.println(isPatternPresent("ab","caba"));
    }

    static int isPatternPresent(String s, String p) {
          if(p.charAt(0)=='^'){
            p=p.substring(1);
            if(s.startsWith(p)) return 1;
            else return 0;
        }else if(p.charAt(p.length()-1)=='$'){
             p=p.substring(0,p.length()-1);
             if(s.endsWith(p)) return 1;
            else return 0;
        }else{
            if(s.contains(p)) return 1;
            else return 0;
        }
        // code here
        // int left = 0;
        // int n = s.length();
        // int right = n - 1;
        // while (left < n && s.charAt(left) == '^') {
        //     left++;
        // }
        // while (right >= 0 && s.charAt(right) == '$') {
        //     right--;
        // }
        // int m=p.length();
        // for (int i = 0; i <m; i++) {
        //     if(p.charAt(i)==s.charAt(left) ){
        //         int idx=i;
        //         boolean match=true;
        //         for (int j = left; j <= right && idx<m; j++) {
        //             if(p.charAt(idx)!=s.charAt(j)){
        //                 match=false;
        //                 break;
        //             }
        //             idx++;
        //         }
        //         if(match){
        //             return 1;
        //         }
        //     }
        // }
        // return 0;
    }
}