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

import com.ms3.training.services.model.Assignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Assignment in entity cache.
 *
 * @author John
 * @see Assignment
 * @generated
 */
public class AssignmentCacheModel implements CacheModel<Assignment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{courses_title=");
		sb.append(courses_title);
		sb.append(", ms3employeedb_uid=");
		sb.append(ms3employeedb_uid);
		sb.append(", assignedDate=");
		sb.append(assignedDate);
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
	public Assignment toEntityModel() {
		AssignmentImpl assignmentImpl = new AssignmentImpl();

		if (courses_title == null) {
			assignmentImpl.setCourses_title(StringPool.BLANK);
		}
		else {
			assignmentImpl.setCourses_title(courses_title);
		}

		if (ms3employeedb_uid == null) {
			assignmentImpl.setMs3employeedb_uid(StringPool.BLANK);
		}
		else {
			assignmentImpl.setMs3employeedb_uid(ms3employeedb_uid);
		}

		if (assignedDate == Long.MIN_VALUE) {
			assignmentImpl.setAssignedDate(null);
		}
		else {
			assignmentImpl.setAssignedDate(new Date(assignedDate));
		}

		if (startDate == Long.MIN_VALUE) {
			assignmentImpl.setStartDate(null);
		}
		else {
			assignmentImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			assignmentImpl.setEndDate(null);
		}
		else {
			assignmentImpl.setEndDate(new Date(endDate));
		}

		if (notes == null) {
			assignmentImpl.setNotes(StringPool.BLANK);
		}
		else {
			assignmentImpl.setNotes(notes);
		}

		if (cost == null) {
			assignmentImpl.setCost(StringPool.BLANK);
		}
		else {
			assignmentImpl.setCost(cost);
		}

		assignmentImpl.setCertification(certification);
		assignmentImpl.setAssignmentId(assignmentId);

		assignmentImpl.resetOriginalValues();

		return assignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		courses_title = objectInput.readUTF();
		ms3employeedb_uid = objectInput.readUTF();
		assignedDate = objectInput.readLong();
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

		objectOutput.writeLong(assignedDate);
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
	public long assignedDate;
	public long startDate;
	public long endDate;
	public String notes;
	public String cost;
	public boolean certification;
	public long assignmentId;
}