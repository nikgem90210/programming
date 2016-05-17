package entPra;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import sun.misc.BASE64Encoder;


public class Decryption {
	
	private static String algorithmRC4 = "RC4";
	private static String algorithmMD5 = "MD5";
	private static String MSISDN ="919910050396";
	private static String key = "wdTDoh8YxYcd3p";
	private static String encryptedMsisdn = "RSImEyaDWkbXgJng";

	public static void main(String[] args) throws Exception {
		
		try {
    		byte[] byteOfKey = key.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance(algorithmMD5);
			byte[] MD5OfKey = messageDigest.digest(byteOfKey);
			
			String hexString = Hex.encodeHexString(MD5OfKey);
			
			String encrypt = encrypt(MSISDN,hexString);
			
			String decodedEncString = new Base64().base64Decode(encrypt);
			
			String decrypt = decrypt(decodedEncString.getBytes(), hexString);
			
			System.out.println(hexString);
			
//			String hexString1 = Hex.encodeHexString(encrypt);
			
//			System.out.println("encrypt" +encrypt.toString());
//			
//			System.out.println("decrypt" +decrypt.toString());
			
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
		
	public static String encrypt(String toEncrypt, String key) throws Exception {
	      // create a binary key from the argument key (seed)
	      SecureRandom sr = new SecureRandom(key.getBytes());
	      KeyGenerator kg = KeyGenerator.getInstance(algorithmRC4);
	      kg.init(sr);
	      SecretKey sk = kg.generateKey();
	      
	      // create an instance of cipher
	      Cipher cipher = Cipher.getInstance(algorithmRC4);
	  
	      // initialize the cipher with the key
	      cipher.init(Cipher.ENCRYPT_MODE, sk);
	  
	      // enctypt!
	      byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
	      String encrytedValue = new BASE64Encoder().encode(encrypted);
	  
	      return encrytedValue;
	      
	   }
	
	public static String decrypt(byte[] toDecrypt, String key) throws Exception {
	      // create a binary key from the argument key (seed)
	      SecureRandom sr = new SecureRandom(key.getBytes());
	      KeyGenerator kg = KeyGenerator.getInstance(algorithmRC4);
	      kg.init(sr);
	      SecretKey sk = kg.generateKey();
	  
	      // do the decryption with that key
	      Cipher cipher = Cipher.getInstance(algorithmRC4);
	      cipher.init(Cipher.DECRYPT_MODE, sk);
	      byte[] decrypted = cipher.doFinal(toDecrypt);
	  
	      return new String(decrypted);
	   }
	
	
	
	
}





