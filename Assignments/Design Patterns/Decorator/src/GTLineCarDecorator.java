
public class GTLineCarDecorator extends CarDecorator {

    public GTLineCarDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    private void setRedBorder(Car decoratedCar){
        System.out.println("Trim: Grand Turismo");
    }

    @Override
    public void desc() {
        decoratedCar.desc();
        setRedBorder(decoratedCar);
    }
}
