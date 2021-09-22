package Assignment7;

public class CycleInheritance {

    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[3];
        cycles[0] = new Unicycle();
        cycles[1] = new Bicycle();
        cycles[2] = new Tricycle();

        //Unicycle unicycle = (Unicycle) cycles[0];
        ((Unicycle) cycles[0]).balance();
        ((Bicycle) cycles[1]).balance();
        //((Tricycle) cycles[2]).balance();   this line will throw an error because there's now 'balance' method in tricycle

    }
}

class Cycle {

}

class Unicycle extends Cycle {
    public void balance() {
        System.out.println("Unicycle balance");
    }
}

class Bicycle extends Cycle {
    public void balance() {
        System.out.println("Bicycle balance");
    }
}

class Tricycle extends Cycle {

}