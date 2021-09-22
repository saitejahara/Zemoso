package Teja.Assignment5.data;

public class UnInitializedVars
{
    private int IntInstanceVar;
    private char charInstanceVar;

    public void printInstanceVariables() {
        System.out.println("Int instance variable : " + IntInstanceVar+"\nChar instance variable : "+charInstanceVar);
    }

    public void printLocalVariables() {
        int intLocalVar;
        char charLocalVar;

        //System.out.println("Int local variable : " + intLocalVar + "\nChar local variable : " + charLocalVar);
        System.out.println("Compilation error encountered above this line");
    }
}