package com.allancaine.inputtest;

import java.util.ArrayList;

/**
 * Created by allancaine on 2015-07-01.
 */
public class ResourceFinder {

    private ArrayList<Integer> mPageResources;

    public ResourceFinder(){
        mPageResources = new ArrayList<>();
        mPageResources.add(R.layout.basic_input_layout);
        mPageResources.add(R.layout.password_input_layout);
    }

    public int getResource(int position){
        return mPageResources.get(position);
    }

    public int size(){
        return mPageResources.size();
    }
}
