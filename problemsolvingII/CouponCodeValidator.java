import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CouponCodeValidator {
    public static void main(String[] args) {
        System.out.println(validateCoupons(new String[]{"SAVE20","","PHARMA5","SAVE@20"},new String[]{"restaurant","grocery","pharmacy","restaurant"},new boolean[]{true,true,true,true}));
    }
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> li=new ArrayList<>();
        int n=code.length;
        PriorityQueue<String>electronics=new PriorityQueue<>();
        PriorityQueue<String>grocery=new PriorityQueue<>();
        PriorityQueue<String>pharmacy=new PriorityQueue<>();
        PriorityQueue<String>restaurant=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(code[i].length()>0 && isvalid(code[i])&& isActive[i]){
                if(businessLine[i].equals("electronics")){
                    electronics.add(code[i]);
                }
                if(businessLine[i].equals("restaurant")){
                    restaurant.add(code[i]);
                }if(businessLine[i].equals("grocery")){
                    grocery.add(code[i]);
                }if(businessLine[i].equals("pharmacy")){
                    pharmacy.add(code[i]);
                }
            }
        }
        while (!electronics.isEmpty()) {
            li.add(electronics.remove());
        }
        while (!grocery.isEmpty()) {
            li.add(grocery.remove());
        }
        while (!pharmacy.isEmpty()) {
            li.add(pharmacy.remove());
        }
        while (!restaurant.isEmpty()) {
            li.add(restaurant.remove());
        }
        return li;
    }
    private static boolean isvalid(String string) {
        for(char ch:string.toCharArray()){
            if(ch!='_' && !((ch>='A'&& ch<='Z') || (ch>='a'&& ch<='z')|| (ch>='0'&& ch<='9'))){
                return false;
            }
        }
        return true;
    }
   boolean fn(String code)
   {
      if(code.length()==0)
      {
         return false;
      }
      for(char ch:code.toCharArray())
      {
         if(!(Character.isLetterOrDigit(ch) || ch=='_'))
         {
            return false;
         }
      }
      return true;
   }
   public List<String> validateCouponsFast(String[] code, String[] businessLine, boolean[] isActive) {
      List<String> res1=new ArrayList<>();
      List<String> res2=new ArrayList<>();
      List<String> res3=new ArrayList<>();
      List<String> res4=new ArrayList<>();

      for(int i=0;i<businessLine.length;i++)
      {
         if(isActive[i])
         {
            if(businessLine[i].equals("electronics"))
            {
               if(fn(code[i]))
               {
                  res1.add(code[i]);
               }
            }
            else if(businessLine[i].equals("grocery"))
            {
               if(fn(code[i]))
               {
                  res2.add(code[i]);
               }
            }
            else if(businessLine[i].equals("pharmacy"))
            {
               if(fn(code[i]))
               {
                  res3.add(code[i]);
               }
            }
            else if(businessLine[i].equals("restaurant"))
            {
               if(fn(code[i]))
               {
                  res4.add(code[i]);
               }
            }

         }
      }
      Collections.sort(res1);
      Collections.sort(res2);
      Collections.sort(res3);
      Collections.sort(res4);

      List<String> result = new ArrayList<>();
      result.addAll(res1);
      result.addAll(res2);
      result.addAll(res3);
      result.addAll(res4);

      return result;
   }
}