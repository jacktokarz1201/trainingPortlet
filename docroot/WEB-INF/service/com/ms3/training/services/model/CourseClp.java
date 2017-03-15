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

import com.ms3.training.services.service.ClpSerializer;
import com.ms3.training.services.service.CourseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author John
 */
public class CourseClp extends BaseModelImpl<Course> implements Course {
	public CourseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _title;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setTitle(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _title;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_courseRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_courseRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getListPrice() {
		return _listPrice;
	}

	@Override
	public void setListPrice(String listPrice) {
		_listPrice = listPrice;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setListPrice", String.class);

				method.invoke(_courseRemoteModel, listPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProvider() {
		return _provider;
	}

	@Override
	public void setProvider(String provider) {
		_provider = provider;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setProvider", String.class);

				method.invoke(_courseRemoteModel, provider);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_courseRemoteModel, courseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseRemoteModel() {
		return _courseRemoteModel;
	}

	public void setCourseRemoteModel(BaseModel<?> courseRemoteModel) {
		_courseRemoteModel = courseRemoteModel;
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

		Class<?> remoteModelClass = _courseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseLocalServiceUtil.addCourse(this);
		}
		else {
			CourseLocalServiceUtil.updateCourse(this);
		}
	}

	@Override
	public Course toEscapedModel() {
		return (Course)ProxyUtil.newProxyInstance(Course.class.getClassLoader(),
			new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseClp clone = new CourseClp();

		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setListPrice(getListPrice());
		clone.setProvider(getProvider());
		clone.setCourseId(getCourseId());

		return clone;
	}

	@Override
	public int compareTo(Course course) {
		String primaryKey = course.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseClp)) {
			return false;
		}

		CourseClp course = (CourseClp)obj;

		String primaryKey = course.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", listPrice=");
		sb.append(getListPrice());
		sb.append(", provider=");
		sb.append(getProvider());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ms3.training.services.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listPrice</column-name><column-value><![CDATA[");
		sb.append(getListPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provider</column-name><column-value><![CDATA[");
		sb.append(getProvider());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _title;
	private String _description;
	private String _listPrice;
	private String _provider;
	private long _courseId;
	private BaseModel<?> _courseRemoteModel;
}