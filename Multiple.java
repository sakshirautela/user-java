public class Multiple{
    public static int[] reacuring(int[] array){
        int[] result=new int[10];
        int j=0;
        int pos=0;
        while(pos<array.length){
            for(int i=0;i<array.length;i++){
                if(i!=pos){
                    result[j]=array[i];
                    j++;
                }
            }
            pos++;
        }
        return result;
    }
    public static void main(String args[]){
            int[]array={2,3,4,5,1,2};
            int sum=0;
            String str="",new_str="";
            int temp=-1;
            int[] new_result=new int[10];
            
            for(int k=0;k<new_result.length;k++){
                new_result=reacuring(array);
                sum=sum+new_result[k];
                str=str+String.valueOf(new_result[k]);
                if(sum%3==0 && sum>temp){
                    temp=sum;
                    new_str=str;
                }
            }
            System.out.println(new_str);
    }
}