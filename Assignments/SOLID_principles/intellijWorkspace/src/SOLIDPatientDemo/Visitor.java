package SOLIDPatientDemo;

public class Visitor extends Person{
    private String assoPatientName;

    public void setPatientName(String patientName) {
        this.assoPatientName = assoPatientName;
    }

    public String getPatientName() {
        return assoPatientName;
    }
}
