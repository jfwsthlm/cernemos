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
}