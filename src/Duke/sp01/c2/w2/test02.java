package Duke.sp01.c2.w2;

/**
 * Created by i on 1/20/17.
 */
public class test02 {
    public static String mystery(String dna) {
        int pos = dna.indexOf("T");
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (count < 3) {
            count += 1;
            String delta = dna.substring(startPos,pos);
            newDna = newDna + delta;
            startPos = pos+1;
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }
    public static void main(String[] args) {
//                    012345678910
        String dna = "aaaTbbbbTcccccTaaaTaaTaaa";
        System.out.println(mystery(dna));

    }
}
