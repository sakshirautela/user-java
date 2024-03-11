public class BinarySearch {
    public static void main(String args[]){
        int[] array={23,34,21,45,34};
        int size=array.length;
        int se=23;
        int low=0,high=size-1, mid,key=0;
        while(low<=high){
            mid= low+(high-low)/2;
            if(array[mid]==se){
                
            }
                
            if(se>array[mid]){
                low=mid+1;
            }
            else if(se<array[mid]){
                high=mid-1;
            }
            
            
        }

        
        if(key==1){
            System.out.println("Found");
        }
        else{
            System.out.println("nnnnFound");
        
        }
    }
    
}
