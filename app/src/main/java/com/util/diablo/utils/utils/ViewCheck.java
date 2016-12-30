package com.util.diablo.utils.utils;

import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by Diablo on 2016/12/10.
 */

public class ViewCheck {

    public void setTextViewText(TextView textView, String text) {
           if (textView != null && !TextUtils.isEmpty(text)){
               textView.setText(text);
           }
    }
}
