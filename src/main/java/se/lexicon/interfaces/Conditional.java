package se.lexicon.interfaces;

@FunctionalInterface
public interface Conditional { //IntRandomGen(erator)

    // if the interface has no param you must write ()- otherwise you get error

    //if we have multi lines, we have to use {}
    int generate();

}
