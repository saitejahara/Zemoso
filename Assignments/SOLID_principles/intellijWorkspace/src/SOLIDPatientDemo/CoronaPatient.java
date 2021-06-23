package SOLIDPatientDemo;

public class CoronaPatient extends Person implements IPatient, IExtraCharges, IGenerateBill, ISetDiseaseName{

    private String diseaseName;
    private int totalExpenses;
    private int bill;


    @Override
    public String getDescription() {
        return "Patient tested positive for COVID-19";
    }

    @Override
    public void setDiseaseName(String diseaseName) {
        this.diseaseName=diseaseName;
    }

    @Override
    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses=totalExpenses;
    }

    @Override
    public int getBill() {
        bill=totalExpenses+1500;
        return bill;
    }

    @Override
    public void extraCharges(String extras) {
        System.out.println("Extra charges applied for "+extras);
    }

    public String getDiseaseName(){
        return diseaseName;
    }
}
