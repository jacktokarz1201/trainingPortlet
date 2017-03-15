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

import com.ms3.training.services.model.Course;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Course in entity cache.
 *
 * @author John
 * @see Course
 * @generated
 */
public class CourseCacheModel implements CacheModel<Course>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", listPrice=");
		sb.append(listPrice);
		sb.append(", provider=");
		sb.append(provider);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Course toEntityModel() {
		CourseImpl courseImpl = new CourseImpl();

		if (title == null) {
			courseImpl.setTitle(StringPool.BLANK);
		}
		else {
			courseImpl.setTitle(title);
		}

		if (description == null) {
			courseImpl.setDescription(StringPool.BLANK);
		}
		else {
			courseImpl.setDescription(description);
		}

		if (listPrice == null) {
			courseImpl.setListPrice(StringPool.BLANK);
		}
		else {
			courseImpl.setListPrice(listPrice);
		}

		if (provider == null) {
			courseImpl.setProvider(StringPool.BLANK);
		}
		else {
			courseImpl.setProvider(provider);
		}

		courseImpl.setCourseId(courseId);

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		listPrice = objectInput.readUTF();
		provider = objectInput.readUTF();
		courseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (listPrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(listPrice);
		}

		if (provider == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(provider);
		}

		objectOutput.writeLong(courseId);
	}

	public String title;
	public String description;
	public String listPrice;
	public String provider;
	public long courseId;
}