class VowalCount {
    public static void main(String args[]) {
        String word="cuaieuouac";
        int count=0;
        String str="";
        String result="";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='o' || word.charAt(i)=='i' || word.charAt(i)=='u'){
                str+=word.charAt(i);
            }
        }
        // if(word!=null){
        //     //str=word;
        //     if(word.contains("a") && word.contains("i") && word.contains("o")&& word.contains("e") && word.contains("u")){
        //         //count++;
        //     }
        // }
        for(int i=0;i<=str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                result=str.substring(i,j);
                System.out.println(result);
                if(result.contains("a") && result.contains("i") && result.contains("o")&& result.contains("e") && result.contains("u")){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}