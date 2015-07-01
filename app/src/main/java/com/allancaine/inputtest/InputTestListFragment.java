package com.allancaine.inputtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by allancaine on 2015-07-01.
 */
public class InputTestListFragment extends ListFragment {

    private ResourceFinder mResourceFinder;

    public InputTestListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResourceFinder = ResourceFinder.get(getActivity());
        ArrayAdapter<Page> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, mResourceFinder.getPageResources());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(getActivity(), InputTestPagerActivity.class);
        i.putExtra(InputTestPagerActivity.EXTRA_POSITION, position);
        startActivity(i);
    }
}
