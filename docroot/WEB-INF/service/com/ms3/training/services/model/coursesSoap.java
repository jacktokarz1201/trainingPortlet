/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ms3.training.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ms3.training.services.service.http.coursesServiceSoap}.
 *
 * @author John
 * @see com.ms3.training.services.service.http.coursesServiceSoap
 * @generated
 */
public class coursesSoap implements Serializable {
	public static coursesSoap toSoapModel(courses model) {
		coursesSoap soapModel = new coursesSoap();

		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setListPrice(model.getListPrice());
		soapModel.setProvider(model.getProvider());
		soapModel.setCourseId(model.getCourseId());

		return soapModel;
	}

	public static coursesSoap[] toSoapModels(courses[] models) {
		coursesSoap[] soapModels = new coursesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static coursesSoap[][] toSoapModels(courses[][] models) {
		coursesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new coursesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new coursesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static coursesSoap[] toSoapModels(List<courses> models) {
		List<coursesSoap> soapModels = new ArrayList<coursesSoap>(models.size());

		for (courses model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new coursesSoap[soapModels.size()]);
	}

	public coursesSoap() {
	}

	public String getPrimaryKey() {
		return _title;
	}

	public void setPrimaryKey(String pk) {
		setTitle(pk);
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getListPrice() {
		return _listPrice;
	}

	public void setListPrice(String listPrice) {
		_listPrice = listPrice;
	}

	public String getProvider() {
		return _provider;
	}

	public void setProvider(String provider) {
		_provider = provider;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	private String _title;
	private String _description;
	private String _listPrice;
	private String _provider;
	private long _courseId;
}