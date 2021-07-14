import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyName {
    public void totalBirths (FileResource fr) {
        int totalNames = 0;
        int totalBoyNames = 0;
        int totalGirlNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals("M")) {
                totalBoyNames += 1;
            }
            else {
                totalGirlNames += 1;
            }
            totalNames += 1;
        }
        System.out.println("total names = " + totalNames);
        System.out.println("female girls = " + totalGirlNames);
        System.out.println("male boys = " + totalBoyNames);
    }
    public int getRank(int year,String name, String gender){
        FileResource fr = new FileResource("testing/yob"+year+"short.csv");
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                rank += 1;
                if (record.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }
    public String getName(int year, int rank, String gender){
        String name = "NO NAME";
        FileResource fr = new FileResource("testing/yob"+year+"short.csv");
        CSVParser parser = fr.getCSVParser(false);
        int currentRank = 0;
        for(CSVRecord record : parser){
            if(record.get(1).equals(gender)) {
                currentRank++;
                if (currentRank == rank) {
                    name = record.get(0);
                    return name;
                }
            }
        }
        return name;
    }
    public void whatIsNameInYear(String name, int year,int newYear, String gender){
        String pronoun = gender.equals("F")?"she":"he";
        int rank = getRank(year, name, gender);
        System.out.println(name+" born in "+year+" would be "+getName(newYear, rank, gender) +" if "+pronoun+" was born in "+newYear);
    }

    public int yearOfHighestRank(String name, String gender){
        double inf = Double.POSITIVE_INFINITY;
        int highestRank = (int) inf;
        int highestYear = -1;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            String year = f.getName().substring(3, 7);
            int rank = getRank(Integer.parseInt(year), name, gender);
            if (rank != -1 &&  rank <= highestRank){
                highestRank = rank;
                highestYear = Integer.parseInt(year);
            }
        }
        return highestYear;
    }
    public double getAverageRank(String name, String gender){
        double inf = Double.POSITIVE_INFINITY,count=0.0;
        int averageRank = -1;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            String year = f.getName().substring(3, 7);
            int rank = getRank(Integer.parseInt(year), name, gender);
            count++;
            if (rank != -1 ){
                averageRank += rank;
            }
            else return -1;
        }
        return averageRank/count;
    }
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        FileResource fr = new FileResource("testing/yob"+year+"short.csv");
        CSVParser parser = fr.getCSVParser(false);
        int birthsHigher=0;
        for(CSVRecord record : parser){
            if(record.get(1).equals(gender)){
                if(record.get(0).equals(name))break;
                else birthsHigher+=Integer.parseInt(record.get(2));
            }
        }
        return birthsHigher;
    }
    public static void main(String[] args){
        BabyName babyNames = new BabyName();
        System.out.println(babyNames.getRank(2014, "Emma", "F"));
        babyNames.whatIsNameInYear("Isabella", 2012, 2014, "F");
        //System.out.println(babyBirths.yearOfHighestRank("Olivia","F"));
        //System.out.println(babyBirths.getAverageRank("Isabella","F"));
        System.out.println(babyNames.getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }
}