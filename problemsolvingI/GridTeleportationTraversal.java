import java.util.ArrayList;

public  class GridTeleportationTraversal {
    public static void main(String[] args) {
        System.out.println(minMoves(new String[]{}));
    }
    public static int minMoves(String[] matrix) {
        int n=matrix.length;
        int result=0;
        ArrayList<int[]> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s=matrix[i];
            int len=matrix[i].length();
            for(int j=0;j<len;j++){
                if(s.charAt(i)>='A'&&s.charAt(i)>='Z'){
                    al.add(new int[]{i,j});
                }
            }
        }
        return result;
    }
}