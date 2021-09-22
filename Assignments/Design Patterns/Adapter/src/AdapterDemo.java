public class AdapterDemo
{
    public static void main(String args[])
    {
        Mazda mazda = new Mazda();
        ToyCar toyCar = new PlasticToyCar();

        // Wrap a car in a carAdapter so that it
        // behaves like toy duck
        ToyCar carAdapter = new CarAdapter(mazda);

        System.out.println("Mazda...");
        mazda.drive();
        mazda.makeSound();

        System.out.println("ToyCar...");
        toyCar.starts();

        // toy duck behaving like a car
        System.out.println("CarAdapter...");
        carAdapter.starts();
    }
}