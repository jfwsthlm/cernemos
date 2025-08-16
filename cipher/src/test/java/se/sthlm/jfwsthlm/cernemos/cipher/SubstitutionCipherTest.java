package se.sthlm.jfwsthlm.cernemos.cipher;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutionCipherTest
{
    @Test
    void testSubstitution()
    {
        Rot13 rot13 = new Rot13();
        String cipherText = rot13.cipher("FREQUENCYANALYZETHIS");
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();
        Map<Character, Integer> frequencyMap = substitutionCipher.countFrequency(cipherText);
        assertEquals(3, frequencyMap.get('R'));
    }
}