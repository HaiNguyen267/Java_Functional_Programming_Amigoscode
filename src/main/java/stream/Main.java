package stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hai", 12, Gender.MALE),
                new Person("Hieu", 12, Gender.MALE),
                new Person("Hien", 24, Gender.FEMALE),
                new Person("Hoang", 30, Gender.MALE),
                new Person("Huong", 23, Gender.FEMALE)

        );
        Predicate<Person> olderThan20 = (person) -> person.age >= 20;

        System.out.println("Declarative approach: (print out people older than or equal 20)");
        people.stream()
                .filter(olderThan20)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("sorting by age");
        Function<Person, Integer> getAge = person -> person.age;
        Function<Person, Gender> getGender = person -> person.gender;
        people.stream()
                .sorted(Comparator.comparing(getAge).thenComparing(getGender).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("all match");
        boolean b = people.stream()
                .allMatch(person -> person.name.equals("Hai") || person.name.equals("Hieu"));

        System.out.println(b);

        System.out.println("any match");
        boolean b1 = people.stream()
                .anyMatch(person -> person.age == 12);
        System.out.println(b1);


        boolean b2 = people.stream().noneMatch(person -> person.age < 10);
        System.out.println("There is no person under 10: " + b2);

        System.out.println("below this line");
        people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

        System.out.println("if the min present");
        people.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

        System.out.println("After grouping!");
        Optional<String> youngest = people.stream()
                .min(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        youngest.ifPresent(System.out::println);
    }
}
