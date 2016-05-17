package entPra;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;


public class RC4 {
    private final byte[] S = new byte[256];
    private final byte[] T = new byte[256];
    private final int keylen;

    public RC4(final byte[] key) {
        if (key.length < 1 || key.length > 256) {
            throw new IllegalArgumentException(
                    "key must be between 1 and 256 bytes");
        } else {
            keylen = key.length;
            for (int i = 0; i < 256; i++) {
                S[i] = (byte) i;
                T[i] = key[i % keylen];
            }
            int j = 0;
            for (int i = 0; i < 256; i++) {
                j = (j + S[i] + T[i]) & 0xFF;
                byte temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }
        }
    }

    public byte[] encrypt(final byte[] plaintext) {
        final byte[] ciphertext = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        for (int counter = 0; counter < plaintext.length; counter++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            byte temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            t = (S[i] + S[j]) & 0xFF;
            k = S[t];
            ciphertext[counter] = (byte) (plaintext[counter] ^ k);
        }
        return ciphertext;
    }

    public byte[] decrypt(final byte[] ciphertext) {
        return encrypt(ciphertext);
    }
    
    public static void main(String args[]) throws Exception {
    	
    	String algorithmMD5 = "MD5";
    	String MSISDN ="919910050396";
    	String key = "wdTDoh8YxYcd3p";
    	
    	String hexString = MD5ofKey(algorithmMD5, key);
		
        byte[] keytest = hexString.getBytes();
        
//        byte[] text = MSISDN.getBytes();
        byte[] text = {9,1,9,9,1,0,0,5,0,3,9,6}; // text as 12345

        RC4 rc4 = new RC4(keytest);

        System.out.print("\noriginal text: ");
        for (int i = 0; i < text.length; i++) {          
            System.out.print(text[i]);
        }

        byte[] cipher = rc4.encrypt(text); //encryption      
        System.out.print("\ncipher: ");
        for (int i = 0; i < cipher.length; i++) {          
            System.out.print(cipher[i]);          
        }
        System.out.println();
        
        rc4 = new RC4(keytest);
        byte[] backtext = rc4.decrypt(cipher); //decryption
        System.out.print("\nback to text: ");
        for (int i = 0; i < backtext.length; i++) {
        	byte b = backtext[i];
            System.out.print(b);
        }
        System.out.println();
    }

	private static String MD5ofKey(String algorithmMD5, String key)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] byteOfKey = key.getBytes("UTF-8");
		MessageDigest messageDigest = MessageDigest.getInstance(algorithmMD5);
		byte[] MD5OfKey = messageDigest.digest(byteOfKey);
		
		String hexString = Hex.encodeHexString(MD5OfKey);
		
		System.out.println(hexString);
		return hexString;
	}
    
}
