package SOLIDPatientDemo;

interface IGenerateBill {
    //single responsibility implementation
    public void setTotalExpenses(int totalExpenses);
    public int getBill();
}