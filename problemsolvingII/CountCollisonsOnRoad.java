import java.util.Stack;

public class CountCollisonsOnRoad {
    public static void main(String[] args) {
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

    public static int countCollisionsFast(String directions) {
        int result=0;
        char[] d=directions.toCharArray();
        int l=0;
        int n=directions.length();
        while (l<n && d[l]=='L'){
            l++;
        }
        int r=n-1;
        while (r>=0 && d[r]=='R'){
            r--;
        }
        for(int i=l;i<=r;i++){
            result+=(d[i]=='S')?0:1;
        }
        return result;
    }
        public static int countCollisions(String directions) {
        int n = directions.length();
//        System.out.println(n);
        int result = 0;
        Stack<Character> st = new Stack<>();
        for (char ch : directions.toCharArray()) {
            if (ch == 'L' && !st.isEmpty() && st.peek() == 'R') {
                result += 2;
                st.pop();
                int count=0;
                while (!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    count++;
                }
                result+=count;
                st.push('S');
            } else if (ch == 'L' && !st.isEmpty() && st.peek() == 'S') {
                result += 1;
            } else if (ch == 'R') {
                st.push(ch);
            }else if(ch=='S'){
                int count=0;
                while (!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    count++;
                }
                result+=count;
                st.push(ch);
            }

        }
        return result;
    }
}
