public class GarbageCollection {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int m=0,p=0,g=0;
        int idx=travel.length-1;
        for(int i = garbage.length-1;i>=0;i--) {
            for(int j = 0; j < garbage[i].length(); j++) {
                char ch=garbage[i].charAt(j);
                if(ch=='P'){
                    p++;
                }else if(ch=='G'){
                    g++;
                }else {
                    m++;
                }
            }
            if(idx>=0){
                m=(m!=0)?m+travel[idx]:m;                
                g=(g!=0)?g+travel[idx]:g;
                p=(p!=0)?p+travel[idx]:p;
                idx--;
            }
        }
        System.out.println(m+" "+p+" "+g);
        return m+g+p;
    }
    public static void main(String[] args){
        System.out.println(garbageCollection(new String[]{"G","P","GP","GG"},new int[]{2,4,3}));
    }
}