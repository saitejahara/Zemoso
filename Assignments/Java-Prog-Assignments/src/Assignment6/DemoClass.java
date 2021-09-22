package Assignment6;

public class DemoClass {
    public DemoClass(String testString){
        System.out.print(testString);
    }

    public static void main(String[] args) {
        DemoClass[] demoClassA = new DemoClass[4];
        //prints nothing;

        demoClassA[0]=new DemoClass("Hi");
        demoClassA[1]=new DemoClass(", how");
        demoClassA[2]=new DemoClass(" are");
        demoClassA[3]=new DemoClass(" you?");
    }
}
