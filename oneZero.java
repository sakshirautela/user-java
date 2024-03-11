public class oneZero {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for(int j=0;j<i+1;j++){
                if((i+j)%2==0){
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }
            }
            System.out.println();
        } 
        for(int i=0;i<5;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("* ");    
            }
            for(int k=5;k>i;k--){
                System.out.print("k");
            }
        }
        System.out.println();

    }
}
