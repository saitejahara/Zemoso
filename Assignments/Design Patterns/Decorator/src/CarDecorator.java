public abstract class CarDecorator implements Car {
    public Car decoratedCar;

    public CarDecorator(Car decoratedCar){
        this.decoratedCar = decoratedCar;
    }

    public void draw(){
        decoratedCar.desc();
    }
}