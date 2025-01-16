import java.util.*;

public class MaximumAveragePassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Lambda to calculate the gain of adding an extra student
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
            Double.compare(b[0], a[0])
        );

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                new double[] {
                    calculateGain(passes + 1, totalStudents + 1),
                    passes + 1,
                    totalStudents + 1,
                }
            );
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (
            (double) (passes + 1) / (totalStudents + 1) -
            (double) passes / totalStudents
        );
    }
}class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());
        
        for(int[] cl : classes)
            pq.add(new ClassRecord(cl));
        
        ClassRecord cl;
        while(extraStudents-- > 0)
            pq.add(pq.remove().addOneStudent());
        
        double sum = 0;
        while(!pq.isEmpty()){
            cl = pq.remove();
            sum += (double)cl.pass / cl.total;
        }

        return sum / classes.length;
    }
}

class ClassRecord{
    int pass;
    int total;
    double inc;

    public ClassRecord(int[] array){
        pass = array[0];
        total = array[1];
        inc = getIncrement();
    }

    public ClassRecord addOneStudent(){
        pass++;
        total++;
        inc = getIncrement();
        return this;
    }

    private double getIncrement(){
        return (pass + 1.0) / (total + 1) - (double)pass / total;
    }
}

class Compare implements Comparator<ClassRecord>{
    public int compare(ClassRecord a, ClassRecord b){
        if(a.inc < b.inc)
            return 1;
        else if(a.inc > b.inc)
            return -1;
        else
            return 0;
    }
}