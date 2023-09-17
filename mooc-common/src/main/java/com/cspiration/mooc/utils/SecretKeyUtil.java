package com.cspiration.mooc.utils;

import com.cspiration.mooc.entity.RSA256Key;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class SecretKeyUtil {
    public static final String KEY_ALGORITHM = "RSA";
    public static final int KEY_SIZE = 2048;
    public static volatile RSA256Key rsa256Key;
    public static RSA256Key generateRSA256Key() throws NoSuchAlgorithmException {
        if (rsa256Key == null){
            synchronized ((RSA256Key.class)){
                if(rsa256Key == null){
                    KeyPairGenerator keyPairGenerator =KeyPairGenerator.getInstance(KEY_ALGORITHM);
                    keyPairGenerator.initialize(KEY_SIZE);
                    KeyPair keyPair = keyPairGenerator.generateKeyPair();

                    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
                    RSAPrivateKey privateKey =(RSAPrivateKey) keyPair.getPrivate();
                    rsa256Key = new RSA256Key();
                    rsa256Key.setPrivateKey(privateKey);
                    rsa256Key.setPublicKey(publicKey);
                }
            }
        }
        return rsa256Key;
    }
}
