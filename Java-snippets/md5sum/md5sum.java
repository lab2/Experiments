import java.io.*;
import java.security.*;
import java.math.*;

public class md5sum {
	public static void main(String[] args) throws IOException,
			NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		InputStream is = null;
		try {
			File f = new File(args[0]);
			is = new FileInputStream(f);
			byte[] buffer = new byte[8192];
			int read = 0;
			while ((read = is.read(buffer)) > 0) {
				digest.update(buffer, 0, read);
			}
			byte[] md5sum = digest.digest();
			BigInteger bigInt = new BigInteger(1, md5sum);
			String output = bigInt.toString(16);
			System.out.println("\n" + output);
			is.close();
		} catch (Exception e) {
			System.out.println("\nUnable to process file for MD5");
		}
	}
}
