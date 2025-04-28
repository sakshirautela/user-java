package com.learn.java.problemsolving;

public class ConvertDateToBinary {
    public static String convertDateToBinary(String date) {
        String[] arr=date.split("-");
        String s="";
        for (int i = 0; i < arr.length; i++) {
            if(s.equals("")){
                s=s+convertToBinary(Integer.parseInt(arr[i]));
            }else{
                s=s+"-"+convertToBinary(Integer.parseInt(arr[i]));
            }
        }
        return s;
    } 
    private static String convertToBinary(int num) {
        String s="";
        while(num>0){
            s=((num%2==1)?"1":"0")+s;
            num/=2;
        }
        System.out.println(s);
        return s;
    }
    public static void main(String agrs[]){
        System.out.println(convertDateToBinary("2080-09-90"));
    }
}