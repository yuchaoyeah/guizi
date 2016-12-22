package commons.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MathUtils {
	
	public static String MD5(String param) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(param.getBytes());
			return new BigInteger(1,md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
