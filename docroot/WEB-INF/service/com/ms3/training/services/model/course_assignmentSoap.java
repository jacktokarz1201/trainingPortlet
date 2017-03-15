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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ms3.training.services.service.http.course_assignmentServiceSoap}.
 *
 * @author John
 * @see com.ms3.training.services.service.http.course_assignmentServiceSoap
 * @generated
 */
public class course_assignmentSoap implements Serializable {
	public static course_assignmentSoap toSoapModel(course_assignment model) {
		course_assignmentSoap soapModel = new course_assignmentSoap();

		soapModel.setCourses_title(model.getCourses_title());
		soapModel.setMs3employeedb_uid(model.getMs3employeedb_uid());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setNotes(model.getNotes());
		soapModel.setCost(model.getCost());
		soapModel.setCertification(model.getCertification());
		soapModel.setAssignmentId(model.getAssignmentId());

		return soapModel;
	}

	public static course_assignmentSoap[] toSoapModels(
		course_assignment[] models) {
		course_assignmentSoap[] soapModels = new course_assignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static course_assignmentSoap[][] toSoapModels(
		course_assignment[][] models) {
		course_assignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new course_assignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new course_assignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static course_assignmentSoap[] toSoapModels(
		List<course_assignment> models) {
		List<course_assignmentSoap> soapModels = new ArrayList<course_assignmentSoap>(models.size());

		for (course_assignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new course_assignmentSoap[soapModels.size()]);
	}

	public course_assignmentSoap() {
	}

	public long getPrimaryKey() {
		return _assignmentId;
	}

	public void setPrimaryKey(long pk) {
		setAssignmentId(pk);
	}

	public String getCourses_title() {
		return _courses_title;
	}

	public void setCourses_title(String courses_title) {
		_courses_title = courses_title;
	}

	public String getMs3employeedb_uid() {
		return _ms3employeedb_uid;
	}

	public void setMs3employeedb_uid(String ms3employeedb_uid) {
		_ms3employeedb_uid = ms3employeedb_uid;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public String getCost() {
		return _cost;
	}

	public void setCost(String cost) {
		_cost = cost;
	}

	public boolean getCertification() {
		return _certification;
	}

	public boolean isCertification() {
		return _certification;
	}

	public void setCertification(boolean certification) {
		_certification = certification;
	}

	public long getAssignmentId() {
		return _assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		_assignmentId = assignmentId;
	}

	private String _courses_title;
	private String _ms3employeedb_uid;
	private Date _startDate;
	private Date _endDate;
	private String _notes;
	private String _cost;
	private boolean _certification;
	private long _assignmentId;
}