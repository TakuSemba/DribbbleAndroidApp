package com.takusemba.dribbblesampleapp.model;

import android.text.Html;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Shot implements Serializable {

	private static final String TAG = Shot.class.getSimpleName();

	private int id;

	private String title;

	@SerializedName("likes_count")
	private int likesCount;

	@SerializedName("views_count")
	private int viewsCount;

	@SerializedName("comments_count")
	private int commentsCount;

	private String description;

	@SerializedName("images")
	private Image image;

	@SerializedName("user")
	private Artist artist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		if (description != null) {
			return String.valueOf(Html.fromHtml(description));
		} else {
			return "";
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public int getViewsCount() {
		return viewsCount;
	}

	public void setViewsCount(int viewsCount) {
		this.viewsCount = viewsCount;
	}

	public int getCommentCount() {
		return commentsCount;
	}

	public void setCommentCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}