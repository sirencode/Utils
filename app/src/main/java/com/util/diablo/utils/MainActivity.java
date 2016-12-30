package com.util.diablo.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.util.diablo.utils.encryption.EncodeActivity;
import com.util.diablo.utils.list.RecyclerViewActivity;

/**
 * Created by Diablo on 2016/12/30.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private Button encode;
    private Button list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        encode = (Button) findViewById(R.id.encode);
        encode.setOnClickListener(this);
        list = (Button) findViewById(R.id.list);
        list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(encode)) {
            startActivity(new Intent(MainActivity.this, EncodeActivity.class));
        } else if (v.equals(list)) {
            startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
        }
    }
}
