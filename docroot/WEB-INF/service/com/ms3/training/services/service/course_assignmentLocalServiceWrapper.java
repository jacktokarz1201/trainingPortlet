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
 * Provides a wrapper for {@link course_assignmentLocalService}.
 *
 * @author John
 * @see course_assignmentLocalService
 * @generated
 */
public class course_assignmentLocalServiceWrapper
	implements course_assignmentLocalService,
		ServiceWrapper<course_assignmentLocalService> {
	public course_assignmentLocalServiceWrapper(
		course_assignmentLocalService course_assignmentLocalService) {
		_course_assignmentLocalService = course_assignmentLocalService;
	}

	/**
	* Adds the course_assignment to the database. Also notifies the appropriate model listeners.
	*
	* @param course_assignment the course_assignment
	* @return the course_assignment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.course_assignment addcourse_assignment(
		com.ms3.training.services.model.course_assignment course_assignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.addcourse_assignment(course_assignment);
	}

	/**
	* Creates a new course_assignment with the primary key. Does not add the course_assignment to the database.
	*
	* @param assignmentId the primary key for the new course_assignment
	* @return the new course_assignment
	*/
	@Override
	public com.ms3.training.services.model.course_assignment createcourse_assignment(
		long assignmentId) {
		return _course_assignmentLocalService.createcourse_assignment(assignmentId);
	}

	/**
	* Deletes the course_assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assignmentId the primary key of the course_assignment
	* @return the course_assignment that was removed
	* @throws PortalException if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.course_assignment deletecourse_assignment(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.deletecourse_assignment(assignmentId);
	}

	/**
	* Deletes the course_assignment from the database. Also notifies the appropriate model listeners.
	*
	* @param course_assignment the course_assignment
	* @return the course_assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.course_assignment deletecourse_assignment(
		com.ms3.training.services.model.course_assignment course_assignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.deletecourse_assignment(course_assignment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _course_assignmentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ms3.training.services.model.course_assignment fetchcourse_assignment(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.fetchcourse_assignment(assignmentId);
	}

	/**
	* Returns the course_assignment with the primary key.
	*
	* @param assignmentId the primary key of the course_assignment
	* @return the course_assignment
	* @throws PortalException if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.course_assignment getcourse_assignment(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.getcourse_assignment(assignmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the course_assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course_assignments
	* @param end the upper bound of the range of course_assignments (not inclusive)
	* @return the range of course_assignments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ms3.training.services.model.course_assignment> getcourse_assignments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.getcourse_assignments(start, end);
	}

	/**
	* Returns the number of course_assignments.
	*
	* @return the number of course_assignments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getcourse_assignmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.getcourse_assignmentsCount();
	}

	/**
	* Updates the course_assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param course_assignment the course_assignment
	* @return the course_assignment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.course_assignment updatecourse_assignment(
		com.ms3.training.services.model.course_assignment course_assignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course_assignmentLocalService.updatecourse_assignment(course_assignment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _course_assignmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_course_assignmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _course_assignmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public course_assignmentLocalService getWrappedcourse_assignmentLocalService() {
		return _course_assignmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedcourse_assignmentLocalService(
		course_assignmentLocalService course_assignmentLocalService) {
		_course_assignmentLocalService = course_assignmentLocalService;
	}

	@Override
	public course_assignmentLocalService getWrappedService() {
		return _course_assignmentLocalService;
	}

	@Override
	public void setWrappedService(
		course_assignmentLocalService course_assignmentLocalService) {
		_course_assignmentLocalService = course_assignmentLocalService;
	}

	private course_assignmentLocalService _course_assignmentLocalService;
}