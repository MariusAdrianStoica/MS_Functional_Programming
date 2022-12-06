package se.lexicon;

import se.lexicon.interfaces.DoStringStuff;
import se.lexicon.interfaces.IntegerOperator;

public class LegacyCode {

    //rename App to LegacyCode

    public static void main( String[] args )
    {
        ex3();
    }

    //Anonymous Inner Class - a class that don't have a name
    public static void ex1(){
        DoStringStuff concatOperator = new DoStringStuff() {
            // we can not instantiate an interface, so we override method inside the interface
            @Override
            public String operate(String s1, String s2) {
                return s1.concat(s2);
            }
        };
        IntegerOperator addition = new IntegerOperator() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 +n2;
            }
        };

    }
    // Moving Anonymous Inner Class to fields
    static DoStringStuff concatOperator = new DoStringStuff() { // method as static field
        @Override
        public String operate(String s1, String s2) {
            return s1.concat(s2);
        }
    };
    static DoStringStuff getBiggestString = new DoStringStuff() { // method as static field
        @Override
        public String operate(String s1, String s2) {
            if (s1.length()>=s2.length()) return s1;
            else return s2;
            }
    };
    static IntegerOperator addition = new IntegerOperator() { //method as static field
        @Override
        public Integer apply(Integer n1, Integer n2) {
            return n1 +n2;
        }
    };

    static IntegerOperator subtraction = new IntegerOperator() { //method as static field
        @Override
        public Integer apply(Integer n1, Integer n2) {
            return n1 - n2;
        }
    };
    public static void ex2(){
        System.out.println(concatOperator.operate("ABC", "DEF"));

        System.out.println(addition.apply(10,2));
    }

    public static String doStringStuff(String s1, String s2, DoStringStuff operator){
        //takes the method behavior (operator) as a param
        return operator.operate(s1, s2);
    };

    public static Integer calcOperator(Integer n1, Integer n2, IntegerOperator operator){
    return operator.apply(n1, n2);
    };
    public static void ex3(){
        System.out.println(doStringStuff("ABC", "DEF", concatOperator ));
        //concatOperator defined as a field
        System.out.println(doStringStuff("ABC", "DEFG", getBiggestString ));

        System.out.println(calcOperator(10,5,addition));
        System.out.println(calcOperator(10,5,subtraction));

    }
}
