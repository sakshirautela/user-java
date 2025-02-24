import java.util.ArrayList;

public class ProductOfNumbers {
    ArrayList<Integer> al;
    int size;
    public ProductOfNumbers() {
        al=new ArrayList<>();
        size=0;
    }
    
    public void add(int num) {
        al.add(num);
        size++;
    }
    
    public int getProduct(int k) {
        int product=1;
        for(int i=size-1;i>size-k;i--){
            product*=al.get(i);
        }
        return product;
    }
}
/*
 * class ProductOfNumbers {

    ArrayList<Integer>list=new ArrayList<>();
    int prod=1;

    public ProductOfNumbers() {
    }
    
    public void add(int num) {

        if(num==0){
            list=new ArrayList<>();
            prod=1;
            return;
        }
        prod=prod*num; 
        list.add(prod);       
    }
    
    public int getProduct(int k) {
        if(list.size()<k)return 0;
        int ans=list.get(list.size()-1);
        if(list.size()==k)return ans;
        return ans/list.get(list.size()-1-k);
    }
}


 */
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */