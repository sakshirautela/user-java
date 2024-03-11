public class StringCompression {
    public static String compress(String str){
        // if(str.length()==0){
        //     return;
        // }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<str.length();i++){
            int count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
                //result.append(count);

            }
            result.append(str.charAt(i));

            if(count>1){
                result.append(count);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        //System.out.println(compress("aabbccc"));
        String s="aabbccc";
        char[] chars=s.toCharArray();
        System.out.println(compress(chars));
    }
    
    public static int compress(char[] chars) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i < chars.length-1 && chars[i] == chars[i]){
                count++;
                i++;
                // result.append(count);

            }
            result.append(chars[i]);

            if (count > 1) {
                result.append(count);
            }
        }
        System.out.println(result);

        char[] newresult=new char[result.length()];
        for (int i = 0; i <result.length(); i++) {
            newresult[i] = result.charAt(i);
            System.out.println(newresult[i]);
        }
        return newresult.length;
    }
}
