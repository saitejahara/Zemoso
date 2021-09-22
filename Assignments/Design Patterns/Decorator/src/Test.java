public class Test {
    public static void main(String[] args) {

        Car electricCar = new ElectricCar();
        Car petrolCar = new PetrolCar();

        System.out.println("Cars with base trim");
        electricCar.desc();
        petrolCar.desc();

        Car gtElectric = new GTLineCarDecorator(new ElectricCar());
        Car gtPetrol = new GTLineCarDecorator(new PetrolCar());

        System.out.println("\nElectric car in a GT trim");
        gtElectric.desc();

        System.out.println("\nPetrol car in a GT trim");
        gtPetrol.desc();
    }
}