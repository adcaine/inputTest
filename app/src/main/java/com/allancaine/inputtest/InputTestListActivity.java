package com.allancaine.inputtest;

import android.support.v4.app.Fragment;

/**
 * Created by allancaine on 2015-07-01.
 */
public class InputTestListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new InputTestListFragment();
    }
}
