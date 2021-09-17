import java.util.*;
import edu.duke.*;
import java.io.File;
import java.lang.*;

public class wordsInFile {
    
    private HashMap <String,ArrayList<String>> wordMap;
    
    public wordsInFile () {
    HashMap <String,ArrayList<String>> wordMap = new HashMap <String,ArrayList<String>>();
    }
    
    private void addWordsFromFile (File f) {
        FileResource fr = new FileResource(f);
        ArrayList <String> wordArray = new ArrayList();
        
        for (String w : fr.words()) {
        if (wordMap.keySet().contains(w)) {
        wordArray = wordMap.get(w);
        String fileName = f.getName();
        wordArray.add(fileName);
    }   
        else {
          
        wordMap.put(w,wordArray);
        }
        }
    }
    
    public void buildWordFileMap () {
        wordMap.clear();
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
        addWordsFromFile(f);
        }
    
    }
    
    public int maxNumber () {
        
        int mostSoFar = 0;
        
        for (String s : wordMap.keySet()) {
            int currNum = wordMap.get(s).size();
            if (currNum > mostSoFar) {
            mostSoFar = currNum;
            }
        }
        return mostSoFar;
    }
    
    
}

