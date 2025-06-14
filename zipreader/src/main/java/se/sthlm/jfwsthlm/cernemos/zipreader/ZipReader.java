package se.sthlm.jfwsthlm.cernemos.zipreader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;

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
        try (ZipInputStream zipInputStream = new ZipInputStream(zipFileInputStream)) {
            LocalFileHeader localFileHeader;
            while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
                headerEntries.add(localFileHeader.getFileName());
            }
        } catch (Exception e) {
            LOG.error("Error reading ZIP stream: ", e);
        }
        return headerEntries;
    }

    protected boolean testPasswordOnStream(String password) {
        try (ZipInputStream zipInputStream = new ZipInputStream(zipFileInputStream, password.toCharArray())) {
            LocalFileHeader localFileHeader = zipInputStream.getNextEntry();

            if (localFileHeader != null && localFileHeader.isEncrypted()) {
                byte[] buffer = new byte[1];
                zipInputStream.read(buffer);
            }
            return true;

        } catch (ZipException e) {
            if (e.getType() == ZipException.Type.WRONG_PASSWORD) {
                LOG.error("Password is INCORRECT for the ZIP stream.");
                return false;
            } else {
                LOG.error("An unexpected ZipException occurred for the ZIP stream: {}", e.getMessage());
                return false;
            }
        } catch (IOException e) {
            LOG.error("I/O error accessing ZIP stream: {}", e.getMessage());
            return false;
        } catch (Exception e) {
            LOG.error("An unexpected error occurred for the ZIP stream: " + e.getMessage());
            return false;
        }
    }
}