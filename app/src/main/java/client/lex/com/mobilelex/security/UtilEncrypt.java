package client.lex.com.mobilelex.security;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.sun.jersey.core.util.Base64;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import client.lex.com.mobilelex.domain.Constante;

import static android.content.ContentValues.TAG;

public class UtilEncrypt {
    protected static final String KEY_FACTORY_ALGORITHM = "RSA";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getEncryptCipher(String clave) {
        try {
            /* Plain text */
            String encText = clave;
            /* Encrypted bytes */
            byte[] encrypted = null;
            /* Get cipher */

            //Cipher cipher = cipher

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static PublicKey generatePublicKey(String encodedPublicKey){
        try {
            byte[] decodedKey=Base64.decode(encodedPublicKey);
            KeyFactory keyFactory=KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
            return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
        }
        catch (  NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        catch (  InvalidKeySpecException e) {
            Log.e(TAG,"Invalid key specification.");
            throw new IllegalArgumentException(e);
        }
        catch (  Exception e) {
            Log.e(TAG,"Base64 decoding failed.");
            throw new IllegalArgumentException(e);
        }
    }

}
