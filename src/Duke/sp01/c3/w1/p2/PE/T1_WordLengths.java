package Duke.sp01.c3.w1.p2.PE;
import edu.duke.FileResource;
/** * Created by a on 1/27/17.*/
public class T1_WordLengths {
    public static void main(String[] args) {
//        FileResource resource = new FileResource();
//        FileResource resource = new FileResource("./message2.txt");
        FileResource resource = new FileResource("./data/data_Duke.sp01.c3.w1/message2.txt");
        int counts[] = new int[100];

        System.out.println(countWordLengths(resource, counts).length + " 111111");
    }

    public static int[] countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            StringBuilder wordSB = new StringBuilder(word);

//            word = word.toUpperCase();

//            for (int i = 0; i < wordSB.length(); i++) {
//                char phraseChr = wordSB.charAt(i);
//                if (
                        wordSB.charAt(0);
//                        == Character.toLowerCase(ch)) {
//
//                }
//            }
        }
        return counts;
    }
}
