package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyAnalyserTest
{
    @Test
    void testCountSymbols()
    {
        FrequencyAnalyser frequencyAnalyser = new FrequencyAnalyser();
        Map<Character, Integer> frequencyMap = frequencyAnalyser.countSymbols("HELLOWORLD");
        assertEquals(1, frequencyMap.get('H'));
        assertEquals(3, frequencyMap.get('L'));
    }

    @Test
    void countSymbolsCanHandleNullInput()
    {
        FrequencyAnalyser frequencyAnalyser = new FrequencyAnalyser();
        frequencyAnalyser.countSymbols(null);
        assertTrue(true);
    }
}