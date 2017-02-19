package Duke.sp01.c2.w4;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/** * Created by a on 24.01.17.  */
public class duke1_c2_w4_v2_T0_babyNames01 {
    public static void main(String[] args) {
//        babyNames01();
        testTotalBirths();
    }
    public static void babyNames01() {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/example-small.csv");
        for (CSVRecord rec : fr.getCSVParser(false)) {

            String numStrBorn = rec.get(2);
            System.out.println(numStrBorn);

//            int numBorn = Integer.parseInt(rec.get(2));
//            System.out.println(numBorn);
        }
    }
    public static void testTotalBirths() {
//        FileResource fr = new FileResource("us_babynames/us_babynames_test/example-small.csv");
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob2012short.csv");
        totalBirths(fr);
    }
    public static void totalBirths(FileResource fr) {
        CSVParser parser = fr.getCSVParser(false);
        int numNames = 0;
        int numPerson = 0;
        int numMale = 0;
        int numFemale = 0;
        for (CSVRecord rec : parser) {
//            String nubStrBorn = rec.get(2);
//            int numBorn = Integer.parseInt(nubStrBorn);
            String name = rec.get(0);
            String sex = rec.get(1);
            int numBorn = Integer.parseInt(rec.get(2));
            numNames ++;
            numPerson += numBorn;
            if (sex.equals("M")) {
                numMale += numBorn;
            } else {
                numFemale += numBorn;
            }
//            System.out.println(name + " " + " " + sex +" "+numBorn);
        }
        System.out.println("numPerson = " + numPerson);
        System.out.println("numMale = " + numMale);
        System.out.println("numFemale = " + numFemale);
    }
}
