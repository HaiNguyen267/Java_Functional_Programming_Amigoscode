package finalsedtion;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        hello("Hai", null, value -> {
            System.out.println("no lastname was provided for: " + value);
        });

        hello2("Hieu",
                null,
                () -> System.out.println("Hey, your are calling callback function!!!!!!!"));

        Function<String, String> redundant = String::toUpperCase;

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println("First name: " + firstName);
        if (lastName != null) {
            System.out.println("Last name: " + lastName);
        } else {
            callback.accept(firstName);
        }
    }
    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println("First name: " + firstName);
        if (lastName != null) {
            System.out.println("Last name: " + lastName);
        } else {
            callback.run();
        }
    }
//    function hello(firstName, lastName,callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }
}
