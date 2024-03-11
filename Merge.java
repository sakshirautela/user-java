public class Merge {
    public static void merge(int[] array,int start,int mid,int end){
        int idx1=start;
        int idx2=mid+1;
        int i=0;
        int[] merge =new int[end-start+1];
        while(idx1<=mid && idx2<=end){
            if(array[idx1]>=array[idx2]){
                merge[i]=array[idx2];
                i++;
                idx2++;
            }
            else{
                merge[i]=array[idx1];
                i++;
                idx1++;
            }
        }
        while(idx1<=mid ){
            merge[i]=array[idx1];
            i++;
            idx1++;
            }
            while(idx2<=end){
                merge[i]=array[idx2];
                i++;
                idx2++;
                }
            int k=start;
        for(int j=0;j<merge.length;j++){
            array[k]=merge[j];
            k++;
        }
        
        
        }
    public static void split(int[] array,int start,int end){
        if(end<=start){
            return;
        }
        int mid=(end -start)/2+start;
        split(array,start,mid);
        split(array,mid+1,end);
        merge(array,start,mid,end);
        
    }

    
        public static void main(String args[]){
            int[] array={12,45,23,51,19,8};
            int size=array.length;
            // int start=0;
            // int end=size-1;
            split(array,0,size-1);
            for(int j=0; j<size-1; j++){
                System.out.println(array[j]);
            }
        }
}
