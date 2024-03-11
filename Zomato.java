import java.util.*;
class Food implements Comparable<Food>{
    String food;
    Integer rating;
    public Food(String food,Integer rating){
        this.food=food;
        this.rating=rating;
    }
    @Override
    public int compareTo(Food other){
        if(this.rating==other.rating){
            return this.food.compareTo(other.food);
        }else{
            return other.rating-this.rating;
        }
    }
}
public class Zomato {
    HashMap<String,PriorityQueue<Food>> cuisineMap;
    HashMap<String,String> dish;    
    HashMap<String,Integer> rateDish;

    public Zomato(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap=new HashMap<>();         
        rateDish=new HashMap<>();        
        dish=new HashMap<>();
        for (String i : cuisines) {
            cuisineMap.put(i,new PriorityQueue<>());
        }
        for(int i=0;i<foods.length;i++){
            dish.put(foods[i],cuisines[i]); 
            rateDish.put(foods[i],ratings[i]);
            cuisineMap.get(cuisines[i]).add(new Food(foods[i],ratings[i]));          
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuis=dish.get(food);
        rateDish.put(food,newRating);
        cuisineMap.get(cuis).add(new Food(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        Food maxRated=cuisineMap.get(cuisine).peek();
        while (maxRated.rating != rateDish.get(maxRated.food)) {
            cuisineMap.get(cuisine).poll();
            maxRated = cuisineMap.get(cuisine).peek();
        }
        return maxRated.food;
    }
    public static void main(String[] args) {
        // Example usage
        Zomato obj = new Zomato(
                new String[]{"Pizza", "Burger", "Salad"},
                new String[]{"Italian", "American", "Healthy"},
                new int[]{3, 1, 2}
        );

        obj.changeRating("Pizza", 5);

        String highestRatedFood = obj.highestRated("Italian");
        System.out.println("Highest Rated Italian Food: " + highestRatedFood);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
