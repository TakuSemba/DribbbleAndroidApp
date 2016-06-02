package com.takusemba.dribbblesampleapp.screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.takusemba.dribbblesampleapp.R;
import com.takusemba.dribbblesampleapp.adapter.GridRecycleViewAdapter;
import com.takusemba.dribbblesampleapp.model.Shot;
import com.takusemba.dribbblesampleapp.network.RestClient;
import com.takusemba.dribbblesampleapp.network.ShotApi;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;
import java.util.Random;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by takusemba on 15/11/09.
 */
public class DesignGridFragment extends Fragment {

	private static final String TAG = DesignGridFragment.class.getSimpleName();

	private static final String SECTION_NUMBER = "section_number";

	private static final int COLUMNS = 3;

	private GridRecycleViewAdapter mGridRecycleViewAdapter;

	private AVLoadingIndicatorView mProgressBar;

	private RecyclerView mRecyclerView;

	private SwipeRefreshLayout mSwipeRefreshLayout;

	private int mNumber;

	public DesignGridFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mNumber = getArguments().getInt(SECTION_NUMBER);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_grid_design, container, false);

		bindViews(view);
		setRecycleView();
		setRefreshView();

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fetchShots(new Random().nextInt(10));
	}

	private void bindViews(View view) {
		mProgressBar = (AVLoadingIndicatorView) view.findViewById(R.id.loading_indicator);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
	}

	private void setRecycleView() {
		final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), COLUMNS);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mGridRecycleViewAdapter = new GridRecycleViewAdapter(getActivity());
		mRecyclerView.setAdapter(mGridRecycleViewAdapter);
		mRecyclerView.setHasFixedSize(true);
	}

	private void setRefreshView() {
		mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				fetchShots(new Random().nextInt(10));
			}
		});
	}

	private void fetchShots(int page) {

		ShotApi.Type type;
		switch (mNumber) {
			case 0:
				type = ShotApi.Type.ANIMATED;
				break;
			case 1:
				type = ShotApi.Type.ATTACHMENTS;
				break;
			case 2:
				type = ShotApi.Type.DEBUTS;
				break;
			case 3:
				type = ShotApi.Type.PLAYOFFS;
				break;
			case 4:
				type = ShotApi.Type.REBOUNDS;
				break;
			case 5:
				type = ShotApi.Type.TEAMS;
				break;
			default:
				type = ShotApi.Type.ANIMATED;
				break;
		}

		RestClient.getRestAdapter()
				.create(ShotApi.class)
				.fetchShots(type.getKey(), page, new Callback<List<Shot>>() {
					@Override
					public void success(List<Shot> shots, Response response) {
						if (isAdded() && !isDetached()) {
							mProgressBar.setVisibility(View.GONE);
							mGridRecycleViewAdapter.setShots(shots);
							mSwipeRefreshLayout.setRefreshing(false);
						}
					}

					@Override
					public void failure(RetrofitError error) {
						mProgressBar.setVisibility(View.GONE);
						mSwipeRefreshLayout.setRefreshing(false);
						Log.d("debug", "onError: " + error.getMessage());
					}
				});
	}
}