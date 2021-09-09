import edu.duke.*;
import java.io.*;

public class WordLengths {
    void countWordLengths (FileResource resource, int [] counts) {

    for (String word : resource.words()) {
    int lengthIndex = word.length();
    char firstLetter = word.charAt(0);
    char lastLetter = word.charAt(word.length() - 1);
    
    if (lengthIndex >= counts.length) {
    counts[counts.length -1] += 1;
    }
    
    if (Character.isLetter(firstLetter) == false || Character.isLetter(lastLetter) == false)
    lengthIndex = word.length() -1;
    counts[lengthIndex] += 1;
    }
    }
    
    public int indexOfMax (int [] values ) {
        int largestVal = 0;
        
        for (int num : values) {
        
            if (num > largestVal) {
            largestVal = num;
            }
            
        }
        return largestVal;
    }
    
    public void testCountWordLengths () {
    FileResource fr = new FileResource();
    int [] counts = new int[31];
    
    countWordLengths(fr,counts);
    
    for (int i = 0; i < counts.length; i ++) {
    System.out.println(counts[i] + " words with lengths of " + i);
    }
    System.out.println("Most occurrences: " + indexOfMax(counts));
    }
    
}

