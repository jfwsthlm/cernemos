package se.sthlm.jfwsthlm.cernemos.cipher;

public class Rot13
{
    public String cipher(String plainText)
    {
        StringBuilder cipherText = new StringBuilder(plainText.length());
        plainText.chars().forEach(character ->
            cipherText.append((char) (((character - 'A' + 13) % 26) + 'A'))
        );
        return cipherText.toString();

    }

    public String decipher(String cipherText)
    {
        return cipher(cipherText);
    }
}
