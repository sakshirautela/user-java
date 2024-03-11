import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class inventary {
    public static void main(String args[]){
        Scanner obj= new Scanner(System.in);
        ArrayList<String> itmlist= new ArrayList();
        // System.out.println("how many categories you want to add:");
        // int n=obj.nextInt();
        // int i=1;
        // while( i<=n){
        //     System.out.println("enter " + i +"category:");
        //     String s= obj.next();
        //     str.add(s);
        //     i++;
        // }
        // System.out.println(str);
        // System.out.println("in which category you want to add item:");
        // String itm =obj.next();
        // while(true){
        //     System.out.println("item name");
            
        // }
        HashMap<String, ArrayList<String>> newmap =new HashMap<>();
        System.out.println("how many categories you want to add:");
        int n=obj.nextInt();
        int i=1;
        while( i<=n){
            System.out.println("enter " + i +"category:");
            String s= obj.next();
            System.out.println("item count");
            int count=obj.nextInt();
            System.out.println("item name");
            for(int j=0;j<count;j++){//while(true){
                    System.out.println(j+1+".");
                    String itm=obj.next();
                    itmlist.add(itm);
                    // System.out.println("you want to add more(y/n):");
                    // char ch=obj.next().charAt(0);
                    // if(ch!='y' || ch!='Y'){
                    //     break;
                    // }
            }
            newmap.put(s,itmlist);
            i++;
        }
        System.out.println(newmap);
    }
}
