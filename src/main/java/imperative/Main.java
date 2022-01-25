package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hai", Gender.MALE),
                new Person("Hoang", Gender.MALE),
                new Person("Huong", FEMALE),
                new Person("Viet", Gender.MALE),
                new Person("Yen", FEMALE)

        );



        System.out.println("Imperative approach:");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }

        for (Person woman : females) {
            System.out.println(woman);
        }


        System.out.println("Declarative approach:");
        Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);
        List<Person> women = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());


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
        MALE, FEMALE
    }
}
