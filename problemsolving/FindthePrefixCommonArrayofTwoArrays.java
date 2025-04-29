
public class FindthePrefixCommonArrayofTwoArrays {

    public static void main(String[] args) {
        int[] res = findThePrefixCommonArray(new int[] {}, new int[] {});
        for (int i : res) {
            System.out.print(i);
        }
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n];
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int a = 0;
            freq[A[i] - 1]++;
            freq[B[i] - 1]++;
            for (int j = 0; j < n; j++) {
                if (freq[j] == 2) {
                    a++;
                }
            }
            res[i] = a;
        }
        return res;
    }

    public int[] findThePrefixCommonArray2(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int freq[] = new int[A.length + 1];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2)
                count++;
            freq[B[i]]++;
            if (freq[B[i]] == 2)
                count++;
            ans[i] = count;
        }

        return ans;
    }

    // Map<Integer,Integer> hm=new HashMap<>();
    // for(int i=0;i<A.length;i++){
    // hm.put(A[i],hm.getOrDefault(A[i],0)+1);
    // hm.put(B[i],hm.getOrDefault(B[i],0)+1);
    // int count=0;
    // if(hm.get(A[i])==2){
    // count++;
    // }
    // if(hm.get(B[i])==2 && A[i]!=B[i]){
    // count++;
    // }
    // if(i==0){
    // ans[i]=count;
    // }
    // else{
    // ans[i]=count+ans[i-1];
    // }
    // }
}
