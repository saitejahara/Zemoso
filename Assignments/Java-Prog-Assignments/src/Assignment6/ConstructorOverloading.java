package Assignment6;

public class ConstructorOverloading {
    ConstructorOverloading(String name) {
        this(2021);
        System.out.println("string arg constructor");
        System.out.println("Hello " +name);
    }
    ConstructorOverloading(int year) {
        System.out.println("int arg constructor");
        System.out.println("The year of joining is " + year);
    }
    public static void main(String[] args) {
        new ConstructorOverloading("Hello");
    }
}