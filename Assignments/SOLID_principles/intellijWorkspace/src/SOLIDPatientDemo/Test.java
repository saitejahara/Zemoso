package SOLIDPatientDemo;

import java.util.ArrayList;

public class Test {
    //single responsibility principle
    public static void patientDetails(String diseaseName, int bill, String description){
        System.out.println(description);
        System.out.println("The patient with "+diseaseName+" will be charged "+bill+" considering all the extra charges.\n\n");
        //violation of single responsibility principle
        //bill=totalExpenses=1500;
    }

    public static void main(String[] args) {

        //Dependency Inversion Principle
        IPatient patient1=new CoronaPatient();
        patient1.setTotalExpenses(500);
        patient1.setDiseaseName("Black Fungus");
        patient1.extraCharges("PPE Kit");
        patientDetails(patient1.getDiseaseName(), patient1.getBill(), patient1.getDescription());



        //Liskov Substitution Principle
        Person person1=new Person();
        person1.setPersonName("John");
        person1.setPhoneNumber("+1 480243151");
        System.out.println(person1.getPersonName()+"   "+person1.getPhoneNumber());

        person1=new Visitor();
        person1.setPersonName("Sean");
        person1.setPhoneNumber("+1 202122365");
        System.out.println(person1.getPersonName()+"   "+person1.getPhoneNumber());
    }
}
