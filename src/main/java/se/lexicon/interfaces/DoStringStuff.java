package se.lexicon.interfaces;

@FunctionalInterface
public interface DoStringStuff {

    String operate(String s1, String s2);
    //String operate2(String s1, String s2);
    // a method (without public static void*) that operate for string s1 & s2
    //for @FunctionalInterface -> only ONE abstract method

    //...static & default methods
}
