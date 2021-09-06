import java.io.*;
import java.lang.*;

public class WordPlay {

    public boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        
        if (vowels.indexOf(ch) != -1) {
        return true;
        }
        else {
        return false;
        }
    }
    
    public String replaceVowels (String phrase, char ch) {
        String newPhrase = "";
        
        for(int i = 0; i < phrase.length(); i ++) {
            char currChar = phrase.charAt(i);
            if (isVowel(currChar) == true) {
            currChar = ch;
            newPhrase += currChar;
            }
            else{
            newPhrase += currChar;
            }
        }
        return newPhrase;
    }
    
    public String emphasize (String phrase, char ch) {
        
        String newPhrase = "";
        
        for (int i = 0; i < phrase.length(); i ++) {
            char currChar = Character.toLowerCase(phrase.charAt(i));
            System.out.println(currChar);
            
           if (currChar == ch && phrase.indexOf(currChar)  % 3 == 0) {
            currChar = '*';
           }
            
           else if (currChar == ch && phrase.indexOf(currChar) % 2 == 0) {
            currChar = '+';
           }
    
            newPhrase += currChar;
    }
    return newPhrase;
}

public class caesarCipher {

    
    public String encrypt (String input, int key) {
    
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlph = alphabet.substring(key) + alphabet.substring(0, key);
        
        for (int i = 0; i < encrypted.length(); i ++) {
        
        char currChar = encrypted.charAt(i);
        
        int idx = alphabet.indexOf(currChar);
        
           if (idx != -1) {
            
            char newChar = shiftedAlph.charAt(idx);
            encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
}