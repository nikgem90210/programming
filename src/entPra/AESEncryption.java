package entPra;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESEncryption {

	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	
	public static String encrypt(String Data) throws Exception  {
		Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGO);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = cipher.doFinal(Data.getBytes());
		String encrytedValue = new BASE64Encoder().encode(encVal);
		return encrytedValue;
		
	}

	 public static String decrypt(String encryptedData) throws Exception {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
	        byte[] decValue = c.doFinal(decordedValue);
	        String decryptedValue = new String(decValue);
	        return decryptedValue;
	    }
	 
	private static Key generateKey() {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
	
	public static class Checker {

	    public static void main(String[] args) throws Exception {

	        String password = "mypassword";
	        String passwordEnc = AESEncryption.encrypt(password);
	        String passwordDec = AESEncryption.decrypt(passwordEnc);

	        System.out.println("Plain Text : " + password);
	        System.out.println("Encrypted Text : " + passwordEnc);
	        System.out.println("Decrypted Text : " + passwordDec);
	    }
	}
}
