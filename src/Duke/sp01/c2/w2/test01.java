package Duke.sp01.c2.w2;
import edu.duke.URLResource;

/**
 * Created by i on 1/20/17.
 */
public class test01 {
    public static void finder() {
        int startIndex;
        int endIndex;
        URLResource duke = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : duke.words()) {
            if (word.toLowerCase().indexOf("youtube.com") != -1) {
                startIndex = word.indexOf("\"")+1;
                endIndex = word.lastIndexOf("\"");
                System.out.println(word.substring(startIndex, endIndex));

            }
        }
    }

    public static void main(String[] args) {

        finder();

    }
}
