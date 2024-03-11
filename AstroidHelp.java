import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class AstroidHelp {
    public static void main(String[] args) {
        int[] astroids = { 5,10,-5 };
        int[] astro = asteroidCollision(astroids);
        for (int i : astro) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (Math.abs(asteroids[i]) > Math.abs(stack.peek())) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                
                
                if ((!stack.isEmpty() && stack.peek() > 0) && (Math.abs(asteroids[i]) == Math.abs(stack.peek()))) {
                    stack.pop();
                }
                else if(stack.peek() < 0 && asteroids[i]<0) {
                    stack.push(asteroids[i]);
                } 
                else if (stack.isEmpty() && asteroids[i] < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int n = 0;
        Stack<Integer> res = new Stack<Integer>();
        while (!stack.empty()) {
            int val = stack.pop();
            res.push(val);
        }
        int[] result = new int[res.size()];
        while (!res.empty()) {
            result[n] = res.pop();
            n++;
        }
        return result;
    }
}
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() + asteroid == 0) {
                    stack.pop();
                }
            }
        }
        
        int n = stack.size();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}