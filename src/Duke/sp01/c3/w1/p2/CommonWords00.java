
/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;
public class CommonWords00
{
	public static void main(String[] args) {
//		System.out.println(getCommon());
		countShakespeare();
		int i;
	}
	public static String[] getCommon(){
		FileResource resource = new FileResource("./data/data.Duke.sp01.c3.w1/message2.txt");
		String[] common = new String[100];
		int index = 0;
		for(String s : resource.words()){
			common[index] = s;
			index += 1;
		}
		return common;
	}
	public static int indexOf(String[] list, String word) {
	    for (int k=0; k<list.length; k++) {
	        if (list[k].equals(word)) {
	               return k;
	           }
	       }
	    return -1;
	}
	public static void countWords(FileResource resource, String[] common, int[] counts){
		for(String word : resource.words()){
			word = word.toLowerCase();
//			for (int i = 0; i < common.length; i++) {
//				int index = word.indexOf(common[i]);
//				System.out.println(index);
				int index = indexOf(common,word);
				if (index != -1) {
					counts[index] += 1;
				}
			}
		}
	public static void countShakespeare(){
		//String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
			//          "likeit.txt", "macbeth.txt", "romeo.txt"};
	    String[] plays = {"small.txt"};
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k=0; k < plays.length; k++){
			FileResource resource = new FileResource("data/data.Duke.sp01.c3.w1/" + plays[k]);
			countWords(resource,common,counts);
			System.out.println("done with " + plays[k]);
		}
		
		for(int k=0; k < common.length; k++){
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}
}