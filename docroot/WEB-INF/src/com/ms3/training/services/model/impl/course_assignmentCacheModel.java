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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.ms3.training.services.model.course_assignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing course_assignment in entity cache.
 *
 * @author John
 * @see course_assignment
 * @generated
 */
public class course_assignmentCacheModel implements CacheModel<course_assignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{courses_title=");
		sb.append(courses_title);
		sb.append(", ms3employeedb_uid=");
		sb.append(ms3employeedb_uid);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", certification=");
		sb.append(certification);
		sb.append(", assignmentId=");
		sb.append(assignmentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public course_assignment toEntityModel() {
		course_assignmentImpl course_assignmentImpl = new course_assignmentImpl();

		if (courses_title == null) {
			course_assignmentImpl.setCourses_title(StringPool.BLANK);
		}
		else {
			course_assignmentImpl.setCourses_title(courses_title);
		}

		if (ms3employeedb_uid == null) {
			course_assignmentImpl.setMs3employeedb_uid(StringPool.BLANK);
		}
		else {
			course_assignmentImpl.setMs3employeedb_uid(ms3employeedb_uid);
		}

		if (startDate == Long.MIN_VALUE) {
			course_assignmentImpl.setStartDate(null);
		}
		else {
			course_assignmentImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			course_assignmentImpl.setEndDate(null);
		}
		else {
			course_assignmentImpl.setEndDate(new Date(endDate));
		}

		if (notes == null) {
			course_assignmentImpl.setNotes(StringPool.BLANK);
		}
		else {
			course_assignmentImpl.setNotes(notes);
		}

		if (cost == null) {
			course_assignmentImpl.setCost(StringPool.BLANK);
		}
		else {
			course_assignmentImpl.setCost(cost);
		}

		course_assignmentImpl.setCertification(certification);
		course_assignmentImpl.setAssignmentId(assignmentId);

		course_assignmentImpl.resetOriginalValues();

		return course_assignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		courses_title = objectInput.readUTF();
		ms3employeedb_uid = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		notes = objectInput.readUTF();
		cost = objectInput.readUTF();
		certification = objectInput.readBoolean();
		assignmentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (courses_title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courses_title);
		}

		if (ms3employeedb_uid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ms3employeedb_uid);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		if (cost == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cost);
		}

		objectOutput.writeBoolean(certification);
		objectOutput.writeLong(assignmentId);
	}

	public String courses_title;
	public String ms3employeedb_uid;
	public long startDate;
	public long endDate;
	public String notes;
	public String cost;
	public boolean certification;
	public long assignmentId;
}