package Duke.sp01.c2.w3;
import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Created by i on 1/21/17.
 */
public class duke1_c2_w3_PE_t1_CountriesExportPE {
    public static void main(String[] args) {
        tester();
    }

    public static void tester() {
        FileResource fr = new FileResource("./src/Duke.sp01.c2.w3/exports/exportdata.csv");

        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println("Number of exporters of the item: " + numberOfExporters(parser, "sugar"));

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }

    public static String countryInfo(CSVParser parser, String countryName) {
        for (CSVRecord record : parser) {
            String colCountry = record.get("Country");
            if (colCountry.contains(countryName)) {
                String countryInformation = countryName + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
                return countryInformation;
            }
        }
            return "NOT FOUND";
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String colCountry = record.get("Exports");
            if (colCountry.contains(exportItem1) && colCountry.contains(exportItem2)) {
                System.out.println("Countries that have both of the products: " + record.get("Country"));
            }
        }
    }

    public static int numberOfExporters(CSVParser parser, String exportItem){
      int numberOfCountries = 0;
        for (CSVRecord record : parser) {
            String colCountry = record.get("Exports");
            if (colCountry.contains(exportItem)) {
                numberOfCountries++;
            }
        }
        return numberOfCountries;
    }

    public static void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser) {
            String colCountry = record.get("Value (dollars)");
            if (colCountry.length() > amount.length()) {
                System.out.println("Countries that have bigger income that indicated : " + record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }
}



