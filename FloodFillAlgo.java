public class FloodFillAlgo {
    public static void helper(int[][] image,int sc,int sr,int color,boolean[][] visit,int orgCol){
        if(sc <0 || sr<0 || sc>=image[0].length || sr>=image.length || visit[sr][sc] || image[sr][sc]!=orgCol){
            return;
        } 

        if(image[sr][sc]==orgCol){
            image[sr][sc]= color;
            visit[sr][sc]=true;
        }
        helper(image,sc,sr-1,color,visit,orgCol);
        helper(image,sc,sr+1,color,visit,orgCol);
        helper(image,sc-1,sr,color,visit,orgCol);
        helper(image,sc+1,sr,color,visit,orgCol);
        
    }
    public static void/*int[][]*/ floodFillAlgo(int[][] image,int sc,int sr,int color){
        boolean visit[][]=new boolean[image.length][image[0].length];
        helper(image,sc,sr,color,visit,image[sr][sc]);
        // return image;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] image={{0,0,0},{0,0,0}};
        
        /*{{1,1,1},
                        {1,1,0},
                        {1,0,1}};*/
        floodFillAlgo(image,1,1,2);
    }
}
