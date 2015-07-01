package com.allancaine.inputtest;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class InputTestActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_test);
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new PageSwipeAdapter(getSupportFragmentManager(),
                new ResourceFinder()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class PageSwipeAdapter extends FragmentStatePagerAdapter{

        private ResourceFinder mResourceFinder;

        public PageSwipeAdapter(FragmentManager fm, ResourceFinder resourceFinder) {
            super(fm);
            mResourceFinder = resourceFinder;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(mResourceFinder.getResource(position));
        }

        @Override
        public int getCount() {
            return mResourceFinder.size();
        }
    }
}
