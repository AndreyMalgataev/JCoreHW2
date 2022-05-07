package T2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                            names.get(new Random().nextInt(names.size())),
                            families.get(new Random().nextInt(families.size())),
                            new Random().nextInt(100),
                            Sex.values()[new Random().nextInt(Sex.values().length)],
                            Education.values()[new Random().nextInt(Education.values().length)]
                    )
            );
        }

        long minors = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();

        List<String> recruits = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 27)
                .map(person -> person.getFamily().toString())
                .collect(Collectors.toList());

        List<Person> workables = persons.stream()
                .filter(person -> person.getEducation()==Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        System.out.println("Несовершеннолетних:\n" + String.format("%,d", minors));

        System.out.println("\nПризывников:");
        recruits.stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\nРаботоспособных с высшим образованием:");
        workables.stream()
                .limit(10)
                .map(Person::getFamily)
                .forEach(System.out::println);

    }
}
