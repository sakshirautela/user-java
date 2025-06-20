import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class AnimalWildCard {
    public void sound() {
        System.out.println("Some sound");
    }
}

class DogWildCard extends AnimalWildCard {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

class CatWildCard extends AnimalWildCard {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

class AnimalDemoWildCard {
    public static void makeSound(List<? extends AnimalWildCard> animals) {
        for (AnimalWildCard animal : animals) {
            animal.sound();
        }
    }

    public static void main(String[] args) {
        List<DogWildCard> dogs = List.of(new DogWildCard(), new DogWildCard());
        List<CatWildCard> cats = List.of(new CatWildCard(), new CatWildCard());

        makeSound(dogs);  // Valid
        makeSound(cats);  // Valid
    }
}
class WildCard {
    public static double GetList(List<?> li) {
        for (Object el : li) {
            System.out.println(el);
        }
        return 0;
    }
}

public class WildCardInGeneric {
    @SuppressWarnings({ "static-access", "unused" })
    public static void main(String[] args) {
        List<?> li = new ArrayList<String>(Arrays.asList("hello", "Sakshi"));
        // li.add("hii");
        List<? extends Number> numbers;
        numbers = List.of(1, 2, 3); // List of Integer is valid
        numbers = List.of(1.1, 2.2, 3.3); // List of Double is valid
        //List<Integer> intList = List.of(1, 2, 3);
        WildCard wd = new WildCard();
        wd.GetList(li);

        List<? extends Number> numbers2 = List.of(1, 2, 3);
        // numbers.add(4); // Error: You can't add elements, because it doesn't know the
        // exact type
        numbers2.add(null); // Valid: You can add null

    }
}
