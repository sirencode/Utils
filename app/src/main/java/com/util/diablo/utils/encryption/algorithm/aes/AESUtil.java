package com.util.diablo.utils.encryption.algorithm.aes;

import com.util.diablo.utils.encryption.algorithm.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Diablo on 2016/12/22.
 */

public class AESUtil {

    //一定要16个字符
    public static final String AESPASSWORD = "1234567812345678";

    private static final String IV_STRING = "16-Bytes--String";

    public static String encrypt(String content, String key) {

        try {
            byte[] byteContent = content.getBytes("UTF-8");

            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");

            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(byteContent);

            return Base64Utils.encode(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "加密错误";
    }

    public static String decrypt(String content, String key) {

        try {
            byte[] encryptedBytes = Base64Utils.decode(content);

            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");

            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            byte[] result = cipher.doFinal(encryptedBytes);

            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "解密错误";
    }

}
