package stream;

import imperative.Main;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hai", Gender.MALE),
                new Person("Hoang", Gender.MALE),
                new Person("Huong", Gender.FEMALE),
                new Person("Viet", Gender.MALE),
                new Person("Yen", Gender.FEMALE)

        );
        // stream = abstraction mode, you should learn Stream API
        Collector<Integer, ?, Set<Integer>> integerSetCollector = Collectors.toSet();
        Consumer<Integer> println = System.out::println;

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean b = people.stream()
                .noneMatch(person -> person.gender.equals(Gender.PREFER_NOT_TO_SAY));

        System.out.println("No any person with prefer not to say gender : " + b);

        people.stream().sorted(Comparator.comparing(person -> person.name)).forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
