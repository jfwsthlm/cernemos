package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SubstitutionDecipherTest
{
    private final Map<Character, Character> sampleKey = Map.of(
            'H', 'X',
            'E', 'Y',
            'L', 'Z',
            'O', 'W'
    );

    @Test
    void decipherWithFullKeyMatchReplacesAllLetters() {
        String result = SubstitutionDecipher.decipher("HELL", Map.of(
                'H', 'A',
                'E', 'B',
                'L', 'C'
        ));
        assertEquals("ABCC", result);
    }

    @Test
    void decipherWithMixedCaseInputNormalizesToUppercaseAndDeciphers() {
        String result = SubstitutionDecipher.decipher("Hello", sampleKey);
        assertEquals("XYZZW", result);
    }

    @Test
    void decipherWithPartialKeyLeavesUnmappedLettersUnchanged() {
        Map<Character, Character> partialKey = Map.of('H', 'X');
        String result = SubstitutionDecipher.decipher("HELLO", partialKey);
        assertEquals("XELLO", result);
    }

    @Test
    void decipherWithEmptyKeyReturnsUppercaseOriginalString() {
        String result = SubstitutionDecipher.decipher("Hello", Collections.emptyMap());
        assertEquals("HELLO", result);
    }

    @Test
    void decipherWithPunctuationAndNumbersPreservesNonLetters() {
        String result = SubstitutionDecipher.decipher("Hello, World! 123", sampleKey);
        assertEquals("XYZZW, WWRZD! 123", result);
    }

    @Test
    void decipherWithEmptyCiphertextReturnsEmptyString() {
        String result = SubstitutionDecipher.decipher("", sampleKey);
        assertTrue(result.isEmpty());
    }

    @Test
    void decipherWithNullCiphertextThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                SubstitutionDecipher.decipher(null, sampleKey)
        );
    }

    @Test
    void decipherWithNullSubstitutionKeyThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                SubstitutionDecipher.decipher("HELLO", null)
        );
    }

}