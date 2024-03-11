public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        int[] result = new int[n];
        for (int i = 0; i < trust.length; i++) {
            result[trust[i][0] - 1] = 1;
        }
        int res = -1;
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && count <= 1) {
                count++;
                res = i + 1;
            } else if (count > 1) {
                return -1;
            }
        }
        return res;
    }

    public int findJudge2(int n, int[][] trust) {
        int m = trust.length;
        int indegree[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            indegree[trust[i][1]]++;
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1) {
                answer = i;
            }
        }

        for (int i = 0; i < m; i++) {
            if (trust[i][0] == answer) {
                return -1;
            }
        }

        return answer == 0 ? -1 : answer;

    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));
    }
}