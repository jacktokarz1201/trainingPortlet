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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.ms3.training.services.model.course_assignment;

import java.util.List;

/**
 * The persistence utility for the course_assignment service. This utility wraps {@link course_assignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see course_assignmentPersistence
 * @see course_assignmentPersistenceImpl
 * @generated
 */
public class course_assignmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(course_assignment course_assignment) {
		getPersistence().clearCache(course_assignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<course_assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<course_assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<course_assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static course_assignment update(course_assignment course_assignment)
		throws SystemException {
		return getPersistence().update(course_assignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static course_assignment update(
		course_assignment course_assignment, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(course_assignment, serviceContext);
	}

	/**
	* Returns all the course_assignments where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @return the matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findByCourses_title(
		java.lang.String courses_title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourses_title(courses_title);
	}

	/**
	* Returns a range of all the course_assignments where courses_title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courses_title the courses_title
	* @param start the lower bound of the range of course_assignments
	* @param end the upper bound of the range of course_assignments (not inclusive)
	* @return the range of matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findByCourses_title(
		java.lang.String courses_title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourses_title(courses_title, start, end);
	}

	/**
	* Returns an ordered range of all the course_assignments where courses_title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courses_title the courses_title
	* @param start the lower bound of the range of course_assignments
	* @param end the upper bound of the range of course_assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findByCourses_title(
		java.lang.String courses_title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourses_title(courses_title, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course_assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment findByCourses_title_First(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence()
				   .findByCourses_title_First(courses_title, orderByComparator);
	}

	/**
	* Returns the first course_assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment fetchByCourses_title_First(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourses_title_First(courses_title, orderByComparator);
	}

	/**
	* Returns the last course_assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment findByCourses_title_Last(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence()
				   .findByCourses_title_Last(courses_title, orderByComparator);
	}

	/**
	* Returns the last course_assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment fetchByCourses_title_Last(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourses_title_Last(courses_title, orderByComparator);
	}

	/**
	* Returns the course_assignments before and after the current course_assignment in the ordered set where courses_title = &#63;.
	*
	* @param assignmentId the primary key of the current course_assignment
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment[] findByCourses_title_PrevAndNext(
		long assignmentId, java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence()
				   .findByCourses_title_PrevAndNext(assignmentId,
			courses_title, orderByComparator);
	}

	/**
	* Removes all the course_assignments where courses_title = &#63; from the database.
	*
	* @param courses_title the courses_title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourses_title(java.lang.String courses_title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourses_title(courses_title);
	}

	/**
	* Returns the number of course_assignments where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @return the number of matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourses_title(java.lang.String courses_title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourses_title(courses_title);
	}

	/**
	* Returns all the course_assignments where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @return the matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMs3employeedb_uid(ms3employeedb_uid);
	}

	/**
	* Returns a range of all the course_assignments where ms3employeedb_uid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param start the lower bound of the range of course_assignments
	* @param end the upper bound of the range of course_assignments (not inclusive)
	* @return the range of matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMs3employeedb_uid(ms3employeedb_uid, start, end);
	}

	/**
	* Returns an ordered range of all the course_assignments where ms3employeedb_uid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param start the lower bound of the range of course_assignments
	* @param end the upper bound of the range of course_assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMs3employeedb_uid(ms3employeedb_uid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment findByMs3employeedb_uid_First(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence()
				   .findByMs3employeedb_uid_First(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the first course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment fetchByMs3employeedb_uid_First(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMs3employeedb_uid_First(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the last course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment findByMs3employeedb_uid_Last(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence()
				   .findByMs3employeedb_uid_Last(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the last course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment fetchByMs3employeedb_uid_Last(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMs3employeedb_uid_Last(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the course_assignments before and after the current course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param assignmentId the primary key of the current course_assignment
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment[] findByMs3employeedb_uid_PrevAndNext(
		long assignmentId, java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence()
				   .findByMs3employeedb_uid_PrevAndNext(assignmentId,
			ms3employeedb_uid, orderByComparator);
	}

	/**
	* Removes all the course_assignments where ms3employeedb_uid = &#63; from the database.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMs3employeedb_uid(ms3employeedb_uid);
	}

	/**
	* Returns the number of course_assignments where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @return the number of matching course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMs3employeedb_uid(ms3employeedb_uid);
	}

	/**
	* Caches the course_assignment in the entity cache if it is enabled.
	*
	* @param course_assignment the course_assignment
	*/
	public static void cacheResult(
		com.ms3.training.services.model.course_assignment course_assignment) {
		getPersistence().cacheResult(course_assignment);
	}

	/**
	* Caches the course_assignments in the entity cache if it is enabled.
	*
	* @param course_assignments the course_assignments
	*/
	public static void cacheResult(
		java.util.List<com.ms3.training.services.model.course_assignment> course_assignments) {
		getPersistence().cacheResult(course_assignments);
	}

	/**
	* Creates a new course_assignment with the primary key. Does not add the course_assignment to the database.
	*
	* @param assignmentId the primary key for the new course_assignment
	* @return the new course_assignment
	*/
	public static com.ms3.training.services.model.course_assignment create(
		long assignmentId) {
		return getPersistence().create(assignmentId);
	}

	/**
	* Removes the course_assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assignmentId the primary key of the course_assignment
	* @return the course_assignment that was removed
	* @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment remove(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence().remove(assignmentId);
	}

	public static com.ms3.training.services.model.course_assignment updateImpl(
		com.ms3.training.services.model.course_assignment course_assignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(course_assignment);
	}

	/**
	* Returns the course_assignment with the primary key or throws a {@link com.ms3.training.services.NoSuch_assignmentException} if it could not be found.
	*
	* @param assignmentId the primary key of the course_assignment
	* @return the course_assignment
	* @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment findByPrimaryKey(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuch_assignmentException {
		return getPersistence().findByPrimaryKey(assignmentId);
	}

	/**
	* Returns the course_assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assignmentId the primary key of the course_assignment
	* @return the course_assignment, or <code>null</code> if a course_assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.course_assignment fetchByPrimaryKey(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(assignmentId);
	}

	/**
	* Returns all the course_assignments.
	*
	* @return the course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ms3.training.services.model.course_assignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the course_assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.course_assignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course_assignments
	* @param end the upper bound of the range of course_assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.course_assignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course_assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course_assignments.
	*
	* @return the number of course_assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static course_assignmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (course_assignmentPersistence)PortletBeanLocatorUtil.locate(com.ms3.training.services.service.ClpSerializer.getServletContextName(),
					course_assignmentPersistence.class.getName());

			ReferenceRegistry.registerReference(course_assignmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(course_assignmentPersistence persistence) {
	}

	private static course_assignmentPersistence _persistence;
}