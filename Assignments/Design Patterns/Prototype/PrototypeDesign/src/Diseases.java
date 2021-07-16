import java.util.ArrayList;
import java.util.List;

public class Diseases implements Cloneable {
    private List<String> diseaseList;

    public Diseases() {
        this.diseaseList = new ArrayList<String>();
    }

    public Diseases(List<String> list) {
        this.diseaseList = list;
    }

    public void addNewDiseases() {
        diseaseList.add("Cold");
        diseaseList.add("Cough");
        diseaseList.add("Fever");
        diseaseList.add("Nausea");
        diseaseList.add("Headache");
    }

    public List<String> getDiseaseList() {
        return this.diseaseList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getDiseaseList()) {
            tempList.add(s);
        }
        return new Diseases(tempList);
    }
}