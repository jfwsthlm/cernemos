package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class SubstitutionKeyBuilder
{
    List<Character> mostCommonEnglishLetters = List.of(
        'E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R',
        'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G', 'Y',
        'P', 'B', 'V', 'K', 'J', 'X', 'Q', 'Z'
    );

    public Map<Character, Character> buildKey(Map<Character, Integer> frequencyMap)
    {
        Map<Character, Character> substitutionKey = new HashMap<>();

        int index = 0;
        for (Character characterFromCipher : frequencyMap.keySet())
        {
            substitutionKey.put(characterFromCipher, mostCommonEnglishLetters.get(index));
            index ++;
        }
        return substitutionKey;
    }

    public void addMissingLettersToFrequencyMap(Map<Character, Integer> frequencyMap)
    {
        for (Character character : mostCommonEnglishLetters)
        {
            frequencyMap.putIfAbsent(character, 0);
        }
    }
}
