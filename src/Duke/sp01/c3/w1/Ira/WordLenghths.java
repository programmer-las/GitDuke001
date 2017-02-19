package duke03.week01;
import edu.duke.FileResource;

import java.io.File;
// todo add link of task and part of task
/**
  Created by a on 2/13/2017.
 https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/727CD/programming-exercise-breaking-the-caesar-cipher

 Before attempting these assignments, you should type in, compile, and understand the example programs from the lesson, including: 1) counting the twenty most common words from Shakespeare’s plays, 2) counting the resulting random rolls of dice (how many 2’s, 3’s, 4’s, etc), and 3) automatic decryption of the Caesar Cipher using statistical letter occurrences.

 Assignment 1: Word lengths

 You will write a program to figure out the most common word length of words from a file. To solve this problem you will need to keep track of how many words from a file are of each possible length. You should group all words of length 30 or more together, and you should not count basic punctuation that are the first or last characters of a group of characters.

 Specifically, you should do the following:

 Create a new class called WordLengths.
 Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.

 - For example, after this method executes, counts[k] should contain the number of words of length k.

 - If a word has a non-letter as the first or last character, it should not be counted as part of the word length. For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is). Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

 - For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.

 - You may want to consider using the Character.isLetter method that returns true if a character is a letter, and false otherwise. For example, Character.isLetter(‘a’) returns true, and Character.isLetter(‘-’) returns false.

 Write a void method testCountWordLengths that creates a FileResource so you can select a file, and creates a counts integer array of size 31. This method should call countWordLengths with a file and then print the number of words of each length. Test it on the small file smallHamlet.txt shown below.
 Write a method indexOfMax that has one parameter named values that is an integer array. This method returns the index position of the largest element in values. Then add code to the method testCountWordLengths to call indexOfMax to determine the most common word length in the file. For example, calling indexOfMax after calling countWordLengths on the file smallHamlet.txt should return 3.

 First test your program on a small file, such as this simple file shown called smallHamlet.txt:

 Laer. My necessaries are embark'd. Farewell.

 And, sister, as the winds give benefit

 Note this file has words that are:

 2 words of length 2: My as

 3 words of length 3: are And the

 2 words of length 4: Laer give

 1 word of length 5: winds

 1 word of length 6: sister

 1 word of length 7: benefit

 2 words of length 8: embark’d Farewell

 1 word of length 11: necessaries
 */
public class WordLenghths {
    public static void main(String[] args) {
    testCountWordLengths();
    }
    public static void countWordLength(FileResource resource, int [] counts){
        for(String s : resource.words()) {
            // todo add test-string
//            String s = "?";
            char chFirst = s.charAt(0);
            char chLast = s.charAt(s.length() - 1);
            // todo: (was mistake) add condition
//                if (Character.isLetter(s.charAt(0)) && s.length() != 1) {
                if (!(!Character.isLetter(s.charAt(0)) && s.length() == 1)) {
                    chLast = s.charAt(s.length() - 1);
                    int wordLength = s.length();
                    if (!Character.isLetter(chFirst)) {
                        wordLength = wordLength - 1;
                    }
                    if (!Character.isLetter(chLast)) {
                        wordLength = wordLength - 1;
                    }
                    // todo: was mistake
                    if (wordLength <= 30 && wordLength >= 0){
                        counts[wordLength] += 1;
                    }
                    else if (wordLength > 30){
                        counts[30] += 1;
                    }
                    else {
                        counts[0] +=1;
                    }
                    System.out.println(wordLength + " " + s);
                }
        }

        System.out.println("Iryna's programm: Note this file has words that are:");
        int countAllWords = 0;
        for (int k = 0; k < counts.length; k++) {
            // todo add condition of non-zero printing
            if (counts[k] > 0) {
                System.out.println(counts[k] + " words of length " + k);
                // todo: add countAllWords
                countAllWords += counts[k];
            }
        }
        System.out.println("countAllWords = " + countAllWords);
    }
    public static int indexOfMax() {
        return 0;
    }
    public static void testCountWordLengths(){
//        FileResource resource = new FileResource();
        // todo add using THE file
//        FileResource resource = new FileResource("./data/data.Duke.sp01.c3.w1/smallHamlet.txt");
        FileResource resource = new FileResource("./data/data.Duke.sp01.c3.w1/Hamlet.txt");
        int [] counts = new int[31];
        countWordLength(resource, counts );
    }
}