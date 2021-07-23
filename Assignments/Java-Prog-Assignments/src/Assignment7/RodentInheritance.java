package Assignment7;

public class RodentInheritance {
    public static void main(String[] args) {
        Rodent[] rodent = new Rodent[3];

        rodent[0] = new Mouse();
        rodent[1] = new Gerbil();
        rodent[2] = new Hamster();

        for (Rodent r : rodent){
            r.name();
            r.activity();
        }

    }
}
abstract class Rodent {
    Rodent() {
        System.out.println("Rodent class constructor");
    }

    public abstract void activity();

    public abstract void name();

}

class Mouse extends Rodent {
    Mouse() {
        System.out.println("Mouse class constructor");
    }

    public void activity() {
        System.out.println("Mouse is biting");
    }

    public void name() {
        System.out.println("My name is Jerry mouse");
    }
};

class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("Gerbil class constructor");
    }

    public void activity() {
        System.out.println("Gerbil is playing");
    }

    public void name() {
        System.out.println("My name is Wallis gerbil");
    }
}

class Hamster extends Rodent {
    Hamster() {
        System.out.println("Hamster class constructor");
    }

    public void activity() {
        System.out.println("Hamster is eating");
    }

    public void name() {
        System.out.println("Call me He-man hamster");
    }
}