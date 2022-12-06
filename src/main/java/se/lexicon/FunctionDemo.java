package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {

        //Function(T,R) -> accepts one argument (T) and produces a result (R)
        //used for mapping one type to another in a Stream
        //abstract Method R apply(T t);

        String[] words={"I", "Love","Java" };
        Function<String[], String> arrayToString =(arrayParam)->{
            String sentence="";
            for (String word:words){
                //sentence=sentence+word;
                sentence+=word;

            }
            return sentence;
        };

        System.out.println(arrayToString.apply(words));

        Function< Person, String> extractPersonName= (person)-> person.getFirstname()+" "+person.getLastname();
        //convert object Person to a string value

        Function< Person, String> extractPersonName2= person-> person.getFirstname()+" "+person.getLastname();
        //single param - we don't need to write ()

        Person person = new Person(1, "test", "test", LocalDate.parse("2020-01-01"),true);
        System.out.println("--------------------------");
        System.out.println(extractPersonName.apply(person));
        System.out.println("--------------------------");
        System.out.println(extractPersonName2.apply(person));


        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Test1", "Test1",LocalDate.parse("2000-01-01"), false ));
        personList.add(new Person(2, "Test2", "Test2",LocalDate.parse("2001-01-01"), false ));
        personList.add(new Person(3, "Test3", "Test3",LocalDate.parse("2002-01-01"), false ));
        personList.add(new Person(4, "Test4", "Test4",LocalDate.parse("2003-01-01"), false ));

        List<String> names= new ArrayList<>();
        for(Person currentElement: personList){ //iterate on the array
            String fullName= extractPersonName.apply(currentElement); //get the fullName
            //Function extractPerson name -> converts the Person into a string - fullName
            names.add(fullName); //add the fullName into the list
        }

        System.out.println("--------------------------");

        names.forEach(name -> System.out.println(name));
    }
}
