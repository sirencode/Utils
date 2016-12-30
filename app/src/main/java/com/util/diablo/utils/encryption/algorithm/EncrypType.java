package com.util.diablo.utils.encryption.algorithm;

/**
 * Created by Diablo on 2016/12/22.
 */

public enum EncrypType {
    //des加密
    AESTYPE(1),
    //rsa加密
    RSATYPE(0);
    private int value = 0;

    private EncrypType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
