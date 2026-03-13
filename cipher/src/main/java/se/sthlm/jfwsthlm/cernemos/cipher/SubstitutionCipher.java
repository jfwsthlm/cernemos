package se.sthlm.jfwsthlm.cernemos.cipher;

import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher
{
    public Map<Character, Integer> countFrequency(String cipherText) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        cipherText.chars().forEach(character ->
            frequencyMap.put((char)character,
                frequencyMap.getOrDefault((char)character, 0) + 1)
        );
        return frequencyMap;
    }

    public String cipher(String plainText, Map<Character, Character> substitutionKey)
    {
        StringBuilder cipherText = new StringBuilder(plainText.length());

        plainText.chars().forEach(c -> {
            char ch = (char) c;

            if (Character.isLetter(ch)) {
                ch = Character.toUpperCase(ch);
                cipherText.append(substitutionKey.get(ch));
            } else {
                cipherText.append(ch); // leave symbol as-is
            }
        });

        return cipherText.toString();
    }
}