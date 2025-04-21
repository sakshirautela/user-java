public class Contestqone {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public long calculateScore(String[] instructions, int[] values) {
        int n = instructions.length;
        long score = 0;
        boolean[] visited = new boolean[n];
        int i=0;
        while(i<n && i>=0) {
            if (visited[i]) {
                break;
            }
            visited[i] = true;
            String instruction = instructions[i];
            int value = values[i];
            if (instruction.equals("add")) {
                score += value;
                i++;
            } else if (instruction.equals("jump")) {
                i += value ; 
            }
        }
        return score;
    }
}