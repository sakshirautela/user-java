public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(binarySearch(matrix[i], target,i)){
                return true;
            }
        }
        return false;
    }
    private static boolean binarySearch(int[] is, int target, int i) {
        int s=0;
        int l=is.length-1;
        while(s<=l){
            int mid=(l+s)/2;
            if(is[mid]==target){
                return true;
            }
            if(is[mid]<target){
                s=mid+1;
            }else{
                l=mid-1;
            }
        }
        return false;
    }
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int r=0,c=matrix[0].length-1;
        while(r<matrix[0].length && c>=0){
            if(matrix[r][c]>target){
                c--;
            }else if(matrix[r][c]<target){
                r++;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix ={{}};
        System.out.println(searchMatrix(matrix,3));
    }
}