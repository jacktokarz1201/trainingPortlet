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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Assignment service. Represents a row in the &quot;course_Assignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ms3.training.services.model.impl.AssignmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ms3.training.services.model.impl.AssignmentImpl}.
 * </p>
 *
 * @author John
 * @see Assignment
 * @see com.ms3.training.services.model.impl.AssignmentImpl
 * @see com.ms3.training.services.model.impl.AssignmentModelImpl
 * @generated
 */
public interface AssignmentModel extends BaseModel<Assignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a assignment model instance should use the {@link Assignment} interface instead.
	 */

	/**
	 * Returns the primary key of this assignment.
	 *
	 * @return the primary key of this assignment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this assignment.
	 *
	 * @param primaryKey the primary key of this assignment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the courses_title of this assignment.
	 *
	 * @return the courses_title of this assignment
	 */
	@AutoEscape
	public String getCourses_title();

	/**
	 * Sets the courses_title of this assignment.
	 *
	 * @param courses_title the courses_title of this assignment
	 */
	public void setCourses_title(String courses_title);

	/**
	 * Returns the ms3employeedb_uid of this assignment.
	 *
	 * @return the ms3employeedb_uid of this assignment
	 */
	@AutoEscape
	public String getMs3employeedb_uid();

	/**
	 * Sets the ms3employeedb_uid of this assignment.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid of this assignment
	 */
	public void setMs3employeedb_uid(String ms3employeedb_uid);

	/**
	 * Returns the start date of this assignment.
	 *
	 * @return the start date of this assignment
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this assignment.
	 *
	 * @param startDate the start date of this assignment
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this assignment.
	 *
	 * @return the end date of this assignment
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this assignment.
	 *
	 * @param endDate the end date of this assignment
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the notes of this assignment.
	 *
	 * @return the notes of this assignment
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this assignment.
	 *
	 * @param notes the notes of this assignment
	 */
	public void setNotes(String notes);

	/**
	 * Returns the cost of this assignment.
	 *
	 * @return the cost of this assignment
	 */
	@AutoEscape
	public String getCost();

	/**
	 * Sets the cost of this assignment.
	 *
	 * @param cost the cost of this assignment
	 */
	public void setCost(String cost);

	/**
	 * Returns the certification of this assignment.
	 *
	 * @return the certification of this assignment
	 */
	public boolean getCertification();

	/**
	 * Returns <code>true</code> if this assignment is certification.
	 *
	 * @return <code>true</code> if this assignment is certification; <code>false</code> otherwise
	 */
	public boolean isCertification();

	/**
	 * Sets whether this assignment is certification.
	 *
	 * @param certification the certification of this assignment
	 */
	public void setCertification(boolean certification);

	/**
	 * Returns the assignment ID of this assignment.
	 *
	 * @return the assignment ID of this assignment
	 */
	public long getAssignmentId();

	/**
	 * Sets the assignment ID of this assignment.
	 *
	 * @param assignmentId the assignment ID of this assignment
	 */
	public void setAssignmentId(long assignmentId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Assignment assignment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Assignment> toCacheModel();

	@Override
	public Assignment toEscapedModel();

	@Override
	public Assignment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}