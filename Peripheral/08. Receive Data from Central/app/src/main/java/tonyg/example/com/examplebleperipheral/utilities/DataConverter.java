package tonyg.example.com.examplebleperipheral.utilities;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/**
 * Convert data formats
 *
 * @author Tony Gaitatzis backupbrain@gmail.com
 * @date 2015-12-21
 */

public class DataConverter {

    /**
     * convert bytes to hexadecimal for debugging purposes
     *
     * @param intValue the data to convert
     * @param length the max length of the data
     * @return byte array version of the intValue
     */
    public static byte[] intToBytes(int intValue, int length) {
        ByteBuffer b = ByteBuffer.allocate(length);

        // BLE Data is always little-endian
        b.order(ByteOrder.LITTLE_ENDIAN);
        b.putInt(intValue);

        return b.array();
    }

    /**
     * convert bytes to hexadecimal for debugging purposes
     *
     * @param bytes
     * @return Hexadecimal String representation of the byte array
     */
    public static String bytesToHex(byte[] bytes) {
        if (bytes.length <=0) return "";
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 3];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 3] = hexArray[v >>> 4];
            hexChars[j * 3 + 1] = hexArray[v & 0x0F];
            hexChars[j * 3 + 2] = 0x20; // space
        }
        return new String(hexChars);
    }

    /**
     * convert bytes to an integer in Little Endian for debugging purposes
     *
     * @param bytes a byte array
     * @return integer integer representation of byte array
     */
    //
    public static String bytesToInt(byte[] bytes) {
        if (bytes.length <=0) return "";
        char[] decArray = "0123456789".toCharArray();
        char[] decChars = new char[bytes.length * 3];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            decChars[j * 2] = decArray[v >>> 4];
            decChars[j * 2 + 1] = decArray[v & 0x0F];
        }

        return new String(decChars);
    }

}
