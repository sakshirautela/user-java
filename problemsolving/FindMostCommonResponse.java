import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindMostCommonResponse {
    public String findCommonResponseWrong(List<List<String>> responses) {
        int n=responses.size();
        for(int i=0;i<n;i++){
            Collections.sort(responses.get(i));
        }
        HashMap<String ,Integer> freq=new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < responses.get(i).size(); j++) {
                int idx=j+1;
                while (idx<responses.get(i).size() && responses.get(i).get(j)==responses.get(i).get(idx)) {
                    responses.get(i).remove(idx);
                    idx++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < responses.get(i).size(); j++) {
                freq.put(responses.get(i).get(j),freq.getOrDefault(responses.get(i).get(j), 0)+1);
            }
        }
        int count=0;
        String res="";
        for (String str : freq.keySet()) {
            if(freq.get(str)>count){
                count=freq.get(str);
                res=str;
            }
        }
        return res;
    }
    public String findCommonResponse(List<List<String>> responses) {
        if (responses == null || responses.isEmpty()) {
            return ""; // or handle as appropriate
        }

        HashMap<String, Integer> freq = new HashMap<>();

        for (List<String> responseList : responses) {
            if (responseList == null || responseList.isEmpty()) {
                continue; // skip empty lists
            }

            // Remove duplicates within the same response list
            HashSet<String> uniqueResponses = new HashSet<>(responseList);

            // Count frequencies
            for (String response : uniqueResponses) {
                freq.put(response, freq.getOrDefault(response, 0) + 1);
            }
        }

        if (freq.isEmpty()) {
            return ""; // all response lists were empty
        }

        // Find the response with the highest frequency
        String mostCommon = "";
        int maxCount = 0;

        for (HashMap.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount || 
                (entry.getValue() == maxCount && entry.getKey().compareTo(mostCommon) < 0)) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }
}
