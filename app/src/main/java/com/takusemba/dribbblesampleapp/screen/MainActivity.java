package com.takusemba.dribbblesampleapp.screen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.takusemba.dribbblesampleapp.R;
import com.takusemba.dribbblesampleapp.adapter.SectionsPagerAdapter;

/**
 * Created by takusemba on 15/11/09.
 */
public class MainActivity extends AppCompatActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;

    ViewPager mViewPager;

	TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	    setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.pager);
	    mTabLayout = (TabLayout) findViewById(R.id.tabs);

	    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(mSectionsPagerAdapter.getCount());
	    mTabLayout.setupWithViewPager(mViewPager);

    }
}
