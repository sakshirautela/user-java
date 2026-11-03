package data_structure;

import java.util.*;

public class InclusionExclusionPrinciple {
    public static void main(String[] args) {


    }
    public  static List<Integer> union(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        return new ArrayList<>(set);
    }
}
class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder a= new StringBuilder();
        for(int c:s.toCharArray()){
            StringBuilder b= new StringBuilder();
            for(int i=0;i<7;i++){
                b.append(c & 1);
                c=c>>1;
            }
            a.append(b.toString());
        }
        int i=0,j=a.length()-1;
        System.out.println(a);

        while(i<j){
            if(a.charAt(i)!=a.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }
        return true;
    }
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        List<List<Integer>> ans=new ArrayList<>();
        int[] range=new int[2];
        range[0]=-1;
        int size=0;
        for(int k=lower;k<=upper ;k++){
            if(set.contains(k)){
                if(range[0]!=-1){
                    ans.add(new ArrayList<>());
                    size++;
                    ans.get(size-1).add(range[0]);
                    ans.get(size-1).add(range[1]);
                    range[0]=-1;
                }
            }else{
                if(range[0]==-1){
                    range[0]=k;
                }
                range[1]=k;
            }
        }
        if(range[0]!=-1){
            ans.add(new ArrayList<>());
            size++;
            ans.get(size-1).add(range[0]);
            ans.get(size-1).add(range[1]);
            range[0]=-1;
        }
        return ans;
    }
    static  int range=  100000;
    static boolean[] prime=new boolean[range+1];
    static List<List<Integer>> factors=new ArrayList<>();
    static void initPrime( ){
        java.util.Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= range; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= range; i += p) {
                    prime[i] = false;
                }
            }
        }
    }
    static void initFactors( ){
        for (int p = 0;p <= range; p++) {
            factors.add(new ArrayList<>());
        }
            for (int p = 2;p <= range; p++) {
            if (prime[p]) {
                for (int i = p ; i <= range; i += p) {
                        factors.get(i).add(p);
                }
            }
        }
    }
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        initPrime();
        initFactors();
        for(int i=0;i<n;i++){
            HashSet<Integer> set=new HashSet<>();
            while (i<n && !prime[nums[i]]){
                set.addAll(factors.get(nums[i]));
                i++;
            }
            res=Math.max(res,set.size());
        }
        return res;
    }
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int[] st = new int[n*4];
        boolean[] ans = new boolean[n];
        return new boolean[n];
    }
}
