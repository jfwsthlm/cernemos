package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.Map;

public class SubstitutionDecipher
{
    public static String decipher(String ciphertext, Map<Character, Character> substitutionKey)
    {
        StringBuilder plainText = new StringBuilder(ciphertext.length());

        ciphertext.chars().forEach(c -> {
            char ch = (char) c;

            if (Character.isLetter(ch)) {
                // Normalize to uppercase if your key uses uppercase
                ch = Character.toUpperCase(ch);

                plainText.append(substitutionKey.getOrDefault(ch, ch));
            } else {
                // Keep non-letters unchanged
                plainText.append(ch);
            }
        });

        return plainText.toString();
    }
}
