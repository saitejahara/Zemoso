public class Main {
    public static void main(String[] args) {
        OnStart onStart1 = OnStart.getInstance();
        OnStart onStart2 = OnStart.getInstance();

        //since we declared an instance of 'OnStart' in the 'OnStart' class itself,
        // in theory, that both are pointing to the same memory location

        //confirming the above statement stands true
        if(onStart1==onStart2){
            System.out.println("Yeah, pretty much the same");
        }
    }
}
