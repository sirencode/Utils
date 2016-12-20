package com.util.diablo.utils;

import java.math.BigDecimal;

/**
 * Created by Diablo on 2016/12/10.
 */

public class BigDecimalUtile {

    public static float formateNumber(float number,int digit){
        BigDecimal   bd   =   new BigDecimal(number);
        return bd.setScale(digit, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
