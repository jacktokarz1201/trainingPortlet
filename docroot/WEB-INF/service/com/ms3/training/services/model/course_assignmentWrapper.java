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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link course_assignment}.
 * </p>
 *
 * @author John
 * @see course_assignment
 * @generated
 */
public class course_assignmentWrapper implements course_assignment,
	ModelWrapper<course_assignment> {
	public course_assignmentWrapper(course_assignment course_assignment) {
		_course_assignment = course_assignment;
	}

	@Override
	public Class<?> getModelClass() {
		return course_assignment.class;
	}

	@Override
	public String getModelClassName() {
		return course_assignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courses_title", getCourses_title());
		attributes.put("ms3employeedb_uid", getMs3employeedb_uid());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("notes", getNotes());
		attributes.put("cost", getCost());
		attributes.put("certification", getCertification());
		attributes.put("assignmentId", getAssignmentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String courses_title = (String)attributes.get("courses_title");

		if (courses_title != null) {
			setCourses_title(courses_title);
		}

		String ms3employeedb_uid = (String)attributes.get("ms3employeedb_uid");

		if (ms3employeedb_uid != null) {
			setMs3employeedb_uid(ms3employeedb_uid);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String cost = (String)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		Boolean certification = (Boolean)attributes.get("certification");

		if (certification != null) {
			setCertification(certification);
		}

		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
		}
	}

	/**
	* Returns the primary key of this course_assignment.
	*
	* @return the primary key of this course_assignment
	*/
	@Override
	public long getPrimaryKey() {
		return _course_assignment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course_assignment.
	*
	* @param primaryKey the primary key of this course_assignment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course_assignment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the courses_title of this course_assignment.
	*
	* @return the courses_title of this course_assignment
	*/
	@Override
	public java.lang.String getCourses_title() {
		return _course_assignment.getCourses_title();
	}

	/**
	* Sets the courses_title of this course_assignment.
	*
	* @param courses_title the courses_title of this course_assignment
	*/
	@Override
	public void setCourses_title(java.lang.String courses_title) {
		_course_assignment.setCourses_title(courses_title);
	}

	/**
	* Returns the ms3employeedb_uid of this course_assignment.
	*
	* @return the ms3employeedb_uid of this course_assignment
	*/
	@Override
	public java.lang.String getMs3employeedb_uid() {
		return _course_assignment.getMs3employeedb_uid();
	}

	/**
	* Sets the ms3employeedb_uid of this course_assignment.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid of this course_assignment
	*/
	@Override
	public void setMs3employeedb_uid(java.lang.String ms3employeedb_uid) {
		_course_assignment.setMs3employeedb_uid(ms3employeedb_uid);
	}

	/**
	* Returns the start date of this course_assignment.
	*
	* @return the start date of this course_assignment
	*/
	@Override
	public java.util.Date getStartDate() {
		return _course_assignment.getStartDate();
	}

	/**
	* Sets the start date of this course_assignment.
	*
	* @param startDate the start date of this course_assignment
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_course_assignment.setStartDate(startDate);
	}

	/**
	* Returns the end date of this course_assignment.
	*
	* @return the end date of this course_assignment
	*/
	@Override
	public java.util.Date getEndDate() {
		return _course_assignment.getEndDate();
	}

	/**
	* Sets the end date of this course_assignment.
	*
	* @param endDate the end date of this course_assignment
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_course_assignment.setEndDate(endDate);
	}

	/**
	* Returns the notes of this course_assignment.
	*
	* @return the notes of this course_assignment
	*/
	@Override
	public java.lang.String getNotes() {
		return _course_assignment.getNotes();
	}

	/**
	* Sets the notes of this course_assignment.
	*
	* @param notes the notes of this course_assignment
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_course_assignment.setNotes(notes);
	}

	/**
	* Returns the cost of this course_assignment.
	*
	* @return the cost of this course_assignment
	*/
	@Override
	public java.lang.String getCost() {
		return _course_assignment.getCost();
	}

	/**
	* Sets the cost of this course_assignment.
	*
	* @param cost the cost of this course_assignment
	*/
	@Override
	public void setCost(java.lang.String cost) {
		_course_assignment.setCost(cost);
	}

	/**
	* Returns the certification of this course_assignment.
	*
	* @return the certification of this course_assignment
	*/
	@Override
	public boolean getCertification() {
		return _course_assignment.getCertification();
	}

	/**
	* Returns <code>true</code> if this course_assignment is certification.
	*
	* @return <code>true</code> if this course_assignment is certification; <code>false</code> otherwise
	*/
	@Override
	public boolean isCertification() {
		return _course_assignment.isCertification();
	}

	/**
	* Sets whether this course_assignment is certification.
	*
	* @param certification the certification of this course_assignment
	*/
	@Override
	public void setCertification(boolean certification) {
		_course_assignment.setCertification(certification);
	}

	/**
	* Returns the assignment ID of this course_assignment.
	*
	* @return the assignment ID of this course_assignment
	*/
	@Override
	public long getAssignmentId() {
		return _course_assignment.getAssignmentId();
	}

	/**
	* Sets the assignment ID of this course_assignment.
	*
	* @param assignmentId the assignment ID of this course_assignment
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_course_assignment.setAssignmentId(assignmentId);
	}

	@Override
	public boolean isNew() {
		return _course_assignment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_course_assignment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _course_assignment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course_assignment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _course_assignment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _course_assignment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_course_assignment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _course_assignment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_course_assignment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_course_assignment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_course_assignment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new course_assignmentWrapper((course_assignment)_course_assignment.clone());
	}

	@Override
	public int compareTo(
		com.ms3.training.services.model.course_assignment course_assignment) {
		return _course_assignment.compareTo(course_assignment);
	}

	@Override
	public int hashCode() {
		return _course_assignment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ms3.training.services.model.course_assignment> toCacheModel() {
		return _course_assignment.toCacheModel();
	}

	@Override
	public com.ms3.training.services.model.course_assignment toEscapedModel() {
		return new course_assignmentWrapper(_course_assignment.toEscapedModel());
	}

	@Override
	public com.ms3.training.services.model.course_assignment toUnescapedModel() {
		return new course_assignmentWrapper(_course_assignment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _course_assignment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _course_assignment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_course_assignment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof course_assignmentWrapper)) {
			return false;
		}

		course_assignmentWrapper course_assignmentWrapper = (course_assignmentWrapper)obj;

		if (Validator.equals(_course_assignment,
					course_assignmentWrapper._course_assignment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public course_assignment getWrappedcourse_assignment() {
		return _course_assignment;
	}

	@Override
	public course_assignment getWrappedModel() {
		return _course_assignment;
	}

	@Override
	public void resetOriginalValues() {
		_course_assignment.resetOriginalValues();
	}

	private course_assignment _course_assignment;
}