package problemsolvingIII;

import java.util.*;

public class WeeklyContets499 {
    static void main() {
        //System.out.println(findValidElements(new int[]{10, 2, 5, 10}));
       // System.out.println(sortVowels("epjaoxemio"));
        maxAlternatingSum(new int[]{3,5,4,2,4},1);
    }

    public static long maxAlternatingSum(int[] nums, int k) {
        List<Integer> peek = new ArrayList<>();
        List<Integer> valley = new ArrayList<>();
        int n = nums.length;
        int p=nums[0];
        int v=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(!(nums[i]<nums[i-1] && nums[i]>nums[i+1])){
                peek.add(nums[i]);
            }
            if(!(nums[i+1]<nums[i] && nums[i]<nums[i-1])){
                valley.add(nums[i]);
            }
        }
        long result =0;
        return result;
    }

    public long minOperations(int[] nums) {
        long ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                ans += nums[i - 1] - nums[i];
            }
        }
        return ans;
    }

    public static String sortVowels(String s) {
        String v = "aeiou";
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (v.indexOf(c) != -1) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                map2.putIfAbsent(c, i);
            }
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((c1, c2) -> {
            if (!map.get(c1).equals(map.get(c2))) {
                return map.get(c2) - map.get(c1);
            }
            return map2.get(c1) - map2.get(c2);
        });
        for (char arr : list) {
            System.out.println(arr);
        }
        List<Character> sorted = new ArrayList<>();
        for (char c : list) {
            int count = map.get(c);
            while (count > 0) {
                sorted.add(c);
                count--;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (v.indexOf(s.charAt(i)) != -1) {
                sb.setCharAt(i, sorted.get(j));
                j++;
            }
        }
        return sb.toString();
    }

    public static List<Integer> findValidElements(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(nums[i], suffix[i + 1]);
        }
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > prefix[i - 1] || nums[i] > suffix[i + 1]) {
                ans.add(nums[i]);
            }
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }
        if (nums.length > 1) {
            ans.add(nums[nums.length - 1]);
        }
        return ans;
    }
}