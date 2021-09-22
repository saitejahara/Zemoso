public class OnStart {

    private static OnStart obj;

    private OnStart() {}

    public static OnStart getInstance()
    {
        if (obj==null)

            //initializing the declared instance
            obj = new OnStart();
        System.out.println("An instance of "+ new Object(){}.getClass() +" has be initialised");
        return obj;
    }
}