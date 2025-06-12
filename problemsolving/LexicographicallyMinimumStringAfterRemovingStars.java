import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public static void main(String[] args) {
        System.out.println(clearStars(""));
    }
    public static String clearStars(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>((a,b)->(s.charAt(a)==s.charAt(b))?b-a:(s.charAt(a)-s.charAt(b)));
        boolean[] toremove=new boolean[n];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='*'){
                toremove[pq.remove()]=true;
                toremove[i]=true;
            }else{
                pq.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if(!toremove[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    @SuppressWarnings("deprecation")
    public String clearStars2(String s) {
        int n = s.length();
        byte[] sc = new byte[n + 1];
        s.getBytes(0, n, sc, 0);
        sc[n] = '*';    // Extra '*' past end of string so no
                        //   limit checking needed in FOR loop.
        
        // Scan the string to get count of asterisks in the 
        // string.  When encountering an asterisk, if half of 
        // the characters from that asterisk back to the 
        // beginning of the string are asterisks, then the string 
        // from the start through that asterisk have an equal 
        // number of letters and asterisks, so that all of the 
        // characters up through that asterisk will be deleted, 
        // so set the start index for processing the string to 
        // the index after that asterisk.
        //
        // If no asterisks in the string, then return the string 
        // itself.  If exactly half of the characters in the 
        // string are asterisks, then the entire string will be 
        // deleted so return the empty string.
        int start = 0;
        int asteriskCount = 0;
        for (int i = 0; i < n; i++) {
            if (sc[i] == '*') {
                asteriskCount++;
                if (asteriskCount == ((i + 2) >> 1)) 
                    start = i + 1;
            }
        }
        if (asteriskCount == 0)  return s;
        if (start == n)  return "";
        
        // Remove '*' characters and rightmost lowest characters.
        // Set character values to zero to mark as deleted.
        // The array linkedLists[] contains linked lists, which 
        // are indexes into linkedLists[] of the previous 
        // occurrence of the same letter, or a -1 if no previous 
        // occurrence.  The array heads[] is indexed to the start 
        // of the letter's linked list in the linkedLists[] array.  
        // The heads[] array references the rightmost (most recent) 
        // occurence of that letter, or -1 is no occurrences of 
        // that letter.
        int[] linkedLists = new int[n];
        int[] heads = new int[128];
        for (int i = 'a'; i <= 'z'; i++)  
            heads[i] = -1;
        for (int idx = start; ; idx++) {
            int c = sc[idx];
            if (c == '*') {
                if (idx >= n)  break;
                sc[idx] = 0;
                for (int i = 'a'; ; i++) {
                    if (heads[i] >= 0) {
                        sc[heads[i]] = 0;  // Remove a letter from links.
                        heads[i] = linkedLists[heads[i]];
                        break;
                    }
                }
            } else {
                linkedLists[idx] = heads[c];     // Add a letter to links.
                heads[c] = idx;
            }
        }
        
        // Build the result string by removing deleted characters 
        // and collapsing the string.  Deleted chars were set to 
        // zero to mark that they were deleted.
        int outIdx = 0;
        for (int i = start; i < n; i++)
            if (sc[i] != 0)
                sc[outIdx++] = sc[i];
        
        return new String(sc, 0, outIdx);
    }
    @SuppressWarnings("unchecked")
    public String clearStars3(String s) {
        int n = s.length();
        boolean[] removed = new boolean[n];
        // For each letter 'a' to 'z', store indices (as a stack) where that letter appears.
        // We'll pop the rightmost occurrence of the smallest letter whenever we see a '*'.
        ArrayDeque<Integer>[] letterIndices = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            letterIndices[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                // Mark this '*' as removed
                removed[i] = true;
                // Remove the rightmost smallest character
                for (int j = 0; j < 26; j++) {
                    if (!letterIndices[j].isEmpty()) {
                        int idx = letterIndices[j].pop();
                        removed[idx] = true;
                        break;
                    }
                }
            } else {
                letterIndices[c - 'a'].push(i);
            }
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!removed[i] && s.charAt(i) != '*') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}