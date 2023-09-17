package com.cspiration.mooc.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cspiration.mooc.entity.RSA256Key;
import com.cspiration.mooc.exception.ConditonException;
import com.sun.org.apache.xml.internal.security.algorithms.Algorithm;
import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class TokenUtils {
    private static final String ISSUER = "签发者";
    public  static String generateToken(Long userId) throws NoSuchAlgorithmException {
        RSA256Key rsa256Key = SecretKeyUtil.generateRSA256Key();

        com.auth0.jwt.algorithms.Algorithm algorithm = com.auth0.jwt.algorithms.Algorithm.RSA256(rsa256Key.getPublicKey(),rsa256Key.getPrivateKey());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND,20);
        return JWT.create().withKeyId(String.valueOf(userId))
                .withIssuer(ISSUER)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }
    public static Long verifyToken(String token) throws NoSuchAlgorithmException {
        try{
        RSA256Key rsa256Key = SecretKeyUtil.generateRSA256Key();
        com.auth0.jwt.algorithms.Algorithm algorithm = com.auth0.jwt.algorithms.Algorithm.RSA256(rsa256Key.getPublicKey(),rsa256Key.getPrivateKey());

        JWTVerifier verifer = JWT.require(algorithm).build();
        DecodedJWT jwt = verifer.verify(token);
        String userId = jwt.getKeyId();
        return Long.valueOf(userId);
        } catch (TokenExpiredException e){
            throw new ConditonException("555","token过期！");
        } catch (Exception e){
            throw new ConditonException("非法用户token");
        }
    }
}
