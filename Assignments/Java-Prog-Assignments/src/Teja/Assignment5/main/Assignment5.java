package Teja.Assignment5.main;

import Teja.Assignment5.data.UnInitializedVars;
import Teja.Assignment5.singleton.Singleton;

public class Assignment5 {
    public static void main(String[] args) {
        UnInitializedVars unInitializedVars = new UnInitializedVars();
        unInitializedVars.printInstanceVariables();
        unInitializedVars.printLocalVariables();

        //Singleton singleton = new Singleton();
        //singleton.printMember();

        Singleton singleton = Singleton.initializer("Print test");
        singleton.printMember();

    }
}
