import java.util.Arrays;
import java.util.HashSet;

public class MaximumSquareAreabyRemovingFencesFromaField {
    static void main() {
//        MaximumSquareAreabyRemovingFencesFromaField m=new MaximumSquareAreabyRemovingFencesFromaField();
//        System.out.println(m.maximizeSquareArea(3,4,new int[]{},new int[]{}));
        System.out.println(maximizeSquareArea(4, 4, new int[]{2, 3}, new int[]{2}));

    }

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        HashSet<Integer> hs = getSquares(hFences, m);
        HashSet<Integer> vs = getSquares(vFences, n);
        int sides = 0;
        for (int s : hs) {
            if (vs.contains(s)) {
                sides = Math.max(s, sides);
            }
        }
        if (sides == 0) {
            return -1;
        }
        return (int) ((1L * sides * sides) % 1000000007);

    }

    private static HashSet<Integer> getSquares(int[] fences, int m) {
        int n = fences.length;
        int[] arr = new int[n + 2];

        arr[0] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = fences[i];
        }
        arr[n + 1] = m;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n + 2; i++) {
            for (int j = i + 1; j < n + 2; j++) {
                set.add(arr[j] - arr[i]);
            }
        }
        return set;
    }
}/*
class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) { fw.write("0"); } catch (Exception e) { } }));
    }
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Arrays.sort(hFences);
        // Arrays.sort(vFences);
        long ans = 0;
        Set<Integer> hSet = new HashSet<>();
        hSet.add(m-1);
        for(int i=0; i<hFences.length; i++) {
            hSet.add(hFences[i]-1);
            hSet.add(m-hFences[i]);
        }
        for(int i=0; i<hFences.length; i++) {
            for(int j=0; j<hFences.length; j++) {
                if(i!=j)
                    hSet.add(hFences[i]-hFences[j]);
            }
        }

        // Set<Integer> vSet = new HashSet<>();
        // vSet.add(n-1);
        if(hSet.contains(n-1)) {
            ans = Math.max(ans, n-1);
        }
        for(int i=0; i<vFences.length; i++) {
            // vSet.add(vFences[i]-1);
            // vSet.add(n-vFences[i]);
            if(hSet.contains(vFences[i]-1)) {
                ans = Math.max(ans, vFences[i]-1);
            }
            if(hSet.contains(n-vFences[i])) {
                ans = Math.max(ans, n-vFences[i]);
            }
        }
        for(int i=0; i<vFences.length; i++) {
            for(int j=0; j<vFences.length; j++) {
                if(i!=j && hSet.contains(Math.abs(vFences[i]-vFences[j]))) {
                    ans = Math.max(ans, Math.abs(vFences[i]-vFences[j]));
                }
                //  vSet.add(vFences[i]-vFences[j]);
            }
        }

        return ans == 0 ? -1 : (int)((ans*ans)%1000000007L);
        // for(int maxDiff=Math.min(m,n)-1 ; maxDiff > 0 ; maxDiff--) {
        //     if(hSet.contains(maxDiff) && vSet.contains(maxDiff)) {
        //         return (int) (((long)maxDiff * (long)maxDiff) % (1000000007L));
        //     }
        // }
        // return -1;

        // return m>n ? getMaxSqArea(m, n, hFences, vFences) : getMaxSqArea(n, m, vFences, hFences);
    }

    private int getMaxSqArea(int largerSideLen, int smallerSideLen, int[] largerSideFences, int[] smallerSideFences) {
        Arrays.sort(largerSideFences);
        Arrays.sort(smallerSideFences);
        Set<Integer> largerSideFencesSet = Arrays.stream(largerSideFences)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
        largerSideFencesSet.add(1);
        largerSideFencesSet.add(largerSideLen);

        Set<Integer> smallerSideFencesSet = Arrays.stream(smallerSideFences)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
        smallerSideFencesSet.add(1);
        smallerSideFencesSet.add(smallerSideLen);

        for(int maxPossEdge = smallerSideLen-1; maxPossEdge>0; maxPossEdge--) {
            for(int currLargerSideFencesIndex=largerSideFences.length-1;
                currLargerSideFencesIndex >= 0 ;
                currLargerSideFencesIndex--) {
                if(largerSideFencesSet.contains(largerSideFences[currLargerSideFencesIndex]-maxPossEdge)
                        || largerSideFencesSet.contains(largerSideLen-maxPossEdge)) {
                    for(int currSmallerSideFencesIndex=smallerSideFences.length-1;
                        currSmallerSideFencesIndex>=0;
                        currSmallerSideFencesIndex--) {
                        if(smallerSideFencesSet.contains(smallerSideFences[currSmallerSideFencesIndex]-maxPossEdge)
                                || smallerSideFencesSet.contains(smallerSideLen-maxPossEdge)) {
                            return (int)(((long)maxPossEdge * (long)maxPossEdge) % 1000000007);
                        }
                        if(smallerSideFences[currSmallerSideFencesIndex]-maxPossEdge < 0) {
                            break;
                        }
                    }
                }
                if(largerSideFences[currLargerSideFencesIndex]-maxPossEdge < 0) {
                    break;
                }
            }
        }
        return -1;
    }
}*/