package encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.common.hash.Hashing;

public class Utils {

    /**
     * SHA-512 generates a 512-bit hash value.
     * 
     * @param passwordToHash
     * @param salt
     * @return
     */
    private static String getSHA512SecurePassword(String passwordToHash, String salt) {
        return getSHASecurePassword("SHA-512", passwordToHash, salt);
    }

    /**
     * SHA-384 generates a 384-bit hash value.
     * 
     * @param passwordToHash
     * @param salt
     * @return
     */
    private static String getSHA384SecurePassword(String passwordToHash, String salt) {
        return getSHASecurePassword("SHA-384", passwordToHash, salt);
    }

    /**
     * SHA-256 generates a 256-bit hash value.
     * 
     * @param passwordToHash
     * @param salt
     * @return
     */
    private static String getSHA256SecurePassword(String passwordToHash, String salt) {
        return getSHASecurePassword("SHA-256", passwordToHash, salt);
    }

    /**
     * SHA-224 generates a 224-bit hash value.
     * 
     * @param passwordToHash
     * @param salt
     * @return
     */
    private static String getSHA224SecurePassword(String passwordToHash, String salt) {
        return getSHASecurePassword("SHA-224", passwordToHash, salt);
    }

    /**
     * SHA-1 generates a 160-bit hash value.
     * 
     * @param passwordToHash
     * @param salt
     * @return
     */
    private static String getSHA1SecurePassword(String passwordToHash, String salt) {
        return getSHASecurePassword("SHA-1", passwordToHash, salt);
    }

    private static String getSHASecurePassword(String algorithm, String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            System.out.println(bytes.length);
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(byte2Hex(aByte));
            }
            generatedPassword = sb.toString();
            System.out.println(sb.length());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String byte2Hex(byte aByte) {
        return Integer.toString((aByte & 0xff) + 0x100, 16).substring(1);
    }

    public static String md5(String salt, String password) {
        return Hashing.md5().hashString(salt + password, Charset.forName("utf8")).toString();
    }

    public static void main(String[] args) {
        String passwd = "1234qwe";
        String salt = "psfrx9rENJ1Xw3gt";
        System.out.println(getSHA512SecurePassword(passwd, salt));
        System.out.println(getSHA384SecurePassword(passwd, salt));
        System.out.println(getSHA256SecurePassword(passwd, salt));
        System.out.println(getSHA224SecurePassword(passwd, salt));
        System.out.println(getSHA1SecurePassword(passwd, salt));
        String md5 = md5(salt, passwd);
        System.out.println(md5);
        System.out.println("68434338a89231f67913a23ff50ff5a5".equals(md5));
    }

}
