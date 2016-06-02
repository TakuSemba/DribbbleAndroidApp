package com.takusemba.dribbblesampleapp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.takusemba.dribbblesampleapp.network.ShotApi;
import com.takusemba.dribbblesampleapp.screen.DesignGridFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takusemba on 15/11/09.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private static final String TAG = SectionsPagerAdapter.class.getSimpleName();
	private static final String SECTION_NUMBER = "section_number";
	private final List<Fragment> mFragments = new ArrayList<>();

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
		for (int i = 0; i < getCount(); i++) {
			mFragments.add(new DesignGridFragment());
		}

	}

	@Override
	public Fragment getItem(int position) {
		Bundle args = new Bundle();
		args.putInt(SECTION_NUMBER, position);
		Fragment fragment = mFragments.get(position);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return ShotApi.Type.ANIMATED.getKey();
			case 1:
				return ShotApi.Type.ATTACHMENTS.getKey();
			case 2:
				return ShotApi.Type.DEBUTS.getKey();
			case 3:
				return ShotApi.Type.PLAYOFFS.getKey();
			case 4:
				return ShotApi.Type.REBOUNDS.getKey();
			case 5:
				return ShotApi.Type.TEAMS.getKey();
		}
		return null;
	}

}