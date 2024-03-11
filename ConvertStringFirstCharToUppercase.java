import java.util.*;
import java.io.*;

public class ConvertStringFirstCharToUppercase {
    public static String convertString(String str) {
        // Write your code here
        String words[]=str.split(" ");
        for(int i=0; i<words.length; i++) {
            if(words[i].length()>1){
                words[i]=(words[i].substring(0, 1).toUpperCase())+(words[i].substring(1));
            }else if(words[i].length()==1){
                words[i]=(words[i].substring(0, 1).toUpperCase());
            }
        }
        String res=String.join(" ", words);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(convertString(" I love programming\r\n" + //
                "they are playing cricket\r\n" + //
                "good to see you"));
    }

}