package co.uid.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Maxim Levicky
 *         created 14.04.2014
 */
public class IdEncoderTest {
    @Test
    public void testEncodeId() throws Exception {
//        assertEquals("a", IdEncoder.encodeId(1L));
//        assertEquals("b", IdEncoder.encodeId(2L));
//        assertEquals("z", IdEncoder.encodeId(26L));
//        assertEquals("aa", IdEncoder.encodeId(27L));
        assertEquals("bz", IdEncoder.encodeId(78L));
    }

    @Test
    public void testDecodeId() throws Exception {

    }
}
