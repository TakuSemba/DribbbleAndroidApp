package com.takusemba.dribbblesampleapp.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.takusemba.dribbblesampleapp.R;
import com.takusemba.dribbblesampleapp.model.Shot;
import com.takusemba.dribbblesampleapp.screen.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takusemba on 15/11/09.
 */
public class GridRecycleViewAdapter extends RecyclerView.Adapter<GridRecycleViewAdapter.ViewHolder> {

	static final String SHOT = "shot";

	static final String SHARED_ELEMENT = "shared_element";

	private final LayoutInflater mInflater;
	private List<Shot> mShots;
	private Context mContext;

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageview;

		public ViewHolder(View v) {
			super(v);
			imageview = (ImageView) v.findViewById(R.id.item_image);
		}
	}

	public GridRecycleViewAdapter(Context context) {
		mShots = new ArrayList<>();
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void setShots(List<Shot> shots) {
		mShots.clear();
		for (Shot shot : shots) {
			mShots.add(shot);
		}
		this.notifyDataSetChanged();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View v = mInflater.inflate(R.layout.item_image, viewGroup, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		final Shot shot = mShots.get(position);
		if (!TextUtils.isEmpty(shot.getImage().getNormal())) {
			loadImage(shot.getImage().getNormal(), holder);
		} else if (!TextUtils.isEmpty(shot.getImage().getTeaser())) {
			loadImage(shot.getImage().getTeaser(), holder);
		}
		holder.imageview.setOnClickListener(new View.OnClickListener() {
			@TargetApi(Build.VERSION_CODES.LOLLIPOP)
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(mContext, DetailActivity.class);
				intent.putExtra(SHOT, shot);
				ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, holder.imageview, SHARED_ELEMENT);
				mContext.startActivity(intent, options.toBundle());
			}
		});
	}

	@Override
	public int getItemCount() {
		if (mShots != null) {
			return mShots.size();
		} else {
			return 0;
		}
	}

	public void loadImage(String image, ViewHolder holder) {
		Picasso.with(mContext)
				.load(image)
				.into(holder.imageview);
	}
}
