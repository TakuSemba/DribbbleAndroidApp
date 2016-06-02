package com.takusemba.dribbblesampleapp.screen;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.takusemba.dribbblesampleapp.R;
import com.takusemba.dribbblesampleapp.model.Shot;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by takusemba on 15/11/09.
 */
public class DetailActivity extends AppCompatActivity {

	static final String SHOT = "shot";

	static final String SHARED_ELEMENT = "shared_element";

	private Shot mShot;

	private ImageView mImageView;

	private CircleImageView mAvatar;

	private TextView mTitle;

	private TextView mDescription;

	private TextView mName;

	private TextView mFollower;

	private TextView mFollowing;

	private TextView mShotsCount;

	private TextView mLikesCount;

	private TextView mCommentsCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		if (getIntent().getExtras().containsKey(SHOT)) {
			mShot = (Shot) getIntent().getExtras().getSerializable(SHOT);
		}
		bindViews();
		setTextViews();
		setImageViews();
		setTransition();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private void setTransition() {
		mImageView.setTransitionName(SHARED_ELEMENT);
	}

	private void bindViews() {
		mImageView = (ImageView) findViewById(R.id.detail_image);
		mAvatar = (CircleImageView) findViewById(R.id.avatar);
		mTitle = (TextView) findViewById(R.id.title);
		mDescription = (TextView) findViewById(R.id.description);
		mName = (TextView) findViewById(R.id.name);
		mFollower = (TextView) findViewById(R.id.follower);
		mFollowing = (TextView) findViewById(R.id.following);
		mShotsCount = (TextView) findViewById(R.id.shots_count);
		mLikesCount = (TextView) findViewById(R.id.likes_received_count);
		mCommentsCount = (TextView) findViewById(R.id.comments_received_count);
	}

	private void setTextViews() {
		if (mShot != null) {
			mTitle.setText(mShot.getTitle());
			mDescription.setText(mShot.getDescription());
			if (mShot.getArtist() != null) {
				mName.setText(mShot.getArtist().getName());
				mFollower.setText(String.valueOf(mShot.getArtist().getFollowersCount()));
				mFollowing.setText(String.valueOf(mShot.getArtist().getFollowingsCount()));
				mShotsCount.setText(String.valueOf(mShot.getArtist().getLikesReceivedCount()));
				mLikesCount.setText(String.valueOf(mShot.getArtist().getLikesReceivedCount()));
				mCommentsCount.setText(String.valueOf(mShot.getArtist().getCommentsReceivedCount()));
			}
		}
	}

	public void setImageViews() {
		if (mShot != null && mShot.getImage() != null && mShot.getImage().getNormal() != null) {
			Picasso.with(this)
					.load(mShot.getImage().getNormal())
					.into(mImageView);
		}
		if (mShot != null && mShot.getArtist() != null && mShot.getArtist().getAvatarUrl() != null) {
			Picasso.with(this)
					.load(mShot.getArtist().getAvatarUrl())
					.into(mAvatar);
		}
	}
}
