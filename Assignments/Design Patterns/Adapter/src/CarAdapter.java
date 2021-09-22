class CarAdapter implements ToyCar
{
    // You need to implement the interface your
    // client expects to use.
    Car car;
    public CarAdapter(Car car)
    {
        // we need reference to the object we
        // are adapting
        this.car = car;
    }

    public void starts()
    {
        // translate the methods appropriately
        car.makeSound();
    }
}