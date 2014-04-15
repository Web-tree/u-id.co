package co.uid.utils;


/**
 * @author Maxim Levicky
 *         created 14.04.2014
 */
public class IdEncoder {
//    static char[] symbols = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] symbols = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String encodeId(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id can't be less then 0");
        }
        StringBuilder encodedId = new StringBuilder();
        int step = 1;
        do {
            int modulo = (int) (id % (symbols.length));
            if (step++ > 1) {
                modulo--;
                id--;
            }
            encodedId.append(symbols[modulo < 0 ? symbols.length + modulo : modulo]);
            id = id / symbols.length;
        }
        while (id > 0);
        return encodedId.reverse().toString();
    }

    public static Long decodeId(String encodedId) {
        Long sum = 0L;
        for (int i = encodedId.length()-1; i > -1; i--) {
            char idChar = encodedId.charAt(i);

            boolean found = false;
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j] == idChar) {
                    int charPosition;
                    if (i == (encodedId.length() - 1)) {
                        charPosition = j;
                    } else {
                        charPosition = j + 1;
                    }
                    if (charPosition >= symbols.length) {
                        charPosition = charPosition - symbols.length;
                        sum += calcDecodeSum(1, encodedId.length() - i);
                    }
                    sum += calcDecodeSum(charPosition, encodedId.length() - i - 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Given string with not used symbol");
            }
        }
        return sum;
    }

    private static Long calcDecodeSum(int multiplier, int pow) {
        return new Double(multiplier * Math.pow(symbols.length, pow)).longValue();
    }
}
