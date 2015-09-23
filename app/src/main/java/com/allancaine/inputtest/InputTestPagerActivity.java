package com.allancaine.inputtest;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class InputTestPagerActivity extends FragmentActivity {

    public static final String EXTRA_POSITION = "com.allancaine.inputtest.extra_position";


    private PageSwipeAdapter mPageSwipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_test);
        mPageSwipeAdapter = new PageSwipeAdapter(getSupportFragmentManager(), ResourceFinder.get(this));
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(mPageSwipeAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSubtitle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Intent i = getIntent();
        int position = i.getIntExtra(EXTRA_POSITION, 0);
        viewPager.setCurrentItem(position);
        setSubtitle(position);

    }

    private void setSubtitle(int position){
        ResourceFinder resourceFinder = ResourceFinder.get(this);
        String subtitle = resourceFinder.getResource(position).getResourceTitle();
        ActionBar actionBar = getActionBar();
        actionBar.setSubtitle(subtitle);
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
            return PageFragment.newInstance(mResourceFinder.getResource(position).getLayout());
        }

        @Override
        public int getCount() {
            return mResourceFinder.size();
        }
    }
}
