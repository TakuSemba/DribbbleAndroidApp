package com.takusemba.dribbblesampleapp.network;


import com.takusemba.dribbblesampleapp.model.Shot;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by takusemba on 15/11/09.
 */
public interface ShotApi {

	String ACCESS_TOKEN = "67f7f46ae24ee28dac71ee61f97f2fb665f31fca2f9c4ff0dac49836011b3a32";

	@GET("/shots/?access_token=" + ACCESS_TOKEN + "&per_page=24")
	void fetchShots(@Query("list") String type, @Query("page") int page, Callback<List<Shot>> callback);

	enum Type {
		ANIMATED("animated"),
		ATTACHMENTS("attachments"),
		DEBUTS("debuts"),
		PLAYOFFS("playoffs"),
		REBOUNDS("rebounds"),
		TEAMS("teams");

		String key;

		Type(String key) {
			this.key = key;
		}

		public String getKey() {
			return key;
		}
	}

}
