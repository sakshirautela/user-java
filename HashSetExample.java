package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetExample{
    public static void main(String[] args) {
        ArrayList<Integer> list = new   ArrayList<Integer>();
        HashSet<List<Integer>> set=new HashSet<List<Integer>>();
        for(int i=0;i<4;i++){
            list.add(23);
            list.add(45);
            list.add(23);
            list.add(2);

        }
        set.add(list);
        System.out.println(set);
    }
}