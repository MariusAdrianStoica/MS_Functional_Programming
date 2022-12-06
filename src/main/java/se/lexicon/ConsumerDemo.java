package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        //consumer takes param and returns nothing (void)
        //used during iteration Collections and Streams

        Consumer<String>  printMessage = (param) -> System.out.println(param);

        printMessage.accept("Hello Consumer Interface!");

        Consumer<Person> printPersonFullName = (person) -> System.out.println(person.getFirstname()+"  "+person.getLastname());
        Consumer<Person> getSummary = (person) -> System.out.println(person.toString());

        Person person = new Person(
                1,
                "Test",
                "Test",
                LocalDate.parse("2022-01-01"),
                true);

        printPersonFullName.accept(person);
        getSummary.accept(person);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Test1", "Test1",LocalDate.parse("2000-01-01"), false ));
        personList.add(new Person(2, "Test2", "Test2",LocalDate.parse("2001-01-01"), false ));
        personList.add(new Person(3, "Test3", "Test3",LocalDate.parse("2002-01-01"), false ));
        personList.add(new Person(4, "Test4", "Test4",LocalDate.parse("2003-01-01"), false ));


        personList.forEach(printPersonFullName);      // same line
        //System.out.println(p.getFirstname()+" "+p.getLastname());

        System.out.println("-------------------");
        personList.forEach((p) -> { //{} -> multiline statement
            if(p.getId()==3) p.setActive(true);
        });


        personList.forEach(getSummary);


    }
}
