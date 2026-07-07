
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CountDaysWithoutMeetings {
    public static void main(String[] args) {
        System.out.println(countDays(5, new int[][] { {} }));
    }


    public static int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            latestEnd = Math.max(latestEnd, end);
        }
        freeDays += days - latestEnd;

        return freeDays;
    }
    public static int countDays2(int days, int[][] meetings) {
        int freeDays = days;
        TreeMap<Integer, Integer> meetingDays = new TreeMap<>();
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            // System.out.printf("Meeting: (%SearchzforSubarray, %SearchzforSubarray)\n", start, end);
            int overlapDays = 0;

            Map.Entry<Integer, Integer> previousMeetingDays = meetingDays.floorEntry(start);
            if (previousMeetingDays != null && previousMeetingDays.getValue() >= start - 1) {
                if (previousMeetingDays.getValue() >= end) continue; // Complete overlap
                overlapDays = previousMeetingDays.getValue() - previousMeetingDays.getKey() + 1;
                // System.out.printf("Overlapping previous: (%SearchzforSubarray, %SearchzforSubarray)\n", previousMeetingDays.getKey(), previousMeetingDays.getValue());
                start = previousMeetingDays.getKey();
            }

            Map.Entry<Integer, Integer> nextMeetingDays = meetingDays.ceilingEntry(start + 1);
            while (nextMeetingDays != null && nextMeetingDays.getKey() <= end + 1) {
                meetingDays.remove(nextMeetingDays.getKey());
                overlapDays += nextMeetingDays.getValue() - nextMeetingDays.getKey() + 1;
                // System.out.printf("Overlapping next: (%SearchzforSubarray, %SearchzforSubarray)\n", nextMeetingDays.getKey(), nextMeetingDays.getValue());
                if (nextMeetingDays.getValue() >= end) {
                    end = nextMeetingDays.getValue();
                    break;
                }
                nextMeetingDays = meetingDays.ceilingEntry(start + 1);
            }

            meetingDays.put(start, end);
            freeDays -= (end - start + 1) - overlapDays;
            // System.out.printf("Result: (%SearchzforSubarray, %SearchzforSubarray)\n", start, end);
            // System.out.printf("FreeDays - ((%SearchzforSubarray - %SearchzforSubarray + 1) - %SearchzforSubarray) = %SearchzforSubarray\n\n", end, start, overlapDays, freeDays);
            if (freeDays == 0) break;
        }
        return freeDays;

    }
}
