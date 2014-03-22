package com.jeffinmadison.mygasmilage.util;

import junit.framework.TestCase;

/**
 * Created by Jeff on 3/22/2014.
 * Copyright Noble Applications 2014
 */
public class StringUtilsTest extends TestCase {
    public void testIsNullOrEmpty() throws Exception {
        assertEquals(true, StringUtils.isNullOrEmpty(null));
        assertEquals(true, StringUtils.isNullOrEmpty(StringUtils.EMPTY_STRING));
    }
}
