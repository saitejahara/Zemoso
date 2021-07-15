import java.util.List;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Diseases a = new Diseases();
        a.addNewDiseases();

        Diseases b = (Diseases) a.clone();
        List<String> list = b.getDiseaseList();
        list.add("COVID-19");

        System.out.println(a.getDiseaseList());
        System.out.println(list);

        b.getDiseaseList().remove("Cold");
        System.out.println(list);
        System.out.println(a.getDiseaseList());
    }

}