package com.example.cento.wineyardapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bof.navigationdrawerwineyard.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flavien on 19/04/17.
 */

public class FragLocation extends Fragment{

    private View view;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        if (view != null)
            initiateTabs(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_location, container, false);

        initiateTabs(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initiateTabs(view);
    }

    private void initiateTabs(View view){

        toolbar = (Toolbar) view.findViewById(R.id.toolbarAppBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter =
                new ViewPagerAdapter(((AppCompatActivity)getActivity()).getSupportFragmentManager());

        adapter.addFragment(new FragLocationList(), "List");
        adapter.addFragment(new FragLocationMap(), "Map");
        viewPager.setAdapter(adapter);
    }

    //Class used to create a custom adapter for the viewPager
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
