import java.util.*;
import edu.duke.*;

public class myWords 
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public myWords () {
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique() {
    myWords.clear();
    myFreqs.clear();
    
    FileResource fr = new FileResource();
    
    for (String s : fr.words()) {
    s = s.toLowerCase();
    int index = myWords.indexOf(s);
   
    
    if (index == -1) {
        myWords.add(s);
        myFreqs.add(1);
    }
    else {
        int value = myFreqs.get(index);
        myFreqs.set(index,value + 1);
    }
    }
    
    }
    
    public int findIndexOfMax () {
        int maxIndex = 0;
        
        for (int i = 0; i < myFreqs.size(); i ++) {
            
        if (maxIndex < myFreqs.get(i)) {
        maxIndex = myFreqs.get(i);
        }
        if (maxIndex == myFreqs.get(i)) {
        maxIndex = myFreqs.indexOf(maxIndex);
        }
        i ++;
        }
        return maxIndex;
    }
    
    public void tester () {
    findUnique();
    System.out.println("Number of unique words: " + myWords.size());
    
    for (int i = 0; i < myWords.size(); i ++) {
    System.out.println(myWords.get(i) + "\t" + myFreqs.get(i));
    }
    int max = findIndexOfMax();
    System.out.println("The word that occurs most often and its count are: " + myWords.get(max) + " " +  myFreqs.get(max));
    }
    
}
