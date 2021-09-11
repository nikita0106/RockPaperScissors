import org.apache.commons.codec.binary.Hex;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class HmacGenerator  {


    public static String getHmacAlgo(String message, SecureRandom secureRandom) throws Exception {
        String key = getKey(secureRandom);

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.ISO_8859_1), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes(StandardCharsets.ISO_8859_1)));

    }

    public static String getKey(SecureRandom secureRandom) {
        byte[] bytes = new byte[20];
        secureRandom.nextBytes(bytes);
        return Hex.encodeHexString(bytes);
    }




}
