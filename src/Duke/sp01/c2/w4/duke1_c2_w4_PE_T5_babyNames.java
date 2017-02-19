package Duke.sp01.c2.w4;
import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

/** * Created by a on 24.01.17.  */
public class duke1_c2_w4_PE_T5_babyNames {
//    public static String fileNameStart = "us_babynames/us_babynames_test/yob";
//    public static String fileNameEnd = "short.csv";
    public static String fileNameStart = "us_babynames/us_babynames_by_year/yob";
    public static String fileNameEnd = ".csv";
    public static void main(String[] args) {
//        babyNames01();
//        testTotalBirths();
//        testGetRank();
//        testGetName();
//        testWhatIsNameInYear();
        testYearOfHighestRank();
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
        int numNamesF = 0;
        int numNamesM = 0;
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
                numNamesM ++;
            } else {
                numFemale += numBorn;
                numNamesF ++;
            }
//            System.out.println(name + " " + " " + sex +" "+numBorn);
        }
        System.out.println("numPerson = " + numPerson);
        System.out.println("numMale = " + numMale);
        System.out.println("numFemale = " + numFemale);
        System.out.println("numNamesM = " + numNamesM);
        System.out.println("numNamesF = " + numNamesF);
    }
    public static void testGetRank () {
        int year = 2012;
        String name;
        name = "Sofia";
        name = "Sophia";
        name = "Isabella";
        String gender = "F";
        System.out.println(name + " ranked "+getRank(year,name,gender) + " in " + year);
//        System.out.println(name + " ranked " + year + " in ");
    }
    public static int getRank (int year, String name, String gender) {
//        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob2012short.csv");
        String s = fileNameStart + year + fileNameEnd;
//        System.out.println(s);
        FileResource fr = new FileResource(fileNameStart + year + fileNameEnd);
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        for (CSVRecord rec : parser) {
            String nameCurr = rec.get(0);
            String genderCurr = rec.get(1);
            int numBornCurr = Integer.parseInt(rec.get(2));

                if (gender.equals(genderCurr)) {
                    rank++;
                    if (name.equals(nameCurr)) {
                        return rank;
                }
            }
        }
        return -1;
    }
    public static void testGetName () {
        int year = 2012;
        int rank = 3;
        String gender = "F";
        System.out.println("In " + year + " was ranked " +rank+" name " +getName(year,rank,gender));
    }
    public static String getName (int year, int rank, String gender) {
        FileResource fr = new FileResource(fileNameStart + year + fileNameEnd);
        CSVParser parser = fr.getCSVParser(false);
        int rankCur = 0;
        for (CSVRecord rec : parser) {
            String nameCurr = rec.get(0);
            String genderCurr = rec.get(1);
//            int numBornCurr = Integer.parseInt(rec.get(2));
            if (gender.equals(genderCurr)) {
                rankCur++;
                if (rankCur == rank) {
                    return nameCurr;
                }
            }
        }
        return "NO NAME";
    }
    public static void testWhatIsNameInYear () {
        String name = "Isabella";
        int year = 2012;
        int newYear = 2014;
        int rank = 3;
        String gender = "F";
        String nameNew = whatIsNameInYear(name, year, newYear, gender);


    }
    public static String whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rankCurr = getRank (year, name, gender);
        String nameNew = getName (newYear, rankCurr, gender);

        return nameNew;
    }
    public static void testYearOfHighestRank() {
        String name = "Mason";
        String year = "M";
        System.out.println("The Highest Rank of name " + name + " was " + yearOfHighestRank(name,year));
    }
    public static int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int rankCurr = 0;
        int rankHighestSoFar = 1000000;
        int yearHighestRank = 0;
        for (File f : dr.selectedFiles()) {
            String yearS = f.getName();
            yearS = yearS.substring(3,7);
            int year = Integer.parseInt(yearS);
            rankCurr = getRank(year, name, gender);
            System.out.println(name + " " + year + " " + rankCurr);
            if (rankCurr < rankHighestSoFar) {
                rankHighestSoFar = rankCurr;
                yearHighestRank = year;
            }
        }
        if (yearHighestRank>0) {
//            System.out.println("");
            return yearHighestRank;
        }
        return -1;
    }
}