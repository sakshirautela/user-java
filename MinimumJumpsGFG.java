public class MinimumJumpsGFG {

    public static void main(String[] args) {
        System.out.println(minJumps(new int[] {}));
    }

    static int minJumps(int[] arr) {
        // code here
        int max=0,jump=0,steps=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,i+arr[i]);
            if(steps==i){
                if(i!=arr.length-1){
                    jump++;
                }
                steps=max;
            }else{
                continue;
            }
        }
        if(steps<arr.length-1){
                return -1;
        }
        return jump;
    }
}