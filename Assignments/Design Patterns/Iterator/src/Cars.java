public class Cars implements IContainer {

    //Let's consider that the below data is fetched from the database on which the code is residing
    //Hence, the given class Cars is considered a container

    public String carNames[] = {"Lexus LS" , "Mercedes AMG G63" ,"BMW M5 F90" , "Lamborghini Huracan"};

    @Override
    public IIterator getIterator() {
        return new NameIterator();
    }

    //iterator implementation
    private class NameIterator implements IIterator {

        int index;

        @Override
        public boolean hasNext() {

            if(index < carNames.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return carNames[index++];
            }
            return null;
        }
    }
}