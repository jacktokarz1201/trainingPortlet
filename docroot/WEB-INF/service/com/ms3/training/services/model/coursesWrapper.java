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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link courses}.
 * </p>
 *
 * @author John
 * @see courses
 * @generated
 */
public class coursesWrapper implements courses, ModelWrapper<courses> {
	public coursesWrapper(courses courses) {
		_courses = courses;
	}

	@Override
	public Class<?> getModelClass() {
		return courses.class;
	}

	@Override
	public String getModelClassName() {
		return courses.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("listPrice", getListPrice());
		attributes.put("provider", getProvider());
		attributes.put("courseId", getCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String listPrice = (String)attributes.get("listPrice");

		if (listPrice != null) {
			setListPrice(listPrice);
		}

		String provider = (String)attributes.get("provider");

		if (provider != null) {
			setProvider(provider);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}
	}

	/**
	* Returns the primary key of this courses.
	*
	* @return the primary key of this courses
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _courses.getPrimaryKey();
	}

	/**
	* Sets the primary key of this courses.
	*
	* @param primaryKey the primary key of this courses
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_courses.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the title of this courses.
	*
	* @return the title of this courses
	*/
	@Override
	public java.lang.String getTitle() {
		return _courses.getTitle();
	}

	/**
	* Sets the title of this courses.
	*
	* @param title the title of this courses
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_courses.setTitle(title);
	}

	/**
	* Returns the description of this courses.
	*
	* @return the description of this courses
	*/
	@Override
	public java.lang.String getDescription() {
		return _courses.getDescription();
	}

	/**
	* Sets the description of this courses.
	*
	* @param description the description of this courses
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_courses.setDescription(description);
	}

	/**
	* Returns the list price of this courses.
	*
	* @return the list price of this courses
	*/
	@Override
	public java.lang.String getListPrice() {
		return _courses.getListPrice();
	}

	/**
	* Sets the list price of this courses.
	*
	* @param listPrice the list price of this courses
	*/
	@Override
	public void setListPrice(java.lang.String listPrice) {
		_courses.setListPrice(listPrice);
	}

	/**
	* Returns the provider of this courses.
	*
	* @return the provider of this courses
	*/
	@Override
	public java.lang.String getProvider() {
		return _courses.getProvider();
	}

	/**
	* Sets the provider of this courses.
	*
	* @param provider the provider of this courses
	*/
	@Override
	public void setProvider(java.lang.String provider) {
		_courses.setProvider(provider);
	}

	/**
	* Returns the course ID of this courses.
	*
	* @return the course ID of this courses
	*/
	@Override
	public long getCourseId() {
		return _courses.getCourseId();
	}

	/**
	* Sets the course ID of this courses.
	*
	* @param courseId the course ID of this courses
	*/
	@Override
	public void setCourseId(long courseId) {
		_courses.setCourseId(courseId);
	}

	@Override
	public boolean isNew() {
		return _courses.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courses.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courses.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courses.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courses.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courses.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courses.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courses.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courses.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courses.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courses.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new coursesWrapper((courses)_courses.clone());
	}

	@Override
	public int compareTo(com.ms3.training.services.model.courses courses) {
		return _courses.compareTo(courses);
	}

	@Override
	public int hashCode() {
		return _courses.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ms3.training.services.model.courses> toCacheModel() {
		return _courses.toCacheModel();
	}

	@Override
	public com.ms3.training.services.model.courses toEscapedModel() {
		return new coursesWrapper(_courses.toEscapedModel());
	}

	@Override
	public com.ms3.training.services.model.courses toUnescapedModel() {
		return new coursesWrapper(_courses.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courses.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courses.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courses.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof coursesWrapper)) {
			return false;
		}

		coursesWrapper coursesWrapper = (coursesWrapper)obj;

		if (Validator.equals(_courses, coursesWrapper._courses)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public courses getWrappedcourses() {
		return _courses;
	}

	@Override
	public courses getWrappedModel() {
		return _courses;
	}

	@Override
	public void resetOriginalValues() {
		_courses.resetOriginalValues();
	}

	private courses _courses;
}