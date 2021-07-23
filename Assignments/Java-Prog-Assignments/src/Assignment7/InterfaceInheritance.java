package Assignment7;


interface Interface1 {
    public void runInterface1();
    public void describeInterface1();
}

interface Interface2 {
    public void runInterface2();
    public void describeInterface2();
}

interface Interface3 {
    public void runInterface3();
    public void describeInterface3();
}

interface Interface4 extends Interface1,Interface2,Interface3{
    public void describeInterface4();
}


class Solution extends ConcreteClass implements Interface4 {
    public Solution(){
        System.out.println("Caller class constructor");

    }

    public void runInterface1() {
        System.out.println("runInterface of 1");
    }

    public void describeInterface1() {
        System.out.println("describeInterface of 1");
    }

    public void runInterface2() {
        System.out.println("runInterface of 2");
    }

    public void describeInterface2() {
        System.out.println("describeInterface of 2");
    }

    public void runInterface3() {
        System.out.println("runInterface of 3");
    }

    public void describeInterface3() {
        System.out.println("describeInterface of 3");
    }

    public void describeInterface4() {
        System.out.println("describeInterface of 4");
    }
    /////////////////////////////////////////////////////////
    public void method1(Interface1 interface1) {
        System.out.println("Method1 calls instance of Interface1");
    }

    public void method2(Interface2 interface2) {
        System.out.println("Method2 calls instance of Interface2");
    }

    public void method3(Interface3 interface3) {
        System.out.println("Method3 calls instance of Interface3");
    }

    public void method4(Interface4 interface4) {
        System.out.println("Method4 calls instance of  Interface4");
    }
}


class ConcreteClass{
    ConcreteClass(){
        System.out.println("Concrete constructor");
    }

    public static void display() {
        System.out.println("Concrete display method");
    }
}


public class InterfaceInheritance {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.method1(solution);
        solution.method2(solution);
        solution.method3(solution);
        solution.method4(solution);
    }
}