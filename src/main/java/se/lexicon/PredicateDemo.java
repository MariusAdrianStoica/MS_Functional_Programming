package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        //Predicate - functional interface
        //takes any object as argument and returns a boolean -> filtering Collections and Streams
        Predicate<Integer> isPositive =(number)->{
            if (number>0) {
                return true;
            }else{
                return false;
            }
        };

        Predicate<Integer> isGreaterThanTen = (number)->{
          if (number>10) return true;
          return false;
        };

        Predicate<Integer> isLessThan20 = (number)->number<20;
        //Predicate returns boolean

        Integer number1 = 100;
        boolean result = isPositive.test(number1); //true


        System.out.println(result);
        System.out.println(isGreaterThanTen.test(5)); //false


        Predicate<Person> isLeapYear = (person) -> person.getBirthdate().isLeapYear();

        Person person = new Person(
                1,
                "Test",
                "Test",
                LocalDate.parse("2022-01-01"),
                true);


        System.out.println("-------------------------");
        System.out.println(isLeapYear.test(person));

        System.out.println(isGreaterThanTen.and(isLessThan20).test(5)); //true
        //.and / .or -> to combine 2 logics

    }
}
