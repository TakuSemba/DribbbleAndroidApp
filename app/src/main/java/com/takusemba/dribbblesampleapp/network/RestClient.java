package com.takusemba.dribbblesampleapp.network;

import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


public class RestClient {

	private static final String TAG = RestClient.class.getSimpleName();

	public static RestAdapter getRestAdapter() {
		return new RestAdapter.Builder()
				.setEndpoint("https://api.dribbble.com/v1/")
				.setConverter(new GsonConverter(new Gson()))
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.build();
	}
}