import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountMentionsPerUsers {
    public static void main(String[] args) {
        int[] res = countMentions(4, new ArrayList<>());
    }

    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });

        int[] result = new int[numberOfUsers];
        int[] offline = new int[numberOfUsers];
        for (List<String> li : events) {
            int time = Integer.parseInt(li.get(1));
            if (li.get(0).equals("MESSAGE")) {
                if (li.get(2).equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        result[i]++;
                    }
                } else if (li.get(2).equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (offline[i] <= time) {
                            result[i]++;
                        }
                    }
                } else {
                    String[] ids = li.get(2).split(" ");
                    for (String id : ids) {
                        int i_d = Integer.parseInt(id.substring(2));
                        result[i_d]++;
                    }
                }
            } else {
                offline[Integer.parseInt(li.get(2))] = time + 60;
            }
        }
        return result;
    }
}