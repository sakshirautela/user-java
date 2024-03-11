public class SegmentTreeImp {
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int createSt(int[] array,int stidx,int start,int end){
        if(start==end){
            tree[stidx]=array[start];
            return array[start];
        }
        int mid=(start+end)/2;
        int left=createSt(array, 2*stidx+1, start, mid);        
        int right=createSt(array, 2*stidx+2, mid+1, end);
        return tree[stidx]=left+right;
    }
    public static int getSumUtil(int sti,int si,int sj,int qi,int qj){
        if(si>=qj|| sj<=qi){
            return 0;
        }else if(qi<=si && qj<=sj){
            return tree[sti];
        }else{
            int mid=(si+sj)/2;
            return getSumUtil(2*sti+1,si,mid,qi,qj)+getSumUtil(2+sti+2,mid+1,sj,qi,qj);
        }
    }
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8};
        int n=array.length;
        init(n);
        createSt(array, 0, 0, n-1);
        System.out.println(getSum(2,5));
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i]+" ");
        }
    }
    private static int getSum(int i, int j) {
        return getSumUtil(0, i,j,0, 7);
    }
}
