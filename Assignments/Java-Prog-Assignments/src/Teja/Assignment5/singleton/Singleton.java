package Teja.Assignment5.singleton;

public class Singleton {
    String testString;
    public Singleton(String str) {
        this.testString = str;
    }
    public static Singleton initializer(String inputString) {
        //testString = inputString;
        System.out.println("Compilation error encountered above this line");

        Singleton singleton= new Singleton(inputString);
        return singleton;
    }

    public void printMember() {
        System.out.println(testString);
    }
}