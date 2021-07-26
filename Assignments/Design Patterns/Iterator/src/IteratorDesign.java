public class IteratorDesign {
    public static void main(String[] args) {
        Cars cars = new Cars();

        //the increment for the iteration is done in the implementation of next() inside Cars.java
        for(IIterator iterator = cars.getIterator(); iterator.hasNext();  ){

            //returns an object by default
            String tempString = (String)iterator.next();
            System.out.println("Car : " + tempString);
        }
    }
}
