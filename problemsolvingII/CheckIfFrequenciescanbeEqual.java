import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class CheckIfFrequenciescanbeEqual {
    public static void main(String[] args) {
        System.out.println(sameFreq("xyyz"));
    }
    static boolean sameFreq(String s) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        HashSet<Integer> hs=new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            hs.add(freq[i]);
        }
        if(hs.size()>2){
            return false;
        }
        if(hs.size()==1){
            return true;
        }
        int a=-1,b=-1;
        Iterator<Integer> it=hs.iterator();
        while (it.hasNext()) {
            if(a!=-1){
                a=it.next();
            }else {
                b=it.next();
            }
        }
        return (a==1||b==1 || Math.abs(a-b)==1);
    }
    static boolean sameFreq3(String s) {
        // code here
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            freq[i]--; 

            if (checkForAllSame(freq)) return true;

            freq[i]++;
        }

        return false;
    }

    public static boolean checkForAllSame(int[] freq) {
        int target = 0;

        for (int f : freq) {
            if (f == 0) continue;

            if (target == 0) {
                target = f;
            } else if (f != target) {
                return false;
            }
        }

        return true;

    }
    
    public static boolean sameFreq2(String s) {
        
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int f : freq) {
            if (f > 0) {
                freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
            }
        }

        if (freqCount.size() == 1) {
            return true;
        }

        if (freqCount.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = 
            freqCount.entrySet().iterator();
            
            Map.Entry<Integer, Integer> entry1 = it.next();
            Map.Entry<Integer, Integer> entry2 = it.next();

            int freq1 = entry1.getKey(), count1 = entry1.getValue();
            int freq2 = entry2.getKey(), count2 = entry2.getValue();

            if ((freq1 == 1 && count1 == 1) ||
            (freq2 == 1 && count2 == 1)) {
                return true;
            }
            if (Math.abs(freq1 - freq2) == 1 &&
               ((count1 == 1 && freq1 > freq2) || 
               (count2 == 1 && freq2 > freq1))) {
                return true;
            }
        }
        return false;
    }

}