package user;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class PasswordHelper {
    private final SecureRandom secureRandom = new SecureRandom();
    private final byte[] salt = new byte[16];

    public byte[] generateSalt() {
        secureRandom.nextBytes(salt);
        return salt;
    }

    public byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        return factory.generateSecret(spec).getEncoded();
    }

    public boolean verifyPassword(String password, byte[] salt, byte[] hash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] hashToVerify = hashPassword(password, salt);
        if (hashToVerify.length != hash.length) {
            return false;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != hashToVerify[i]) {
                return false;
            }
        }
        return true;
    }
}
