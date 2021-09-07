public class caesarCipher {

    
    public String encrypt (String input, int key) {
    
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedAlph = alphabet.substring(key) + alphabet.substring(0, key);
        String lowerShifted = lowerAlphabet.substring(key) + lowerAlphabet.substring(0, key);
        
        for (int i = 0; i < encrypted.length(); i ++) {
        
        char currChar = encrypted.charAt(i);
        
        int idx = alphabet.indexOf(currChar);
        int lwrIdx = lowerAlphabet.indexOf(currChar);
        
           if (idx != -1) {
            
            char newChar = shiftedAlph.charAt(idx);
            encrypted.setCharAt(i, newChar);
            }
           
           if (lwrIdx != -1) {
            
            char newChar = lowerShifted.charAt(lwrIdx);
            encrypted.setCharAt(i, newChar);
            }
            
       }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys (String input, int key1, int key2) {
    
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedAlph1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String lowerShifted1 = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0, key1);
        
        String shiftedAlph2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        String lowerShifted2 = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0, key2);

        for (int i = 0; i < encrypted.length(); i ++) {
        
        char currChar = encrypted.charAt(i);
        
        int idx = alphabet.indexOf(currChar);
        int lwrIdx = lowerAlphabet.indexOf(currChar);
        
           if (idx != -1 && i % 2 == 0) {
            
            char newChar = shiftedAlph1.charAt(idx);
            encrypted.setCharAt(i, newChar);
            }
           
           if (lwrIdx != -1 && i % 2 == 0) {
            
            char newChar = lowerShifted1.charAt(lwrIdx);
            encrypted.setCharAt(i, newChar);
            }
            
           if (idx != -1 && i % 3 == 0) {
            
            char newChar = shiftedAlph2.charAt(idx);
            encrypted.setCharAt(i, newChar);
            }
           
           if (lwrIdx != -1 && i % 3 == 0) {
            
            char newChar = lowerShifted2.charAt(lwrIdx);
            encrypted.setCharAt(i, newChar);
            }
            
    }
    return encrypted.toString();
}

}
