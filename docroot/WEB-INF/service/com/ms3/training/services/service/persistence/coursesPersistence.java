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

package com.ms3.training.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.ms3.training.services.model.courses;

/**
 * The persistence interface for the courses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see coursesPersistenceImpl
 * @see coursesUtil
 * @generated
 */
public interface coursesPersistence extends BasePersistence<courses> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link coursesUtil} to access the courses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the courseses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courseses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of courseses
	* @param end the upper bound of the range of courseses (not inclusive)
	* @return the range of matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courseses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of courseses
	* @param end the upper bound of the range of courseses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first courses in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching courses
	* @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	/**
	* Returns the first courses in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching courses, or <code>null</code> if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses fetchByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last courses in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching courses
	* @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	/**
	* Returns the last courses in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching courses, or <code>null</code> if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses fetchByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courseses before and after the current courses in the ordered set where courseId = &#63;.
	*
	* @param title the primary key of the current courses
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next courses
	* @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses[] findByCourseId_PrevAndNext(
		java.lang.String title, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	/**
	* Removes all the courseses where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courseses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courseses where title = &#63;.
	*
	* @param title the title
	* @return the matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courseses where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of courseses
	* @param end the upper bound of the range of courseses (not inclusive)
	* @return the range of matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courseses where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of courseses
	* @param end the upper bound of the range of courseses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first courses in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching courses
	* @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	/**
	* Returns the first courses in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching courses, or <code>null</code> if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last courses in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching courses
	* @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	/**
	* Returns the last courses in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching courses, or <code>null</code> if a matching courses could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courseses where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courseses where title = &#63;.
	*
	* @param title the title
	* @return the number of matching courseses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public void cacheResult(com.ms3.training.services.model.courses courses);

	/**
	* Caches the courseses in the entity cache if it is enabled.
	*
	* @param courseses the courseses
	*/
	public void cacheResult(
		java.util.List<com.ms3.training.services.model.courses> courseses);

	/**
	* Creates a new courses with the primary key. Does not add the courses to the database.
	*
	* @param title the primary key for the new courses
	* @return the new courses
	*/
	public com.ms3.training.services.model.courses create(
		java.lang.String title);

	/**
	* Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param title the primary key of the courses
	* @return the courses that was removed
	* @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses remove(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	public com.ms3.training.services.model.courses updateImpl(
		com.ms3.training.services.model.courses courses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses with the primary key or throws a {@link com.ms3.training.services.NoSuchsException} if it could not be found.
	*
	* @param title the primary key of the courses
	* @return the courses
	* @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses findByPrimaryKey(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchsException;

	/**
	* Returns the courses with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param title the primary key of the courses
	* @return the courses, or <code>null</code> if a courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.training.services.model.courses fetchByPrimaryKey(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courseses.
	*
	* @return the courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ms3.training.services.model.courses> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courseses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.coursesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courseses
	* @param end the upper bound of the range of courseses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.training.services.model.courses> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courseses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courseses.
	*
	* @return the number of courseses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}