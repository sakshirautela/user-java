import java.util.HashMap;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] { 1, 0, 1, 4, 1, 4, 1, 2, 3 }));
    }

    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int result = 0;
        int idx = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int k=0;k < n; k++) {
            freq.put(fruits[k], freq.getOrDefault(fruits[k], 0) + 1);
            while (freq.size() > 2) {
                freq.put(fruits[idx], freq.get(fruits[idx]) - 1);
                if (idx<n && freq.get(fruits[idx]) == 0) {
                    freq.remove(fruits[idx]);
                }
                idx++;
            }
            result = Math.max(result, k - idx);
        }

        return result;
    }
    static{ for(int i = 0; i < 500; i++)
    { totalFruit(new int[]{}); } }
    static public int totalFruit2(int[] fruits) {

        int type1=-1;
        int type2=-1;
        int count1=0;
        int count2=0;
        int max=0;
        int lead=-1;
        int lead_index=-1;

        for(int i=0;i<fruits.length;i++){

            if(type1==-1 || type1==fruits[i]){

                type1=fruits[i];
                count1++;
                if(lead!=type1){
                    lead=type1;
                    lead_index=i;
                }
            }
            else if(type2==-1 || type2==fruits[i]){

                type2=fruits[i];
                count2++;
                if(lead!=type2){
                    lead=type2;
                    lead_index=i;
                }
            }
            else{

                max=Math.max(max,count1+count2);
                if(lead==type1){

                    count1=i-lead_index;
                    type2=fruits[i];
                    count2=1;
                }
                else{
                    count2=i-lead_index;
                    type1=fruits[i];
                    count1=1;
                }
                lead=fruits[i];
                lead_index=i;
            }
        }

        return Math.max(max,count1+count2);
        
    }
}