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
        characterNames.clear();
        characterCount.clear();
        
        FileResource fr = new FileResource();
        
        for (String line : fr.lines()) {
        int nameIndex = line.indexOf(".");
        String charName = line.substring(0, nameIndex + 1);
        update(charName);
        }
        
    }
    
    public void charactersWithNumParts (int num1, int num2) {
        
        for (int i = 0; i < characterNames.size(); i ++) {
        int currNum = characterCount.get(i);
        if (currNum >= num1 && currNum <= num2) {
        System.out.println(characterNames.get(i) + "\t" + characterCount.get(i));
        }
        }
        
    }
    
    public void tester () {
    
        findAllCharacters();
        
        for (int i = 0; i < characterNames.size(); i ++) {
            int currNum = characterCount.get(i);
            if (currNum > 2) {
            System.out.println(characterNames.get(i) + "\t" + characterCount.get(i));
            }
        }
        
        //charactersWithNumParts(10, 40); Uncomment to see which characters had major speaking parts.
        
    }
    
}
