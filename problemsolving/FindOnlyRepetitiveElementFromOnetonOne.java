import java.util.HashMap;

public class FindOnlyRepetitiveElementFromOnetonOne {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{}));
    }
    public static int findDuplicate(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
            if(hm.get(i)==2){
                return i;
            }
        }
        return -1;
    }
}
/*class Solution {
public:
    int findDuplicate(vector<int>& arr) {
        int slow = arr[0];
        int fast = arr[0];

        // Detect cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Find entrance to the cycle
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
};


🧠 Intuition: Treat array values as pointers (like a linked list).
Si */
