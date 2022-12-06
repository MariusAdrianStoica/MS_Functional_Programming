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

        Integer number1 = 100;
        boolean result = isPositive.test(number1); //true


        System.out.println(result);
        System.out.println(isGreaterThanTen.test(5)); //false


        Predicate<Person> isLeapYear = (person) -> person.getBirthdate().isLeapYear();

        Person person = new Person(
                1,
                "Test",
                "Test",
                LocalDate.parse("2020-01-01"),
                true);



    }
}
