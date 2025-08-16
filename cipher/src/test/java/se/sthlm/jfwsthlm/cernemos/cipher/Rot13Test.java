package se.sthlm.jfwsthlm.cernemos.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13Test
{
    @Test
    void testCipher()
    {
        Rot13 rot13 = new Rot13();
        String cipherText = rot13.cipher("HELLOWORLD");
        assertEquals("URYYBJBEYQ", cipherText);
        String plainText = rot13.decipher(cipherText);
        assertEquals("HELLOWORLD", plainText);
    }
}