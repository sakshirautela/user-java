class ZigZagConversion {
    public static String convert(String s, int numRows) {
        char[][] temp=new char[numRows][(s.length()/numRows)*2];//(s.length()/numRows)+2];
        String res="";
        int row = 0;
        int col = 0;
        boolean check = false;  
  
        for (int idx = 0; idx < s.length(); idx++) {
             temp[ row ] [col] = s.charAt( idx);
            if  (row ==  0   || row == numRows - 1) {
                check= ! check;  // Change direction when reaching the top or bottom row
            }  
            if (check) {
                row++;
            } else {
                row--;
                col++;
            }
        }
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                if(temp[i][j]!='\u0000'){
                    res+=temp[i][j];
                }
            }
        }
        prrint(temp);
        return res;
    }

    private static void prrint(char[][] temp) {
        for (int a = 0; a < temp.length; a++) {
            for (int b = 0; b < temp[0].length; b++) {
                System.out.print(temp[a][b] + " ");
                ;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(convert("paypal", 3));
    }
}