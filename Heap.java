import java.util.ArrayList;
public class Heap {
    public static void main(String[] args) {
        Heap hp=new Heap();
        ArrayList<Integer> ar=new ArrayList<>();
        insert(ar, 2);
        insert(ar, 10);
        insert(ar, 5);
        insert(ar, 3);
        insert(ar, 4);
        insert(ar, 1);
        hp.remove(ar);
        System.out.println(ar);
    }
    static void insert(ArrayList<Integer> ar,int data){
        ar.add(data);
        int n=ar.size()-1;
        int par=(n-1)/2;
        while (ar.get(par)>ar.get(n)) {
            int temp=ar.get(par);
            ar.set(par,ar.get(n));
            ar.set(n, temp);
            n=par;
            par = (n - 1) / 2;
        }
    }
    static int  remove(ArrayList<Integer> ar){
        int data=ar.get(0);
        int n=ar.size()-1;
        //swap with last index
        int temp=ar.get(n);
        ar.set(0,ar.get(n));
        ar.set(n, temp);

        //remove last index
        ar.remove(n);

        //manage heap called heapify
        heapify(0,ar);
        return data;
        
    }
    private static void heapify(int i,ArrayList<Integer> ar) {
        int lc=2*i+1;
        int rc = 2 * i + 2;
        int minidx=i;

        if(lc<ar.size() && ar.get(minidx)>ar.get(lc) ){
            minidx=lc;
        }
        if (rc < ar.size() && ar.get(minidx) > ar.get(rc)) {
            minidx = rc;
        }

        if(minidx!=i){
            //swap minidx and i
            int temp=ar.get(minidx);
            ar.set(minidx, ar.get(i));
            ar.set(i, temp);
            heapify(minidx, ar);
        }


    }
    public static void heapSort(ArrayList<Integer> ar){
        for (int i = 0; i < ar.size(); i++) {
            
        }
    }
    static boolean isEmpty(ArrayList<Integer> ar){
        return ar.size()==0;
    }
}
