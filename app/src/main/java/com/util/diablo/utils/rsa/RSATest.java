package com.util.diablo.utils.rsa;

import android.content.Context;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by Diablo on 2016/12/20.
 */

public class RSATest {

    /* 密钥内容 base64 code */
    private static String PUCLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1m9+pRtnyJ86YWGg7HYn2Mag2" + "\r" +
            "eB/KCsOj3LoZj/tAWg+90/pMAcSLlx3szyD4ZHr5bvyYAOgz8g/siTApJt5h/K9F" + "\r" +
            "AazvMpXvKpdkA59zFk1MCD9cNA+jJMGYXqDFf3iguiSACP4kGVn7AzI/pTOY3BNl" + "\r" +
            "5J7ApX5IgjxQjHhfxwIDAQAB" + "\r";
    private static String PRIVATE_KEY = "MIICXAIBAAKBgQC1m9+pRtnyJ86YWGg7HYn2Mag2eB/KCsOj3LoZj/tAWg+90/pM" + "\r" +
            "AcSLlx3szyD4ZHr5bvyYAOgz8g/siTApJt5h/K9FAazvMpXvKpdkA59zFk1MCD9c" + "\r" +
            "NA+jJMGYXqDFf3iguiSACP4kGVn7AzI/pTOY3BNl5J7ApX5IgjxQjHhfxwIDAQAB" + "\r" +
            "AoGAV6+CJz5hXu1fb+lHsjtJ8If7WwlW9/uIiKa7aDo/qsuRTCt8b5Ru7KMzPLKp" + "\r" +
            "jaUeRy8SYOYXN3WJwMBgc44j0sWpOFIOkZxM5BjxvcJk/kYQVOYBQNdmfgUbud+4" + "\r" +
            "jJ1n6GOIEgtTzbiW2gLxg3GJcK2KTpfhpCxB7ikL6EGCvakCQQDbikS/EQmZvTbF" + "\r" +
            "7RTf/84poHrFeJqRa+1yoXcEiKCFwhVY1BsgNf/0Ei8ScGbgV2B65/Ic5QPF7RUE" + "\r" +
            "5sddRJsdAkEA08T2M6amyQ1mnDK2mKShabJur7oGCHwrVNSqHTYycCA8uy9bZFZi" + "\r" +
            "OiHr2Z931tZ1TrU4XSJu8NCVvOQAuxENMwJAAjbZzKeKVj+fTs2+WSgGV0skEdvO" + "\r" +
            "i0rwYSiZv7T1EYRMnNG+2EtTIo4QZXo2v2qCMZsnSP1SVWu3u43sUtd/TQJBAKGi" + "\r" +
            "xmCqJMd0iQtT0fc0QVeRr9ZE4HH9hH1dTPK6+UiH8pLVFKbDIHpKheA3TZsXWbZX" + "\r" +
            "r8u2ioMYUhI43S3rV+0CQFERWBfUafzUiGKurPjLv4R5d1Hhw7KDmfkVgWh3A0cC" + "\r" +
            "36dGaytdqkxlMvzZPaYd/6K7P1kdMfyYSbKIg/Dm4Ug=" + "\r";

    public static String encodeInfo(String info, Context context) {
        try {
            // 从字符串中得到公钥
            //PublicKey publicKey = RSAUtils.loadPublicKey(PUCLIC_KEY);
            //从文件中得到公钥
            InputStream inPublic = context.getResources().getAssets().open("public_key.pem");
            PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);
            // 加密
            byte[] encryptByte = RSAUtils.encryptData(info.getBytes(), publicKey);
            // 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
            String afterencrypt = Base64Utils.encode(encryptByte);
            return afterencrypt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "加密失败";
    }

    public static String decodeInfo(String info, Context context) {
        try {
            // 从字符串中得到私钥
//            PrivateKey privateKey = RSAUtils.loadPrivateKey(PRIVATE_KEY);
            // 从文件中得到私钥
            InputStream inPrivate = context.getResources().getAssets().open("private_key.pem");
            PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);
            // 因为RSA加密后的内容经Base64再加密转换了一下，所以先Base64解密回来再给RSA解密
            byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(info), privateKey);
            String decryptStr = new String(decryptByte);
            return decryptStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "解密失败";
    }
}
