package se.lexicon;

import se.lexicon.interfaces.*;

import java.util.Random;

public class LambdaDemo {

    public static String doStringStuff(String v1, String v2, DoStringStuff operator){

        return operator.operate(v1, v2);
    };

    public static Integer calcOperator (Integer n1, Integer n2, IntegerOperator operator){
        return operator.apply(n1, n2);
    };
    public static Double DoubleCalcOperator (Double n1, Double n2, DoubleOperator operator){
        return operator.apply(n1, n2);
    };

    static DoStringStuff concat = (str1, str2) -> str1.concat(str2); // if you want {} -> you must write "return"
    //defined as a static field
    static DoStringStuff concatLambda = (str1, str2) -> str1.concat(str2);
    static DoStringStuff getBiggestValue = (str1, str2) -> str1.length()>= str2.length() ? str1 : str2;
    static IntegerOperator addition = (num1, num2) -> num1+num2;
    static IntegerOperator subtraction = (num1, num2) -> num1-num2;
    static IntegerOperator multiplication = (num1, num2) -> num1*num2;
    static IntegerOperator divide = (num1, num2) -> num1/num2;
        // fields become a global variable
    static DoubleOperator divideDouble = (num1, num2) -> num1/num2;
    static Printer displayMessage = msg -> System.out.println(msg); // if you have 1 param (msg), you can remove ()

    static int upper=10;
    static Conditional rng = () -> new Random().nextInt(upper+1); //any number between 0-10




    public static void main(String[] args) {

        /*DoStringStuff concat = (str1, str2) -> { // defined as  a static field to be accessed from everywhere
            return str1.concat(str2); // if you want {} -> you must write "return"
        };
        DoStringStuff concatLambda = (str1, str2) -> str1.concat(str2); //single line statement
        // without {} -> we don't need to write "return"

        DoStringStuff getBiggestValue = (str1, str2) -> {
            //if (str1.length()>=str2.length()) return str1;
            //else return str2;

            return str1.length()>= str2.length() ? str1 : str2; //ternary operator
            // ? -> then
            // : -> else */
            /** http://tutorials.jenkov.com/java/ternary-operator.html

        };*/


        // Integer apply(Integer n1, Integer n2); //interface method
        /*IntegerOperator addition = (num1, num2) ->              num1+num2;
                                // param        arrowToken      method body

        //if we want {}, we need to write "return"
        IntegerOperator addition2 = (num1, num2) ->{
           return num1+num2;
        }; */
        //variables type is defined in interface
        //it is not important the name of variables (defined n1, n2 -> used num1, num2)
        //it is very important the type instead

        System.out.println(doStringStuff("ABC", "DEFG", concat));
        System.out.println(doStringStuff("ABC", "DEFG", concatLambda));
        System.out.println(doStringStuff("ABC", "DEFG", getBiggestValue));
        System.out.println("_________________________________");


        /*IntegerOperator subtraction = (num1, num2) -> num1-num2;
        IntegerOperator multiplication = (num1, num2) -> num1*num2;
        IntegerOperator divide = (num1, num2) -> num1/num2;*/

        System.out.println(calcOperator(5, 10, addition));
        System.out.println(calcOperator(5, 10, subtraction));
        System.out.println(calcOperator(5, 10, multiplication));
        System.out.println("_________________________________");
        System.out.println(calcOperator(11, 5, divide));

        System.out.println(DoubleCalcOperator(11.0, 5.0, divideDouble));
        System.out.println("_________________________________");


        displayMessage.print("Hello Lambda!");
        System.out.println("_________________________________");

        System.out.println(rng.generate());






    }
}
