package classloader.chapter4;


/**
 * 异或
 * 1 1 0
 * 1 0 1
 * 0 0 0
 * 0 1 1
 *
 * 2次异或后结果不变
 */
public class SimpleEncrypt {
    private static final String plain = "Hello ClassLoader";

    private static final byte ENCRYPT_FACTOR = (byte) 0xff;

    public static void main(String[] args) {
        byte[] bytes = plain.getBytes();
        byte[] encrypt = new byte[bytes.length];
        for(int i=0;i<bytes.length;i++){
            encrypt[i]=(byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println(new String(encrypt));

        byte[] decrypt = new byte[encrypt.length];
        for(int i=0;i<encrypt.length;i++){
            decrypt[i]=(byte)(encrypt[i]^ENCRYPT_FACTOR);
        }
        System.out.println(new String(decrypt));
    }


}