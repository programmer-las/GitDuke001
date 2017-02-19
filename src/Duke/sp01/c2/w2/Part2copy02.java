package Duke.sp01.c2.w2; /**
 * Created by i on 1/20/17.
 */

import edu.duke.StorageResource;

/**
 * Created by root on 1/18/17.
 */
public class Part2copy02 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    public static String findGene(String dna, int startIndex) {
        startIndex = dna.indexOf("ATG", startIndex);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tempIndex = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(tempIndex, tgaIndex);
        if (minIndex == dna.length()) {
            return "no start ndex";
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }

    public static void testFindGene() {
        int startIndex = 0;
        String dna = "xxxATGzzzTAAxxxyyyTAAxxxATGyyyATGxxxyyyyTAA";
        String ii = findGene(dna, startIndex);
//            System.out.println(ii);
//            return ii;

        dna = "ATGyyyzzzTGAxxxyyyTGAxxxyyy";
        String i = findGene(dna, startIndex);
        System.out.println(i);

        dna = "xxxyyyzzzTGAyxxxyyyTGAxxxyyy";
        String b = findGene(dna, startIndex);
        System.out.println(b);
    }

//    public static void printAllGenes(String dna) {
//        int startIndex = 0;
//        while (true) {
//            String i = findGene(dna, startIndex);
//            System.out.println(i);
//            startIndex = startIndex + i.length() + 3;
//            if (i == "") {
//                break;
//            }
//        }
//    }

    public static StorageResource getAllGenes(String dna) {
        StorageResource genesFile = new StorageResource();
        int startIndex = 0;
        while (true) {
            String i = findGene(dna, startIndex);
            int l = i.length();
        System.out.println("                                                        Codon " + i + ". Length =" + l + ". startIndex = " + startIndex);
            if (i != "") {
                genesFile.add(i);
            }
            startIndex = startIndex + i.length() + 3;
            if (i == "") {
                //processGenes(genesFile);
                return genesFile;
            }
        }
//        for (String geneEach : genesFile.data()) {
//            System.out.println(geneEach);
    }
    public static int howMany(String stringA, String stringB){
        int i = 0;
        int startIndex = stringB.indexOf(stringA);
        while (startIndex != -1){
            startIndex = stringB.indexOf(stringA, startIndex + stringA.length());
            i++;
        }
        return i;
    }
    public static float cgRatio(String dna){
        //    String stringA = "C";
        //    String stringB = dna;
//        int quantityOfCinString = 0;
        int quantityOfC= 0;

//        int quantityOfGinString = 0;
        int quantityOfG= 0;
        float ratio = 0.1f;

        StorageResource genesFile = getAllGenes(dna);
        for (String geneEach : genesFile.data()) {
//                System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ" + geneEach);
            quantityOfC = howMany("C", geneEach);
//            quantityOfC += quantityOfCinString;
//                System.out.println("quantity of C in string is " + quantityOfC);

            quantityOfG = howMany("G", geneEach);
//            quantityOfG += quantityOfGinString;
//                System.out.println("quantity of G in string is " + quantityOfG);

            int quantityOfCG = quantityOfC + quantityOfG;
            ratio = (float) quantityOfCG / geneEach.length();
            System.out.println("ratio = " + ratio);
            //            System.out.println("");

        }

//            System.out.println("quantity of C is " + quantityOfC);
//            System.out.println("quantity of G is " + quantityOfG);
        int quantityOfCG = quantityOfC + quantityOfG;
        return ratio;

    }
    public static void countCTG(String dna){
        int quantityOfCTG= 0;
        StorageResource genesFile = getAllGenes(dna);
        for (String geneEach : genesFile.data()) {
            System.out.println("FROM METHOD countCTG" + geneEach);
            quantityOfCTG = howMany("CTG", geneEach);
//            quantityOfC += quantityOfCinString;
            System.out.println("quantity of CTG in string is " + quantityOfCTG);
        }
    }
    public static void processGenes(StorageResource sr) {
//        StorageResource genesFile = getAllGenes(dna);
        int i = 0;
        for (String geneEach : sr.data()) {
            if (geneEach.length() > 9 ){
                System.out.println("gene with more than 9 characters " + geneEach);
                i++;
            }

            if (cgRatio(geneEach) > 0.35){
                System.out.println("C-G-ratio is higher than 0.35 \n");
            }
        }
        System.out.println("The number of Strings in sr that are longer than 9 characters " + i);
    }
    public static void main(String[] args) {
//                        0         1         2         3         4         5
//                        01234567890123456789012345678901234567890123456789012345
        String dna = "xxxATGCTGCTGTAAxxxCyyGyTAAxxxATGCTGATGCCCyyyTAA123ATGTAA";
//                           ATGCTGCTGTAA              ATGCTGATGCCCyyyTAA   ATGTAA

//            StorageResource sr = getAllGenes(dna);
//            processGenes(sr);
//            countCTG(dna);
        processGenes(getAllGenes(dna));
    }
}