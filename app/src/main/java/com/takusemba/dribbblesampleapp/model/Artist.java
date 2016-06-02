package com.takusemba.dribbblesampleapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by takusemba on 15/11/09.
 */
public class Artist implements Serializable {

	private static final String TAG = Shot.class.getSimpleName();

	private int id;

	private String name;

	@SerializedName("avatar_url")
	private String avatarUrl;

	private String location;

	@SerializedName("followers_count")
	private int followersCount;

	@SerializedName("followings_count")
	private int followingsCount;

	@SerializedName("comments_received_count")
	private int commentsReceivedCount;

	@SerializedName("likes_received_count")
	private int likesReceivedCount;

	@SerializedName("shots_count")
	private int shotsCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFollowingsCount() {
		return followingsCount;
	}

	public void setFollowingsCount(int followingsCount) {
		this.followingsCount = followingsCount;
	}

	public int getCommentsReceivedCount() {
		return commentsReceivedCount;
	}

	public void setCommentsReceivedCount(int commentsReceivedCount) {
		this.commentsReceivedCount = commentsReceivedCount;
	}

	public int getLikesReceivedCount() {
		return likesReceivedCount;
	}

	public void setLikesReceivedCount(int likesReceivedCount) {
		this.likesReceivedCount = likesReceivedCount;
	}

	public int getShotsCount() {
		return shotsCount;
	}

	public void setShotsCount(int shotsCount) {
		this.shotsCount = shotsCount;
	}
}
