package Duke.sp01.c3.w1.p1.PE;

import edu.duke.FileResource;

/**
 * Created by a on 26.01.17.
 */
public class T4_CaesarCipher {
    public static void main(String[] args) {
//        System.out.println(isVowel('A') + " " +isVowel('B'));
////        System.out.println(isVowel('B'));
////        System.out.println(replaceVowels("Hello World", '*'));
//        System.out.println("===== task 3  emphasize ======");
//        System.out.println(emphasize("dna ctgaaactga", 'a'));
//        System.out.println("dn* ctg+*+ctg+ is correct");
//        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
//        System.out.println("M+ry Bell+ +br*c*d*br+ is correct");
        testencrypt();
    }
    public static void testencrypt() {
        int key = 1;
        FileResource fr = new FileResource("./data/message2.txt");
//        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);

        String outputTest = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!";
    }
    public static boolean isVowel(char ch) {
        String vowels = "aeiou";
//        if (vowels.indexOf(Character.toUpperCase(ch)) != -1) {
        char chX = Character.toLowerCase(ch);
        if (vowels.indexOf(chX) != -1) {
            return true;
        } else {
            return false;
        }
    }
    public static String replaceVowels(String phrase, char ch) {
        StringBuilder phraseCurr = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char phraseChr = phrase.charAt(i);
            if (isVowel(phraseChr)) {
                phraseCurr.setCharAt(i,ch);
            }
        }
        String phraseStr = phraseCurr.toString();
        return phraseStr;
    }
    public static String emphasize(String phrase, char ch) {
        StringBuilder phraseCurr = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char phraseChr = phrase.charAt(i);
            if (Character.toLowerCase(phraseChr) == Character.toLowerCase(ch)) {
                if (i%2 == 1) {
                    phraseCurr.setCharAt(i,'+');
                } else {
                    phraseCurr.setCharAt(i,'*');
                }
            }
        }
        String phraseStr = phraseCurr.toString();
        return phraseStr;
    }
    public static String encrypt(String input, int key) {
        StringBuilder phraseCurr = new StringBuilder(input);
        for (int i = 0; i < phraseCurr.length(); i++) {

        }
        return "TEXT";
    }
}