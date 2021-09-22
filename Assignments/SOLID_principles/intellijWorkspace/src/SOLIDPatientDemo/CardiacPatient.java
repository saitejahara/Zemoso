package SOLIDPatientDemo;

public class CardiacPatient  extends Person implements IPatient, IGenerateBill, ISetDiseaseName, IExtraCharges{

    private String diseaseName;
    private int totalExpenses;
    private int bill;


    @Override
    public void setDiseaseName(String diseaseName) {
        this.diseaseName=diseaseName;
    }

    @Override
    public String getDescription() {
        return "Patient has a history of Cardiac disease";
    }

    @Override
    public int getBill() {
        bill=totalExpenses+300;
        return bill;
    }

    @Override
    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses=totalExpenses;
    }

    @Override
    public void extraCharges(String extras) {
        System.out.println("Extra charges applied for "+extras);
    }

    @Override
    public String getDiseaseName(){
        return diseaseName;
    }
}
