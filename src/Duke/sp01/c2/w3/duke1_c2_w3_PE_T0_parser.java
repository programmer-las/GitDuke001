package Duke.sp01.c2.w3;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
public class duke1_c2_w3_PE_T0_parser {
    public static void main(String[] args) {
        tester();
    }
    public static void tester() {
        FileResource fr = new FileResource("./src/Duke.sp01.c2.w3/exports/exportdata.csv");

        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            String colCountry = record.get("Country");
            System.out.println(colCountry + "\t" + record.get("Value (dollars)"));
        }
    }
}