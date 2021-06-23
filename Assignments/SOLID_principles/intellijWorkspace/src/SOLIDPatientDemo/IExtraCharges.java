package SOLIDPatientDemo;

public interface IExtraCharges {
    //single responsibility implementation
    public void extraCharges(String extras);

    /*violating single responsibility and interface segregation
     * public void getBill(int totolExpenses);
     * public void setDiseaseName(String diseaseName);
     *
     * */
}
