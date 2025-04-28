package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

public class FindAllPossibleRecipesfromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes,List<List<String>> ingredients,String[] supplies) {
        Set<String> available = new HashSet<>();
        for (String supply : supplies) {
            available.add(supply);
        }
        Queue<Integer> recipeQueue = new LinkedList<>();
        for (int idx = 0; idx < recipes.length; ++idx) {
            recipeQueue.offer(idx);
        }
        List<String> createdRecipes = new ArrayList<>();
        int lastSize = -1;
        while (available.size() > lastSize) {
            lastSize = available.size();
            int queueSize = recipeQueue.size();
            while (queueSize-- > 0) {
                int recipeIdx = recipeQueue.poll();
                boolean canCreate = true;
                for (String ingredient : ingredients.get(recipeIdx)) {
                    if (!available.contains(ingredient)) {
                        canCreate = false;
                        break;
                    }
                }

                if (!canCreate) {
                    recipeQueue.offer(recipeIdx);
                } else {
                    available.add(recipes[recipeIdx]);
                    createdRecipes.add(recipes[recipeIdx]);
                }
            }
        }

        return createdRecipes;
    }
    public boolean find(String[] recipes, int indx, List<List<String>> ingredients, HashSet<String> curr, List<String> list, int[] arr, HashMap<String, Integer> reci) {
        if (arr[indx] == -1) return false;
        if (arr[indx] == 1) return true;
        
        arr[indx] = -1;
        for (String ingred : ingredients.get(indx)) {
            if (!curr.contains(ingred)) {
                if (!reci.containsKey(ingred) || !find(recipes, reci.get(ingred), ingredients, curr, list, arr, reci)) {
                    arr[indx] = -1;
                    return false;
                }
            }
        }
        
        arr[indx] = 1; 
        curr.add(recipes[indx]);
        list.add(recipes[indx]);
        return true;
    }

    public List<String> findAllRecipes2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> reci = new HashMap<>();
        HashSet<String> curr = new HashSet<>(Arrays.asList(supplies));
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            reci.put(recipes[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                find(recipes, i, ingredients, curr, list, arr, reci);
            }
        }
        
        return list;
    }
}