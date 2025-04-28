package com.learn.java.problemsolving;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfStudentsUnableToEatLunch {

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Queue<Integer> sandwichQueue = new LinkedList<>();

        // Add students to the queue
        for (int student : students) {
            studentQueue.offer(student);
        }

        // Add sandwiches to the queue
        for (int sandwich : sandwiches) {
            sandwichQueue.offer(sandwich);
        }

        int count = 0;

        while (!studentQueue.isEmpty() && count < studentQueue.size()) {
            if (studentQueue.peek().equals(sandwichQueue.peek())) {
                // Student eats the sandwich
                studentQueue.poll();
                sandwichQueue.poll();
                count = 0; // reset counter
            } else {
                // Student goes to the end of the line
                studentQueue.offer(studentQueue.poll());
                count++;
            }
        }

        return studentQueue.size(); // students left who couldn't eat
    }

    public static void main(String... args) {
        System.out.println(countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        // Expected Output: 0
    }
}
