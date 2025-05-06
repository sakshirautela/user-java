public class JumpingCaterpillars {
    public static void main(String[] args) {
        System.out.println(uneatenLeaves(new int[]{2, 3, 5},10));
    }
    public static int uneatenLeaves(int[] arr, int n) {
        boolean[] visit=new boolean[n+1];
        int len=arr.length;
        for(int i=0;i<len;i++){
            int nums=arr[i];
            int a=1;
            while (n>=nums*a) {
                visit[nums*a]=true;
                a++;
            }
        }
        int count=0;
        for (boolean b : visit) {
            if(!b){
                count++;
            }
        }
        return count-1;
    }
}
