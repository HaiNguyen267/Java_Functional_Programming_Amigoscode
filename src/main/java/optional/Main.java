package optional;

import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<IllegalArgumentException> supplier = () -> new IllegalArgumentException("AN ERROR OCCURRED!");
        Object o = Optional.ofNullable("hi")
                .orElseThrow(supplier);
        System.out.println(o);

        Optional.ofNullable("hainguyen@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending the message to: "+ email), // if present
                        () -> System.out.println("No email of receiver is defined") // when the optional is null (not present)
                );
    }
}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(this.email);
    }
}