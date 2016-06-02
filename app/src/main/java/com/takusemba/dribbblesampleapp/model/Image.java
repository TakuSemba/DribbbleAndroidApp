package com.takusemba.dribbblesampleapp.model;

import java.io.Serializable;

/**
 * Created by takusemba on 15/11/09.
 */
public class Image implements Serializable {

	private String hidpi;

	private String normal;

	private String teaser;

	public String getHidpi() {
		return hidpi;
	}

	public void setHidpi(String hidpi) {
		this.hidpi = hidpi;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}
}
