package com.util.diablo.utils.encryption.algorithm.rsa;

import android.content.Context;
import com.util.diablo.utils.encryption.algorithm.Base64Utils;

import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by Diablo on 2016/12/22.
 */

public class RSATest {
    public static String encode(String source, Context context) {
        try {
            // 从字符串中得到公钥
            // PublicKey publicKey = RSAUtils.loadPublicKey(PUCLIC_KEY);
            // 从文件中得到公钥
            InputStream inPublic = context.getResources().getAssets().open("rsa_java_public_key.pem");
            PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);
            // 加密
            byte[] encryptByte = RSAUtils.encryptData(source.getBytes(), publicKey);
            // 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
            String afterencrypt = Base64Utils.encode(encryptByte);
            return afterencrypt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "加密失败";
    }

    public static String decode(String encryptContent, Context context) {
        try {
            // 从字符串中得到私钥
            // PrivateKey privateKey = RSAUtils.loadPrivateKey(PRIVATE_KEY);
            // 从文件中得到私钥
            InputStream inPrivate = context.getResources().getAssets().open("rsa_java_private_key.pem");
            PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);
            // 因为RSA加密后的内容经Base64再加密转换了一下，所以先Base64解密回来再给RSA解密
            byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(encryptContent), privateKey);
            String decryptStr = new String(decryptByte);
            return decryptStr;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "解密失败";
    }
}
