package org.projet6.escalade.webapp.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashedPassword {
    public static String getHashedPassword(String originalPassword) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalPassword.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
}
