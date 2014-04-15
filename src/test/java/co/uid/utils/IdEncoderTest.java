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
        String currentString = String.valueOf(IdEncoder.symbols[0]);
        int start = 0;
        for (long current = 0, finish = 100000L; current < finish; current++) {
            if (start <= current) {
                assertEquals(currentString, IdEncoder.encodeId(current));
            }
            currentString = next(currentString);
        }
    }

    @Test
    public void testDecodeId() throws Exception {
        String currentString = String.valueOf(IdEncoder.symbols[0]);
        int start = 0;
        for (Long current = 0L, finish = 100000L; current < finish; current++) {
            if (start <= current) {
                assertEquals(current, IdEncoder.decodeId(currentString));
            }
            currentString = next(currentString);
        }
    }

    private static String next(String s) {
        int length = s.length();
        char c = s.charAt(length - 1);

        String firstSymbol = String.valueOf(IdEncoder.symbols[0]);
        if(c == IdEncoder.symbols[IdEncoder.symbols.length - 1])
            return length > 1 ? next(s.substring(0, length - 1)) + firstSymbol : firstSymbol+firstSymbol;

        return s.substring(0, length - 1) + ++c;
    }
}
