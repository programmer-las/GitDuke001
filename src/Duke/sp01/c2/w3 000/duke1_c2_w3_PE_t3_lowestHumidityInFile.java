package Duke.sp01.c2.w3;
import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
/** * Created by a on 22.01.17. */
public class duke1_c2_w3_PE_t3_lowestHumidityInFile {
    public static void main(String[] args) {
//        testColdestHourInFile();
//        testFileWithColdestTemperature();
        testLowestHumidityInFile();
    }
    public static void testColdestHourInFile() {
        FileResource fr = new FileResource("./src/Duke.sp01.c2.w3/nc_weather/2015/weather-2015-01-01.csv");
//        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        coldestHourInFile(parser);
    }
    public static CSVRecord coldestHourInFile(CSVParser parser) {
//    public static CSVRecord coldestHourInFile(CSVParser parser) {
    CSVRecord lowerSoFar = null;
        for (CSVRecord record : parser) {
            if (lowerSoFar == null){
                lowerSoFar = record;
//                System.out.println("lowerSoFar == null");
//                System.out.println("    >>\t min temperature - " + Double.parseDouble(record.get("TemperatureF")));
            } else {
                if (Double.parseDouble(record.get("TemperatureF")) != -9999) {
                    lowerSoFar = getLowerSoFar(record, lowerSoFar);
                } else {
                    System.out.println("record.get(\"TemperatureF\")) = -9999");
                }
            }
        }
        System.out.println("Lowest temperature (" + lowerSoFar.get("TemperatureF") +"F) was recorded at " + lowerSoFar.get("TimeEST") + " on " + lowerSoFar.get("DateUTC"));
        return lowerSoFar;
    }
    public static CSVRecord getLowerSoFar (CSVRecord currentRow, CSVRecord lowerSoFar) {
//            String colTimeEST = record.get("TimeEST");
//        String colTemperatureF = currentRow.get("TemperatureF");
//            double valTemperatureF = (double) toDouble.record.get("TemperatureF");
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        double lowerTemp = Double.parseDouble(lowerSoFar.get("TemperatureF"));

        if ((currentTemp < lowerTemp) && (currentTemp != -9999)) {
            lowerSoFar = currentRow;
//            System.out.println("    >>>> update min temperature - " + Double.parseDouble(lowerSoFar.get("TemperatureF")));
        }
        return lowerSoFar;
    }
    public static void testFileWithColdestTemperature() {
        String fileNameWithColdestTemperature = fileWithColdestTemperature();
        FileResource fr = new FileResource(fileNameWithColdestTemperature);
        CSVParser parser = fr.getCSVParser();

        System.out.println("\nColdest day was in file " + fileNameWithColdestTemperature);
//        CSVRecord t = coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was " + coldestHourInFile(parser).get("TemperatureF"));    //lowerTemperatureInFile);
        System.out.println("All the Temperatures on the coldest day were: ");
        parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            System.out.println(record.get("DateUTC") + " = " + record.get("TimeEST") + " = " + record.get("TemperatureF"));
        }
    }
    public static String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowerSoFarRecord = null;
        double lowerTemperatureInFile = 999.0;
        String returnFileName = "";
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentRecord = coldestHourInFile(parser);
            double lowerTemperatureInCurrentFile = Double.parseDouble(currentRecord.get("TemperatureF"));
            if (lowerTemperatureInFile > lowerTemperatureInCurrentFile) {
                lowerTemperatureInFile = lowerTemperatureInCurrentFile;
//                lowerSoFarRecord = currentRecord;
//                lowerTemperatureFile = f;
//                lowerTemperatureFileName = f.getName();
                returnFileName = String.valueOf(f);
            }
        }
        return returnFileName;
    }
    public static void testLowestHumidityInFile(){
//        FileResource fr = new FileResource();
        FileResource fr = new FileResource("./src/Duke.sp01.c2.w3/nc_weather/2014/weather-2014-01-20.csv");
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);

        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
    public static CSVRecord lowestHumidityInFile(CSVParser parser){
//        CSVRecord recordLowestHumidityInFile = null;
        CSVRecord oldRec = null;
        int lowestHumidity = 100;
        for (CSVRecord csvCurrent : parser ) {
            if (csvCurrent.get("Humidity") != "N/A") {
                if (oldRec == null) {
                    oldRec = csvCurrent;
                } else {
                    oldRec = minTwoRecords(csvCurrent, oldRec, "Humidity");
                }
            }
        }
        return oldRec;
    }
    public static CSVRecord minTwoRecords(CSVRecord currentRec, CSVRecord oldRec, String parametr){
        CSVRecord minRecord;
        int csvCurrentParam = Integer.parseInt(currentRec.get(parametr));
        int csvOldParam = Integer.parseInt(oldRec.get(parametr));
//        System.out.println("Value of parametr " + currentRec.get(parametr));
        if (csvCurrentParam < csvOldParam) {
            minRecord = currentRec;
        } else {
            minRecord = oldRec;
        }
        return minRecord;
    }
}