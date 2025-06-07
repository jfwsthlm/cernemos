package se.sthlm.jfwsthlm.cernemos.zipreader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipReaderTest
{
    @Test
    void readingZipFileHeaderReturnsListOfStrings() throws IOException
    {
        List<String> header = null;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("mini-word.zip")) {
            ZipReader zipReader = new ZipReader(inputStream);
            header = zipReader.readHeader();
        }

        assertEquals(1, header.size());
        assertEquals("mini-word.docx", header.get(0));
    }
}