package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalyser
{
    public Map<Character, Integer> countSymbols(String cipherText)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        if (cipherText != null) {
            cipherText.chars().forEach(character ->
                frequencyMap.merge((char) character, 1, Integer::sum)
            );
        }
        return frequencyMap;
    }
}
