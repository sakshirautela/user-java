package Optionals;

import java.util.Optional;

public class WhyOptionals {

    static class User {
        private String name;

        // Constructor
        public User(String name) {
            this.name = name;
        }

        // Getter using Optional
        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }
    }

    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User(null); // Name is missing

        // Handle Optional safely
        String name1 = user1.getName().orElse("Unknown");
        String name2 = user2.getName().orElse("Unknown");

        System.out.println("User 1: " + name1); // Output: User 1: Alice
        System.out.println("User 2: " + name2); // Output: User 2: Unknown

        // Using ifPresent
        user1.getName().ifPresent(n -> System.out.println("User 1 exists: " + n));
        user2.getName().ifPresent(n -> System.out.println("User 2 exists: " + n)); // Won't print
        String s = null;
        System.out.println(s);
    }

    public Optional<String> getName(User user) {
        return Optional.ofNullable(user.name);
    }

}