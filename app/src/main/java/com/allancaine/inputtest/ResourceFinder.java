package com.allancaine.inputtest;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by allancaine on 2015-07-01.
 */
public class ResourceFinder {

    private ArrayList<Page> mPageResources;
    private Context mContext;
    private static ResourceFinder sResourceFinder;

    public static ResourceFinder get(Context context){
        if(sResourceFinder == null){
            sResourceFinder = new ResourceFinder(context);
        }
        return sResourceFinder;
    }

    private ResourceFinder(Context c){
        mContext = c.getApplicationContext();

        mPageResources = new ArrayList<>();
        mPageResources.add(new Page(mContext.getString(R.string.basic_input_title),
                R.layout.basic_input_layout));
        mPageResources.add(new Page(mContext.getString(R.string.password_input_title),
                R.layout.password_input_layout));
        mPageResources.add(new Page(mContext.getString(R.string.date_time_phone_title),
                R.layout.date_time_phone_layout));
    }

    public Page getResource(int position){
        return mPageResources.get(position);
    }

    public ArrayList<Page> getPageResources(){
        return mPageResources;
    }

    public int size(){
        return mPageResources.size();
    }
}
