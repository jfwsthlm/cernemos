package se.sthlm.jfwsthlm.cernemos.zipreader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

public class ZipReader
{
    private static final XLogger LOG = XLoggerFactory.getXLogger(ZipReader.class);
    private final InputStream zipFileInputStream;

    public ZipReader(InputStream zipFileInputStream)
    {
        this.zipFileInputStream = zipFileInputStream;
    }

    protected List<String> readHeader()
    {
        List<String> headerEntries = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(zipFileInputStream))
        {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                headerEntries.add(entry.getName());
            }
        } catch (Exception e) {
            LOG.error("Error reading ZIP stream: ", e);
        }
        return headerEntries;
    }
}