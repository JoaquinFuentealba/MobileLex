package client.lex.com.mobilelex.security;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import client.lex.com.mobilelex.domain.Constante;

public class UtilEncrypt {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getEncryptCipher(String clave) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = getKeyGen(Constante.KEY.getBytes());


            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");

            cipher.init(Cipher.ENCRYPT_MODE, publicKey );

            byte[] encriptado = cipher.doFinal(clave.getBytes());
            return encriptado.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static PublicKey getKeyGen(byte[] publicK) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicBytes = Base64.getDecoder().decode(publicK);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
