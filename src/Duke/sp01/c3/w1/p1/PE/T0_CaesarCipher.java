package Duke.sp01.c3.w1.p1.PE;
/**
 * Created by a on 25.01.17.
 */
public class T0_CaesarCipher {
    public static void main(String[] args) {
        String s = "GTYUIKMNBG";
        int i = 3;
        encript(s, i);
    }
    public static String encript (String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(3) + alphabet.substring(0,3);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {

                encrypted.setCharAt(idx, shiftedAlphabet.charAt(idx));
//                System.out.println("UNFIFSHED");
//                char newChar = char shiftedAlphabet.charAt(idx);
            }
//            System.out.print(idx);
        }
        System.out.println(encrypted);
        String output = encrypted.toString();
//        encrypted.indexOf(key)
        return output;
    }
}
