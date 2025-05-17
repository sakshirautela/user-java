package Optionals;
/*In Java, Optional is a container object used to represent the presence or absence of a value. It was introduced in Java 8 to provide a more robust way of handling null values and avoid NullPointerException errors. Optional is a class in the java.util package and is a final class.
Here's how Optional works:
Creating Optional instances:
Optional.of(value): Creates an Optional with the given non-null value. If the value is null, it throws a NullPointerException.
Optional.ofNullable(value): Creates an Optional with the given value, which can be null. If the value is null, it creates an empty Optional.
Optional.empty(): Creates an empty Optional.
Checking for presence:
isPresent(): Returns true if the Optional contains a value, false otherwise.
Accessing the value:
get(): Returns the value if present. Throws a NoSuchElementException if the Optional is empty. It is recommended to use isPresent() before calling get() to avoid exceptions.
orElse(defaultValue): Returns the value if present, otherwise returns the provided default value.
orElseGet(supplier): Returns the value if present, otherwise returns the result of calling the supplier function.
orElseThrow(exceptionSupplier): Returns the value if present, otherwise throws an exception produced by the exception supplier.
Performing actions:
ifPresent(consumer): Performs the given action with the value if present.
Transforming values:
map(function): If a value is present, applies the function to the value and returns an Optional containing the result. Otherwise, returns an empty Optional.
flatMap(function): Similar to map, but the function returns an Optional, and flatMap returns the Optional directly, without wrapping it in another Optional.
filter(predicate): Returns an Optional describing the value if the value matches the predicate, otherwise returns an empty Optional. */
import java.util.Optional;

public class OptionalImplementation {
    public static void main(String[] args) {
        String name = "Sakshi";
        String nullName = null;

        Optional<String> optionalName = Optional.of(name);
        Optional<String> optionalNullName = Optional.ofNullable(nullName);
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(optionalName);
        System.out.println(optionalNullName);
        System.out.println("Optional name is present: " + optionalName.isPresent());
        System.out.println("Optional null name is present: " + optionalNullName.isPresent());
        System.out.println("Empty optional is present: " + emptyOptional.isPresent());

        System.out.println("Name: " + optionalName.orElse("Default Name"));
        System.out.println("Null name: " + optionalNullName.orElse("Default Name"));

        optionalName.ifPresent(n -> System.out.println("Hello, " + n));

        String upperCaseName = optionalName.map(String::toUpperCase).orElse("No Name");
        System.out.println("Upper case name: " + upperCaseName);
    }
}
