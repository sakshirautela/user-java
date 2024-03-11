import java.util.Stack;

class CountCollisions {
    public static int countCollisions(String directions) {
        Stack<Character> st = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < directions.length(); i++) {
            char ch = directions.charAt(i);
            if (st.isEmpty() || ch == 'R') {
                st.push(ch);
            } else {
                if (st.peek() == 'R') {
                    if (ch == 'L') {
                        count += 2;
                        st.pop();
                    } else if (ch == 'S') {
                        count++;
                        st.push('D');
                    }
                } else if(st.peek() == 'L'){
                    st.push(ch);
                }
                else if (st.peek() == 'S' || st.peek() == 'D') {
                    if (ch == 'L') {
                        count++;
                        st.pop();
                    } else {
                        st.push(ch);
                    }
                }
            }
        }
        System.out.println(st);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}