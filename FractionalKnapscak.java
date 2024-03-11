import java.security.DrbgParameters.Capability;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapscak{
    public static void main(String[] args) {
        int[] value1={60,100,120};
        int[] value2 = { 60, 120, 100 };
        int[] weight1={10,20,30};
        int[] weight2 = { 10, 30, 20 };
        int w=50;
        System.out.println(fractionalKnapscak(value1, weight1, w));
        System.out.println(fractionalKnapscaknotSorted(value2, weight2, w));
    }
    public static int fractionalKnapscak(int[] value ,int[] weight ,int w){
        int[] ratio=new int[value.length];
        for (int i = 0; i < weight.length; i++) {
            ratio[i]=value[i]/weight[i];
        }
        int n=ratio.length-1;
        int val=0;
        for (int i =0;i<=n;i++ ) {
            if(w>=weight[i]){
                w=w-weight[i];
                val=val+value[i];
            }
            else{
                val=val+(ratio[i]*w);
            }
        }
        return val;
    }
    //if ratio not sorted
    public static double fractionalKnapscaknotSorted(int[] value, int[] weight, int w) {
        double[][] ratio = new double[value.length][2]; // because fractional part of ratio also important
        for (int i = 0; i < weight.length; i++) {
            ratio[i][0]=i;
            ratio[i][1]= value[i] /(double)weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(O->O[1]));//lemda function
        //Collections.reverseOrder();
        int n = ratio.length - 1;
        double val = 0;
        for (int i = n; i >= 0; i--) {
            int idx=(int) ratio[i][0];
            if (w >= weight[idx]) {
                w = w - weight[idx];
                val = val + value[idx];
            } else {
                val = val + (ratio[i][1] * w);
                w=0;
                break;
            }
        }
        return val;
    }

}