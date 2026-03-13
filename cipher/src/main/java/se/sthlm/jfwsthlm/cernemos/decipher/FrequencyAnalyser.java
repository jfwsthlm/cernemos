package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyAnalyser
{
    public Map<Character, Integer> countSymbols(String cipherText)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        if (cipherText != null) {
            cipherText.chars().forEach(c -> {
                char ch = (char) c;
                if (Character.isLetter(ch)) {
                    ch = Character.toUpperCase(ch);
                    frequencyMap.merge(ch, 1, Integer::sum);
                }
            });
        }
        List<Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        //sortedList.sort(Map.Entry.comparingByValue());
        sortedList.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : sortedList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
