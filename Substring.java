class Substring {
    public static String reverse(String s){
        String r="";
        for(int i=s.length()-1;i>=0;i--){
            r=r+s.charAt(i);
        }
        return r;
    }
    public static void main(String args[]){
      // String str="azcbobobegghakl";
       //String str="mississippi";
        String s,rev="";
        String h="issip";
        int count=0;
       for(int i=0;i<h.length();i++){
        for(int j=i+1;j<=h.length();j++){
            s=h.substring(i,j);
            System.out.println(reverse(s)+" xcv");
            System.out.println(s);


            if(h.equals(s)){
                
                    char result = s.charAt(0);
                    int re =s.indexOf(result);
                    System.out.println(re);
                }
            }
        }
        }
    
            
        
        /*int[] nums= {-1,2,1,-4};
        int target= 1;
        int sum=0;
        int[] arr= new int[5];
        int j=0;
        for(int i=0;i<nums.length;i++){ 
            sum=sum+nums[i];
            if(sum==target || sum-1==target || sum+1==target){
                
                
            }
            
            j++;
        }
        for(int i=0;i<arr.length;i++){ 
            
            System.out.println(arr);
            }*/
            
            
        }
    

        
        
     