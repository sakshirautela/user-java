import java.util.ArrayList;

import java.util.List;

class KthFactor {
    public static int kthFactor(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                list.add(i);
            }
        }
        list.add(n);
        System.out.println(list);
        if(k<=list.size()){
            return list.get(k-1);
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(kthFactor(2,2));
    }
}