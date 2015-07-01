package com.allancaine.inputtest;

/**
 * Created by allancaine on 2015-07-01.
 */
public class Page {

    private final String mResourceTitle;
    private final int mLayout;

    public Page(String resourceTitle, int layout) {
        mResourceTitle = resourceTitle;
        mLayout = layout;
    }

    public String getResourceTitle() {
        return mResourceTitle;
    }

    public int getLayout() {
        return mLayout;
    }

    @Override
    public String toString() {
        return mResourceTitle;
    }
}
