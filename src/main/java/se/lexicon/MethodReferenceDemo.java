package se.lexicon;

import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.function.ToDoubleBiFunction;

public class MethodReferenceDemo {

    public static int getRandomNumber(int max){
        Random random = new Random();
        return random.nextInt(max); // random generated number from 0 to max

    };
    public static void main(String[] args) {

        IntUnaryOperator randomNumberLambda = (num)->getRandomNumber(num);
        System.out.println(randomNumberLambda.applyAsInt(1000));

        IntUnaryOperator randomNumberMR = MethodReferenceDemo::getRandomNumber;
        //class name + static method name

        System.out.println(randomNumberMR.applyAsInt(1000));


        Calculator calculator= new Calculator(); //instantiate
        ToDoubleBiFunction<Double, Double> additionLambda =(n1, n2) ->calculator.addition(n1, n2);
        ToDoubleBiFunction<Double, Double> additionMR =calculator::addition;

        System.out.println("----------------------");
        System.out.println(additionLambda.applyAsDouble(10.0,20.0));
        System.out.println(additionMR.applyAsDouble(10.0,20.0));

        System.out.println(additionMR.applyAsDouble(15d,25d));
        //(d) -> 15d == 15.0






    }
}
