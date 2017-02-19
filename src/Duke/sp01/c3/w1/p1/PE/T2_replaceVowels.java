package Duke.sp01.c3.w1.p1.PE;
/**
 * Created by a on 25.01.17.
 */
public class T2_replaceVowels {
    public static void main(String[] args) {
        System.out.println(isVowel('A') + " " +isVowel('B'));
//        System.out.println(isVowel('B'));
        System.out.println(replaceVowels("Hello World", '*'));
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
//            phraseChr = Character.toUpperCase(phraseChr);
//            System.out.println(phraseChr);
            if (isVowel(phraseChr)) {
                phraseCurr.setCharAt(i,ch);
//                System.out.println(phraseRes);
            }
        }

        String phraseStr = phraseCurr.toString();
        return phraseStr;
    }
}
