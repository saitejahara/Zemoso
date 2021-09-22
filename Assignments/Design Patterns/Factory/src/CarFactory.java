public class CarFactory {

    //use getShape method to get object of type shape
    public Car getCar(String carCompany){
        if(carCompany == null){
            return null;
        }
        if(carCompany.equalsIgnoreCase("mahindra")){
            return new Mahindra();

        } else if(carCompany.equalsIgnoreCase("tesla")){
            return new Tesla();

        } else if(carCompany.equalsIgnoreCase("maserati")){
            return new Maserati();
        }

        return null;
    }
}