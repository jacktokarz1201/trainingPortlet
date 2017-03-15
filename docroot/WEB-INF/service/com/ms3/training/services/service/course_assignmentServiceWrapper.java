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

package com.ms3.training.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link course_assignmentService}.
 *
 * @author John
 * @see course_assignmentService
 * @generated
 */
public class course_assignmentServiceWrapper implements course_assignmentService,
	ServiceWrapper<course_assignmentService> {
	public course_assignmentServiceWrapper(
		course_assignmentService course_assignmentService) {
		_course_assignmentService = course_assignmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _course_assignmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_course_assignmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _course_assignmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public course_assignmentService getWrappedcourse_assignmentService() {
		return _course_assignmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedcourse_assignmentService(
		course_assignmentService course_assignmentService) {
		_course_assignmentService = course_assignmentService;
	}

	@Override
	public course_assignmentService getWrappedService() {
		return _course_assignmentService;
	}

	@Override
	public void setWrappedService(
		course_assignmentService course_assignmentService) {
		_course_assignmentService = course_assignmentService;
	}

	private course_assignmentService _course_assignmentService;
}