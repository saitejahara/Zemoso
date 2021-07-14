import edu.duke.*;
import org.apache.commons.csv.*;
public class ExportInfo {
    public void countryInfo(CSVParser parser, String country){
        boolean found = false;
        for(CSVRecord record : parser){
            String getCountry = record.get("Country");
            if(getCountry.contains(country)){
                System.out.println(getCountry + ": "
                        +record.get("Exports")+": "+record.get("Value (dollars)"));
                found = true;
            }
        }
        if(!found) System.out.println("NOT FOUND");
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    public int noOfExporters(CSVParser parser, String exportItem){
        int noOfCountries=0;
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem))noOfCountries++;
        }
        return noOfCountries;
    }
    public void bigExporters(CSVParser parser, String dollarValue){
        for(CSVRecord record : parser){
            String getDollars = record.get("Value (dollars)");
            if(getDollars.length() > dollarValue.length()){
                System.out.println(record.get("Country")+" "+getDollars);
            }
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser,"Germany");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        System.out.println(noOfExporters(parser, "gold"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$400,000,000");
    }
    public static void main(String[] args){
        ExportInfo exportInfo = new ExportInfo();
        exportInfo.tester();
    }
}