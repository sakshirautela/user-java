import java.util.*;

class SortByPower {
    public static int powerCal(int num){
        int count = 0;
        while(num>1){
            count++;
            if(num%2==0){
                num=num/2;
            }
            else{
                num=num*3+1;
            }
        }
        return count;
    }
    public static  int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> q=new PriorityQueue<int[]>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        int temp[][]=new int[hi-lo+1][2];
        List<Integer> list=new ArrayList();
        for(int i=lo;i<=hi;i++){
            q.add(new int[]{i,powerCal(i)});
        }
        while(k>1){
           q.remove(); 
        }
        return q.remove()[0];
    }
    public static void main(String[] args){
        System.out.println(getKth(12, 15, 2));
    }
}