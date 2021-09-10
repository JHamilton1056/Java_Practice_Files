import edu.duke.*;

public class oopCipher {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public oopCipher (int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        
        for (int i = 0; i < encrypted.length(); i ++) {
        char currChar = Character.toLowerCase(encrypted.charAt(i));
        
        int idx = alphabet.indexOf(currChar);
        
           if (idx != -1) {
            
            char newChar = shiftedAlphabet.charAt(idx);
            encrypted.setCharAt(i, newChar);
            }
          
        }
        return encrypted.toString();
    }
    
}

public class TestCaesarCipher {

    public int [] countLetters (String message) {
    String alph = "abcdefghijklmnopqrstuvwxyz";
    int [] counts = new int[26];
    
    for (int i = 0; i < message.length(); i ++) {
    
    char ch = Character.toLowerCase(message.charAt(i));
    
    int dex = alph.indexOf(ch);
    if (dex != -1 ) {
    counts[dex] += 1;
    }
    
    }
    return counts;
    } 
    
    public int maxIndex (int [] frequencies) {
    
        int maxIndex = 0;
        
        for (int i = 0; i < frequencies.length; i ++) {
        
            if (maxIndex < frequencies[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public String breakCipher (String encrypted) {
    
    int [] freq = countLetters(encrypted);
    int maxDex = maxIndex(freq);
    int dkey = maxDex - 4;
    
    if (maxDex < 4) {
    dkey = 26 - (4 - maxDex);
    }
    oopCipher cc = new oopCipher(dkey);
    return cc.encrypt(encrypted);
    }
    
    public void simpleTests () {
    FileResource fr = new FileResource();
    
    String input = fr.asString();
    
    oopCipher cc = new oopCipher(18);
    
    String encryptedString = cc.encrypt(input);
    System.out.println(encryptedString);
    String decrypted = breakCipher(input);
    System.out.println(decrypted);
    }
    
}
