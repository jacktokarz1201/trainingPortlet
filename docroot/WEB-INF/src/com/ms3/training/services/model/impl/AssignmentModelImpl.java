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

package com.ms3.training.services.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.ms3.training.services.model.Assignment;
import com.ms3.training.services.model.AssignmentModel;
import com.ms3.training.services.model.AssignmentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Assignment service. Represents a row in the &quot;course_Assignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ms3.training.services.model.AssignmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssignmentImpl}.
 * </p>
 *
 * @author John
 * @see AssignmentImpl
 * @see com.ms3.training.services.model.Assignment
 * @see com.ms3.training.services.model.AssignmentModel
 * @generated
 */
@JSON(strict = true)
public class AssignmentModelImpl extends BaseModelImpl<Assignment>
	implements AssignmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a assignment model instance should use the {@link com.ms3.training.services.model.Assignment} interface instead.
	 */
	public static final String TABLE_NAME = "course_Assignment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "courses_title", Types.VARCHAR },
			{ "ms3employeedb_uid", Types.VARCHAR },
			{ "assignedDate", Types.TIMESTAMP },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "notes", Types.VARCHAR },
			{ "cost", Types.VARCHAR },
			{ "certification", Types.BOOLEAN },
			{ "assignmentId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table course_Assignment (courses_title VARCHAR(75) null,ms3employeedb_uid VARCHAR(75) null,assignedDate DATE null,startDate DATE null,endDate DATE null,notes VARCHAR(2000) null,cost VARCHAR(75) null,certification BOOLEAN,assignmentId LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table course_Assignment";
	public static final String ORDER_BY_JPQL = " ORDER BY assignment.assignmentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY course_Assignment.assignmentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ms3.training.services.model.Assignment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ms3.training.services.model.Assignment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ms3.training.services.model.Assignment"),
			true);
	public static long ASSIGNMENTID_COLUMN_BITMASK = 1L;
	public static long COURSES_TITLE_COLUMN_BITMASK = 2L;
	public static long MS3EMPLOYEEDB_UID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Assignment toModel(AssignmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Assignment model = new AssignmentImpl();

		model.setCourses_title(soapModel.getCourses_title());
		model.setMs3employeedb_uid(soapModel.getMs3employeedb_uid());
		model.setAssignedDate(soapModel.getAssignedDate());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setNotes(soapModel.getNotes());
		model.setCost(soapModel.getCost());
		model.setCertification(soapModel.getCertification());
		model.setAssignmentId(soapModel.getAssignmentId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Assignment> toModels(AssignmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Assignment> models = new ArrayList<Assignment>(soapModels.length);

		for (AssignmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ms3.training.services.model.Assignment"));

	public AssignmentModelImpl() {
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
	public Class<?> getModelClass() {
		return Assignment.class;
	}

	@Override
	public String getModelClassName() {
		return Assignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courses_title", getCourses_title());
		attributes.put("ms3employeedb_uid", getMs3employeedb_uid());
		attributes.put("assignedDate", getAssignedDate());
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

		Date assignedDate = (Date)attributes.get("assignedDate");

		if (assignedDate != null) {
			setAssignedDate(assignedDate);
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

	@JSON
	@Override
	public String getCourses_title() {
		if (_courses_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _courses_title;
		}
	}

	@Override
	public void setCourses_title(String courses_title) {
		_columnBitmask |= COURSES_TITLE_COLUMN_BITMASK;

		if (_originalCourses_title == null) {
			_originalCourses_title = _courses_title;
		}

		_courses_title = courses_title;
	}

	public String getOriginalCourses_title() {
		return GetterUtil.getString(_originalCourses_title);
	}

	@JSON
	@Override
	public String getMs3employeedb_uid() {
		if (_ms3employeedb_uid == null) {
			return StringPool.BLANK;
		}
		else {
			return _ms3employeedb_uid;
		}
	}

	@Override
	public void setMs3employeedb_uid(String ms3employeedb_uid) {
		_columnBitmask |= MS3EMPLOYEEDB_UID_COLUMN_BITMASK;

		if (_originalMs3employeedb_uid == null) {
			_originalMs3employeedb_uid = _ms3employeedb_uid;
		}

		_ms3employeedb_uid = ms3employeedb_uid;
	}

	public String getOriginalMs3employeedb_uid() {
		return GetterUtil.getString(_originalMs3employeedb_uid);
	}

	@JSON
	@Override
	public Date getAssignedDate() {
		return _assignedDate;
	}

	@Override
	public void setAssignedDate(Date assignedDate) {
		_assignedDate = assignedDate;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public String getNotes() {
		if (_notes == null) {
			return StringPool.BLANK;
		}
		else {
			return _notes;
		}
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;
	}

	@JSON
	@Override
	public String getCost() {
		if (_cost == null) {
			return StringPool.BLANK;
		}
		else {
			return _cost;
		}
	}

	@Override
	public void setCost(String cost) {
		_cost = cost;
	}

	@JSON
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
	}

	@JSON
	@Override
	public long getAssignmentId() {
		return _assignmentId;
	}

	@Override
	public void setAssignmentId(long assignmentId) {
		_columnBitmask |= ASSIGNMENTID_COLUMN_BITMASK;

		if (!_setOriginalAssignmentId) {
			_setOriginalAssignmentId = true;

			_originalAssignmentId = _assignmentId;
		}

		_assignmentId = assignmentId;
	}

	public long getOriginalAssignmentId() {
		return _originalAssignmentId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Assignment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Assignment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Assignment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssignmentImpl assignmentImpl = new AssignmentImpl();

		assignmentImpl.setCourses_title(getCourses_title());
		assignmentImpl.setMs3employeedb_uid(getMs3employeedb_uid());
		assignmentImpl.setAssignedDate(getAssignedDate());
		assignmentImpl.setStartDate(getStartDate());
		assignmentImpl.setEndDate(getEndDate());
		assignmentImpl.setNotes(getNotes());
		assignmentImpl.setCost(getCost());
		assignmentImpl.setCertification(getCertification());
		assignmentImpl.setAssignmentId(getAssignmentId());

		assignmentImpl.resetOriginalValues();

		return assignmentImpl;
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

		if (!(obj instanceof Assignment)) {
			return false;
		}

		Assignment assignment = (Assignment)obj;

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
	public void resetOriginalValues() {
		AssignmentModelImpl assignmentModelImpl = this;

		assignmentModelImpl._originalCourses_title = assignmentModelImpl._courses_title;

		assignmentModelImpl._originalMs3employeedb_uid = assignmentModelImpl._ms3employeedb_uid;

		assignmentModelImpl._originalAssignmentId = assignmentModelImpl._assignmentId;

		assignmentModelImpl._setOriginalAssignmentId = false;

		assignmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Assignment> toCacheModel() {
		AssignmentCacheModel assignmentCacheModel = new AssignmentCacheModel();

		assignmentCacheModel.courses_title = getCourses_title();

		String courses_title = assignmentCacheModel.courses_title;

		if ((courses_title != null) && (courses_title.length() == 0)) {
			assignmentCacheModel.courses_title = null;
		}

		assignmentCacheModel.ms3employeedb_uid = getMs3employeedb_uid();

		String ms3employeedb_uid = assignmentCacheModel.ms3employeedb_uid;

		if ((ms3employeedb_uid != null) && (ms3employeedb_uid.length() == 0)) {
			assignmentCacheModel.ms3employeedb_uid = null;
		}

		Date assignedDate = getAssignedDate();

		if (assignedDate != null) {
			assignmentCacheModel.assignedDate = assignedDate.getTime();
		}
		else {
			assignmentCacheModel.assignedDate = Long.MIN_VALUE;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			assignmentCacheModel.startDate = startDate.getTime();
		}
		else {
			assignmentCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			assignmentCacheModel.endDate = endDate.getTime();
		}
		else {
			assignmentCacheModel.endDate = Long.MIN_VALUE;
		}

		assignmentCacheModel.notes = getNotes();

		String notes = assignmentCacheModel.notes;

		if ((notes != null) && (notes.length() == 0)) {
			assignmentCacheModel.notes = null;
		}

		assignmentCacheModel.cost = getCost();

		String cost = assignmentCacheModel.cost;

		if ((cost != null) && (cost.length() == 0)) {
			assignmentCacheModel.cost = null;
		}

		assignmentCacheModel.certification = getCertification();

		assignmentCacheModel.assignmentId = getAssignmentId();

		return assignmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{courses_title=");
		sb.append(getCourses_title());
		sb.append(", ms3employeedb_uid=");
		sb.append(getMs3employeedb_uid());
		sb.append(", assignedDate=");
		sb.append(getAssignedDate());
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
		StringBundler sb = new StringBundler(31);

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
			"<column><column-name>assignedDate</column-name><column-value><![CDATA[");
		sb.append(getAssignedDate());
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

	private static ClassLoader _classLoader = Assignment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Assignment.class
		};
	private String _courses_title;
	private String _originalCourses_title;
	private String _ms3employeedb_uid;
	private String _originalMs3employeedb_uid;
	private Date _assignedDate;
	private Date _startDate;
	private Date _endDate;
	private String _notes;
	private String _cost;
	private boolean _certification;
	private long _assignmentId;
	private long _originalAssignmentId;
	private boolean _setOriginalAssignmentId;
	private long _columnBitmask;
	private Assignment _escapedModel;
}