package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubstitutionKeyBuilderTest
{
    @Test
    void testBuildKey()
    {
        SubstitutionKeyBuilder substitutionKeyBuilder = new SubstitutionKeyBuilder();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
        substitutionKeyBuilder.buildKey(frequencyMap);
        assertTrue(true);
    }

    @Test
    void testAddMissingLettersToFrequencyMap()
    {
        SubstitutionKeyBuilder substitutionKeyBuilder = new SubstitutionKeyBuilder();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
        substitutionKeyBuilder.addMissingLettersToFrequencyMap(frequencyMap);
        assertEquals(26, frequencyMap.size());
    }

}