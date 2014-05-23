package com.jeffinmadison.mygasmilage.util;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Jeff on 11/5/13.
 * Copyright JeffInMadison 2013
 */
public class FileUtils {

    public static void moveReaderPastBOM(Reader reader) throws IOException
    {
        reader.mark(1);
        char[] possibleBOM = new char[1];
        reader.read(possibleBOM);

        if (possibleBOM[0] != '\ufeff')
        {
            reader.reset();
        }
    }
}
