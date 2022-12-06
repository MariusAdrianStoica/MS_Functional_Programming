package se.lexicon;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        // Takes no param and returns a value(result) -> a supplier of results
        //Abstract method T get();

        Supplier<Double> randomValue = () -> Math.random();
        Supplier<String> randomUUID = () -> UUID.randomUUID().toString();

        System.out.println(randomValue.get());
        System.out.println("----------------");
        System.out.println(randomUUID.get());

        System.out.println(takeDecimalInput.get());
    }

    static Supplier<Double> takeDecimalInput =()->{
        double number;

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number:");

            //Try & catch (exceptions)
            try{  number = scanner.nextDouble();// try to get the number
                    break;            // if number it will stop
            } catch (InputMismatchException e){ //otherwise catch exception and
                System.out.println("Number was not valid!"); // inform that number aws not valid
            }
        }
        return number;
    };
}
