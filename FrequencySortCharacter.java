import java.util.*;
public class FrequencySortCharacter {
    static class Data implements Comparable<Data>{
        int freq;
        char ch;
        Data(int freq, char ch){
            this.freq = freq;
            this.ch = ch;
        }
        public int compareTo(Data other){
            if (this.freq != other.freq) {
                return other.freq - this.freq; // Sort by frequency in descending order
            }
            return this.ch - other.ch; 
        }
    }
    public static String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        PriorityQueue<Data> pq=new PriorityQueue<Data>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch, 0)+1);
        }
        for(char ch:hm.keySet()){
            pq.add(new Data(hm.get(ch),ch));
        }
        String result = "";
        while(!pq.isEmpty()){
            Data dt=pq.remove();
            for(int i=1;i<=dt.freq;i++){
                result=result+dt.ch;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(frequencySort("tree"));
    }
}