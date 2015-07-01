package com.allancaine.inputtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by allancaine on 2015-07-01.
 */
public class PageFragment extends Fragment {

    public static final String ARG_LAYOUT_RESOURCE = "com.allancaine.inputtest.layout_resource";

    public static Fragment newInstance(int layoutResource){
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RESOURCE, layoutResource);
        Fragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int layoutResource = args.getInt(ARG_LAYOUT_RESOURCE);
        View v = inflater.inflate(layoutResource, container, false);
        return v;
    }
}
