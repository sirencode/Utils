package com.util.diablo.utils.encryption;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.util.diablo.utils.R;
import com.util.diablo.utils.encryption.algorithm.EncrypType;
import com.util.diablo.utils.encryption.algorithm.aes.AESUtil;
import com.util.diablo.utils.encryption.algorithm.rsa.RSATest;

public class EncodeActivity extends Activity implements View.OnClickListener {

    private EditText input;
    private TextView content;
    private Button encode;
    private Button decode;
    private TextView type;
    private int encodeType = EncrypType.RSATYPE.getValue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        input = (EditText) findViewById(R.id.editText);
        content = (TextView) findViewById(R.id.tv_content);
        type = (TextView) findViewById(R.id.textView);
        encode = (Button) findViewById(R.id.btn_encode);
        decode = (Button) findViewById(R.id.btn_decode);
        encode.setOnClickListener(this);
        decode.setOnClickListener(this);
        //根据ID找到RadioGroup实例
        RadioGroup group = (RadioGroup) this.findViewById(R.id.radioGroup);
        //绑定一个匿名监听器
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                if (radioButtonId == R.id.radioAES){
                    encodeType = EncrypType.AESTYPE.getValue();
                }else {
                    encodeType = EncrypType.RSATYPE.getValue();
                }
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) EncodeActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                type.setText("加密方式：" + rb.getText());
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.equals(decode)) {
            setDecode(encodeType);
        } else if (view.equals(encode)) {
            setEncode(encodeType);
        }
    }

    //解密
    private void setDecode(int encrpType) {
        if (encrpType == EncrypType.RSATYPE.getValue()) {
            content.setText(RSATest.decode(content.getText().toString(), EncodeActivity.this));
        } else if (encrpType == EncrypType.AESTYPE.getValue()) {
            content.setText(AESUtil.decrypt(content.getText().toString(), AESUtil.AESPASSWORD).toString());
        }
    }

    //加密
    private void setEncode(int encrpType) {
        String encryptContent = input.getText().toString().trim();
        if (encrpType == EncrypType.RSATYPE.getValue()) {
            content.setText(RSATest.encode(encryptContent, EncodeActivity.this));
        } else if (encrpType == EncrypType.AESTYPE.getValue()) {
            content.setText(AESUtil.encrypt(encryptContent, AESUtil.AESPASSWORD).toString());
        }
    }
}
