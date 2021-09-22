public class FactoryPatternDemo {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        //get an object of Circle and call its draw method.
        Car car1 = carFactory.getCar("mahindra");

        //call draw method of Circle
        car1.desc();

        //get an object of Rectangle and call its draw method.
        Car car2 = carFactory.getCar("TESLA");

        //call draw method of Rectangle
        car2.desc();

        //get an object of Square and call its draw method.
        Car car3 = carFactory.getCar("mAseraTi");

        //call draw method of square
        car3.desc();
    }
}