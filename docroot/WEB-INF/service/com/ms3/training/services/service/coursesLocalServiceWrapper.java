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
 * Provides a wrapper for {@link coursesLocalService}.
 *
 * @author John
 * @see coursesLocalService
 * @generated
 */
public class coursesLocalServiceWrapper implements coursesLocalService,
	ServiceWrapper<coursesLocalService> {
	public coursesLocalServiceWrapper(coursesLocalService coursesLocalService) {
		_coursesLocalService = coursesLocalService;
	}

	/**
	* Adds the courses to the database. Also notifies the appropriate model listeners.
	*
	* @param courses the courses
	* @return the courses that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.courses addcourses(
		com.ms3.training.services.model.courses courses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.addcourses(courses);
	}

	/**
	* Creates a new courses with the primary key. Does not add the courses to the database.
	*
	* @param title the primary key for the new courses
	* @return the new courses
	*/
	@Override
	public com.ms3.training.services.model.courses createcourses(
		java.lang.String title) {
		return _coursesLocalService.createcourses(title);
	}

	/**
	* Deletes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param title the primary key of the courses
	* @return the courses that was removed
	* @throws PortalException if a courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.courses deletecourses(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.deletecourses(title);
	}

	/**
	* Deletes the courses from the database. Also notifies the appropriate model listeners.
	*
	* @param courses the courses
	* @return the courses that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.courses deletecourses(
		com.ms3.training.services.model.courses courses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.deletecourses(courses);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coursesLocalService.dynamicQuery();
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
		return _coursesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _coursesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _coursesLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _coursesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _coursesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ms3.training.services.model.courses fetchcourses(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.fetchcourses(title);
	}

	/**
	* Returns the courses with the primary key.
	*
	* @param title the primary key of the courses
	* @return the courses
	* @throws PortalException if a courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.courses getcourses(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.getcourses(title);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the courseses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courseses
	* @param end the upper bound of the range of courseses (not inclusive)
	* @return the range of courseses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ms3.training.services.model.courses> getcourseses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.getcourseses(start, end);
	}

	/**
	* Returns the number of courseses.
	*
	* @return the number of courseses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getcoursesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.getcoursesesCount();
	}

	/**
	* Updates the courses in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courses the courses
	* @return the courses that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.training.services.model.courses updatecourses(
		com.ms3.training.services.model.courses courses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coursesLocalService.updatecourses(courses);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _coursesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_coursesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _coursesLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public coursesLocalService getWrappedcoursesLocalService() {
		return _coursesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedcoursesLocalService(
		coursesLocalService coursesLocalService) {
		_coursesLocalService = coursesLocalService;
	}

	@Override
	public coursesLocalService getWrappedService() {
		return _coursesLocalService;
	}

	@Override
	public void setWrappedService(coursesLocalService coursesLocalService) {
		_coursesLocalService = coursesLocalService;
	}

	private coursesLocalService _coursesLocalService;
}