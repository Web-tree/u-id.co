package co.uid.utils;

/**
 * @author Maxim Levicky
 *         created 14.04.2014
 */
public class IdEncoder {
    public static char[] symbols = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String encodeId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id can't be less then 0");
        }
        StringBuilder encodedId = new StringBuilder();
        do {
            int i = ((int) (id % (symbols.length))) - 1;
            encodedId.append(symbols[i == -1 ? symbols.length-1 : i]);
            id = id / symbols.length;
        }
        while (id > 0);
//        char[] stringId = String.valueOf(id).toCharArray();
//        int currentPosition = stringId.length - 1;
//        StringBuilder encodedId = new StringBuilder();
//        for (char idChar : stringId) {
//            int intCharId = Character.getNumericValue(idChar);
//            if (intCharId > 0) {
//                encodedId.append(symbols[(int) (intCharId * Math.pow(10, currentPosition--)) - 1]);
//            }
//        }
        return encodedId.reverse().toString();
    }

    public static Long decodeId(String encodedId) {
        return 0L;
    }
}
