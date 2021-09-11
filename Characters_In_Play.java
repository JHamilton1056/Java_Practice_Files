import edu.duke.*;
import java.util.*;

public class CharachtersInPlay {
    
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterCount;
    
    public CharachtersInPlay () {
    characterNames = new ArrayList<String>();
    characterCount = new ArrayList<Integer>();
    }
    
    public void update (String person) {
    
        if (! characterNames.contains(person)) {
        characterNames.add(person);
        characterCount.add(1);
        }
        else {
        int index = characterNames.indexOf(person);
        int value = characterCount.get(index);
        characterCount.set(index,value + 1);
        }
    } 
    
    public void findAllCharacters () {
    
        FileResource fr = new FileResource();
        
        for (String line : fr.lines()) {
        int nameIndex = line.indexOf(".");
        String charName = line.substring(0, nameIndex);
        update(charName);
        }
        
    }
    
    public void tester () {
    
        findAllCharacters ();
        
        for (int i = 0; i < characterNames.size(); i ++) {
            int currNum = characterCount.get(i);
            if (currNum > 1) {
            System.out.println(characterNames.get(i) + "\t" + characterCount.get(i));
            }
        }
        
    }
    
}
