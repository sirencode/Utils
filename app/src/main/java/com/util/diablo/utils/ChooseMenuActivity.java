package com.util.diablo.utils;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Diablo on 2016/12/29.
 */

public class ChooseMenuActivity extends Activity {
    private ImageView imageView;
    private Button start;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_menu);
        imageView = (ImageView) findViewById(R.id.image);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable == null) {
                    imageView.setImageResource(R.drawable.anim_list);
                    animationDrawable = (AnimationDrawable) imageView.getDrawable();
                }

                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                } else {
                    animationDrawable.start();
                }
            }
        });
    }
}
