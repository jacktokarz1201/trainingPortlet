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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.ms3.training.services.service.AssignmentLocalServiceUtil;
import com.ms3.training.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John
 */
public class AssignmentClp extends BaseModelImpl<Assignment>
	implements Assignment {
	public AssignmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Assignment.class;
	}

	@Override
	public String getModelClassName() {
		return Assignment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _assignmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAssignmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assignmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getCourses_title() {
		return _courses_title;
	}

	@Override
	public void setCourses_title(String courses_title) {
		_courses_title = courses_title;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCourses_title", String.class);

				method.invoke(_assignmentRemoteModel, courses_title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMs3employeedb_uid() {
		return _ms3employeedb_uid;
	}

	@Override
	public void setMs3employeedb_uid(String ms3employeedb_uid) {
		_ms3employeedb_uid = ms3employeedb_uid;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setMs3employeedb_uid",
						String.class);

				method.invoke(_assignmentRemoteModel, ms3employeedb_uid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_assignmentRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_assignmentRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_assignmentRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCost() {
		return _cost;
	}

	@Override
	public void setCost(String cost) {
		_cost = cost;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", String.class);

				method.invoke(_assignmentRemoteModel, cost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCertification() {
		return _certification;
	}

	@Override
	public boolean isCertification() {
		return _certification;
	}

	@Override
	public void setCertification(boolean certification) {
		_certification = certification;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCertification",
						boolean.class);

				method.invoke(_assignmentRemoteModel, certification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssignmentId() {
		return _assignmentId;
	}

	@Override
	public void setAssignmentId(long assignmentId) {
		_assignmentId = assignmentId;

		if (_assignmentRemoteModel != null) {
			try {
				Class<?> clazz = _assignmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentId", long.class);

				method.invoke(_assignmentRemoteModel, assignmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAssignmentRemoteModel() {
		return _assignmentRemoteModel;
	}

	public void setAssignmentRemoteModel(BaseModel<?> assignmentRemoteModel) {
		_assignmentRemoteModel = assignmentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _assignmentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_assignmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AssignmentLocalServiceUtil.addAssignment(this);
		}
		else {
			AssignmentLocalServiceUtil.updateAssignment(this);
		}
	}

	@Override
	public Assignment toEscapedModel() {
		return (Assignment)ProxyUtil.newProxyInstance(Assignment.class.getClassLoader(),
			new Class[] { Assignment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AssignmentClp clone = new AssignmentClp();

		clone.setCourses_title(getCourses_title());
		clone.setMs3employeedb_uid(getMs3employeedb_uid());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setNotes(getNotes());
		clone.setCost(getCost());
		clone.setCertification(getCertification());
		clone.setAssignmentId(getAssignmentId());

		return clone;
	}

	@Override
	public int compareTo(Assignment assignment) {
		long primaryKey = assignment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssignmentClp)) {
			return false;
		}

		AssignmentClp assignment = (AssignmentClp)obj;

		long primaryKey = assignment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{courses_title=");
		sb.append(getCourses_title());
		sb.append(", ms3employeedb_uid=");
		sb.append(getMs3employeedb_uid());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", certification=");
		sb.append(getCertification());
		sb.append(", assignmentId=");
		sb.append(getAssignmentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ms3.training.services.model.Assignment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>courses_title</column-name><column-value><![CDATA[");
		sb.append(getCourses_title());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ms3employeedb_uid</column-name><column-value><![CDATA[");
		sb.append(getMs3employeedb_uid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certification</column-name><column-value><![CDATA[");
		sb.append(getCertification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignmentId</column-name><column-value><![CDATA[");
		sb.append(getAssignmentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _courses_title;
	private String _ms3employeedb_uid;
	private Date _startDate;
	private Date _endDate;
	private String _notes;
	private String _cost;
	private boolean _certification;
	private long _assignmentId;
	private BaseModel<?> _assignmentRemoteModel;
}