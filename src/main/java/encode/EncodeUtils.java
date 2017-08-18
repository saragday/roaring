package encode;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncodeUtils {

    private static String encodeBase64(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    public static byte[] decodeBase64(String s) {
        try {
            return new BASE64Decoder().decodeBuffer(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // "Basic" + " " + Base64Encode(appKey + ":" + appSecret)
        String appKey = "VxwKC4FtWvTPzK63l3y9o9d3vHYhwjpZ";
        String appSecret = "8vymXxOl3OXaZFd1FfmEtOOrNHwuF3Sf";
        String toEncodeStr = appKey + ":" + appSecret;
        String val = "Basic" + " " + encodeBase64(toEncodeStr.getBytes());
        System.out.println(val);
        System.out.println(Integer.MIN_VALUE);
        int abs = Math.abs(Integer.MIN_VALUE);
        System.out.println(abs % 10);
    }

}
