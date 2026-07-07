package problemsolvingIII;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class JumpGameIII {
    static void main() {
        System.out.println(canReach(new int[]{3,0,2,1,2}, 2));
    }

    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (arr[curr] == 0) {
                return true;
            }
            int left = curr - arr[curr];
            int right = curr + arr[curr];
            if (left >= 0 && !visited[left]) {
                q.add(left);
                visited[left] = true;
            }
            if (right < n && !visited[right]) {
                q.add(right);
                visited[right] = true;
            }
        }
        return false;
    }
        public boolean canReachFast(int[] arr, int start) {
            if(start < 0 || start >= arr.length || arr[start] <0) return false;
            if(arr[start] == 0) return true;
            arr[start] = -arr[start];
            return canReach(arr,start+arr[start]) || canReach(arr, start-arr[start]);

        }
        List<Integer> visited = new ArrayList<Integer>();

        public boolean canReachFastFast(int[] arr, int start) {
            if(start < 0 || start >= arr.length || visited.size() == arr.length){
                return false;
            }

            if(arr[start]==0){
                return true;
            }

            else if(visited.contains(start) == false) {
                visited.add(start);
                if(arr[start] == 1 && arr[arr.length - 1] == 0) {
                    return true;
                }
                return canReach(arr, start+arr[start]) || canReach(arr, start - arr[start]);
            } else {
                return false;
            }
        }
}
