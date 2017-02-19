package Duke.sp01.c3.w1.p2.PE;
import edu.duke.*;

//import static jdk.nashorn.internal.objects.NativeString.indexOf;

/**
 * Created by a on 1/29/2017.
 */
public class T0_tryIndexOf {
    public static void main(String[] args) {
        String [] common = {"I", "you", "we"};
        String word = "you";
//        mistake(word, common);
        OK(word, common);
    }

    public static void mistake(String word, String [] common) {
//        int index = indexOf(common,word);
    }

    public static void OK(String word, String [] common) {
        System.out.println("common = " + common[0]);
        for (int i = 0; i < common.length; i++) {
            int index = word.indexOf(common[i]);
            System.out.println(index);
        }
    }
}

