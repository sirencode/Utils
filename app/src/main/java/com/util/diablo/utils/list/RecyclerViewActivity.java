package com.util.diablo.utils.list;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.util.diablo.utils.R;
import com.util.diablo.utils.list.multiple.MultipleItemFragment;

/**
 * @author shenyonghe
 */
public class RecyclerViewActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MultipleItemFragment())
                .commit();
    }

}
