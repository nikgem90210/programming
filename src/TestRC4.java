import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;


public class TestRC4 {

	public static String DecryptMsisdnWithMD5AndRC4(String EncMsisdn, String encryptionKey) {

		String RawText = "";
		byte[] keyArray = new byte[512];
		byte[] temporaryKey;
		String key = null;
		byte[] toEncryptArray = null;
		String methodName = "SDPUtils :: DecryptMsisdnWithMD5AndRC4: ";

		try {
		key = encryptionKey;
//		log.debug(methodName + " key from property : " + key);
		MessageDigest m = MessageDigest.getInstance("MD5");
		temporaryKey = m.digest(key.getBytes("UTF-8"));
		Cipher c = Cipher.getInstance("RC4");
		c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(temporaryKey, "RC4"));
		byte[] decrypted = c.doFinal(Base64.decodeBase64(EncMsisdn));

		RawText = new String(decrypted, "UTF-8");
//		log.debug(methodName + " Msisdn after decrypting : " + RawText);
//		log.info(methodName + " Encryted msisdn : " + EncMsisdn + " Dycrypted msisdn: " + RawText);
		} catch (Exception NoEx) {
//		log.error(methodName + "Exception occur= "+NoEx);
		//JOptionPane.showMessageDialog(null, NoEx);
		NoEx.printStackTrace(System.out);
		}

		return RawText;

		}

		// for x-radius-2

		public static String DecryptMsisdnWithRC4(String EncMsisdn, String encryptionKey) {

		String RawText = "";
		byte[] keyArray = new byte[256];
		byte[] temporaryKey;
		String key = null;
		byte[] toEncryptArray = null;
		String methodName = "SDPUtils :: DecryptMsisdnWithRC4: ";

		try {
		key = encryptionKey;
		keyArray = DatatypeConverter.parseHexBinary(EncMsisdn);
//		log.debug(methodName + " key from property : " + key);
		//MessageDigest m = MessageDigest.getInstance("MD5");
		//temporaryKey = m.digest(key.getBytes("UTF-8"));
		Cipher c = Cipher.getInstance("RC4");
		c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(encryptionKey.getBytes(), "RC4"));
		byte[] decrypted = c.doFinal(keyArray);
		RawText = new String(decrypted, "UTF-8");
//		log.debug(methodName + " Msisdn after decrypting : " + RawText);
//		log.info(methodName + " Encryted msisdn : " + EncMsisdn + " Dycrypted msisdn: " + RawText);
		} catch (Exception NoEx) {
//		log.error(methodName + "Exception occur= "+NoEx);
		//JOptionPane.showMessageDialog(null, NoEx);
		NoEx.printStackTrace(System.out);
		}

		return RawText;

		}
	
}
