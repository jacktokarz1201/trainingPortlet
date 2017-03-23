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

import com.ms3.training.services.model.Assignment;

import java.util.List;

/**
 * The persistence utility for the assignment service. This utility wraps {@link AssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see AssignmentPersistence
 * @see AssignmentPersistenceImpl
 * @generated
 */
public class AssignmentUtil {
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
	public static void clearCache(Assignment assignment) {
		getPersistence().clearCache(assignment);
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
	public static List<Assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Assignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Assignment update(Assignment assignment)
		throws SystemException {
		return getPersistence().update(assignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Assignment update(Assignment assignment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(assignment, serviceContext);
	}

	/**
	* Returns all the assignments where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @return the matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findByCourses_title(
		java.lang.String courses_title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourses_title(courses_title);
	}

	/**
	* Returns a range of all the assignments where courses_title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courses_title the courses_title
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findByCourses_title(
		java.lang.String courses_title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourses_title(courses_title, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where courses_title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courses_title the courses_title
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findByCourses_title(
		java.lang.String courses_title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourses_title(courses_title, start, end,
			orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment findByCourses_title_First(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence()
				   .findByCourses_title_First(courses_title, orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByCourses_title_First(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourses_title_First(courses_title, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment findByCourses_title_Last(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence()
				   .findByCourses_title_Last(courses_title, orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByCourses_title_Last(
		java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourses_title_Last(courses_title, orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where courses_title = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param courses_title the courses_title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment[] findByCourses_title_PrevAndNext(
		long assignmentId, java.lang.String courses_title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence()
				   .findByCourses_title_PrevAndNext(assignmentId,
			courses_title, orderByComparator);
	}

	/**
	* Removes all the assignments where courses_title = &#63; from the database.
	*
	* @param courses_title the courses_title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourses_title(java.lang.String courses_title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourses_title(courses_title);
	}

	/**
	* Returns the number of assignments where courses_title = &#63;.
	*
	* @param courses_title the courses_title
	* @return the number of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourses_title(java.lang.String courses_title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourses_title(courses_title);
	}

	/**
	* Returns all the assignments where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @return the matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMs3employeedb_uid(ms3employeedb_uid);
	}

	/**
	* Returns a range of all the assignments where ms3employeedb_uid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMs3employeedb_uid(ms3employeedb_uid, start, end);
	}

	/**
	* Returns an ordered range of all the assignments where ms3employeedb_uid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMs3employeedb_uid(ms3employeedb_uid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment findByMs3employeedb_uid_First(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence()
				   .findByMs3employeedb_uid_First(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the first assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByMs3employeedb_uid_First(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMs3employeedb_uid_First(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment findByMs3employeedb_uid_Last(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence()
				   .findByMs3employeedb_uid_Last(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the last assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByMs3employeedb_uid_Last(
		java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMs3employeedb_uid_Last(ms3employeedb_uid,
			orderByComparator);
	}

	/**
	* Returns the assignments before and after the current assignment in the ordered set where ms3employeedb_uid = &#63;.
	*
	* @param assignmentId the primary key of the current assignment
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment[] findByMs3employeedb_uid_PrevAndNext(
		long assignmentId, java.lang.String ms3employeedb_uid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence()
				   .findByMs3employeedb_uid_PrevAndNext(assignmentId,
			ms3employeedb_uid, orderByComparator);
	}

	/**
	* Removes all the assignments where ms3employeedb_uid = &#63; from the database.
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
	* Returns the number of assignments where ms3employeedb_uid = &#63;.
	*
	* @param ms3employeedb_uid the ms3employeedb_uid
	* @return the number of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMs3employeedb_uid(
		java.lang.String ms3employeedb_uid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMs3employeedb_uid(ms3employeedb_uid);
	}

	/**
	* Returns the assignment where assignmentId = &#63; or throws a {@link com.ms3.training.services.NoSuchAssignmentException} if it could not be found.
	*
	* @param assignmentId the assignment ID
	* @return the matching assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment findByassignmentId(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence().findByassignmentId(assignmentId);
	}

	/**
	* Returns the assignment where assignmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assignmentId the assignment ID
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByassignmentId(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByassignmentId(assignmentId);
	}

	/**
	* Returns the assignment where assignmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assignmentId the assignment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByassignmentId(
		long assignmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByassignmentId(assignmentId, retrieveFromCache);
	}

	/**
	* Removes the assignment where assignmentId = &#63; from the database.
	*
	* @param assignmentId the assignment ID
	* @return the assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment removeByassignmentId(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence().removeByassignmentId(assignmentId);
	}

	/**
	* Returns the number of assignments where assignmentId = &#63;.
	*
	* @param assignmentId the assignment ID
	* @return the number of matching assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByassignmentId(long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByassignmentId(assignmentId);
	}

	/**
	* Caches the assignment in the entity cache if it is enabled.
	*
	* @param assignment the assignment
	*/
	public static void cacheResult(
		com.ms3.training.services.model.Assignment assignment) {
		getPersistence().cacheResult(assignment);
	}

	/**
	* Caches the assignments in the entity cache if it is enabled.
	*
	* @param assignments the assignments
	*/
	public static void cacheResult(
		java.util.List<com.ms3.training.services.model.Assignment> assignments) {
		getPersistence().cacheResult(assignments);
	}

	/**
	* Creates a new assignment with the primary key. Does not add the assignment to the database.
	*
	* @param assignmentId the primary key for the new assignment
	* @return the new assignment
	*/
	public static com.ms3.training.services.model.Assignment create(
		long assignmentId) {
		return getPersistence().create(assignmentId);
	}

	/**
	* Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment that was removed
	* @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment remove(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence().remove(assignmentId);
	}

	public static com.ms3.training.services.model.Assignment updateImpl(
		com.ms3.training.services.model.Assignment assignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(assignment);
	}

	/**
	* Returns the assignment with the primary key or throws a {@link com.ms3.training.services.NoSuchAssignmentException} if it could not be found.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment
	* @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment findByPrimaryKey(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.training.services.NoSuchAssignmentException {
		return getPersistence().findByPrimaryKey(assignmentId);
	}

	/**
	* Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assignmentId the primary key of the assignment
	* @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ms3.training.services.model.Assignment fetchByPrimaryKey(
		long assignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(assignmentId);
	}

	/**
	* Returns all the assignments.
	*
	* @return the assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @return the range of assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.training.services.model.impl.AssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assignments
	* @param end the upper bound of the range of assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ms3.training.services.model.Assignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of assignments.
	*
	* @return the number of assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AssignmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AssignmentPersistence)PortletBeanLocatorUtil.locate(com.ms3.training.services.service.ClpSerializer.getServletContextName(),
					AssignmentPersistence.class.getName());

			ReferenceRegistry.registerReference(AssignmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AssignmentPersistence persistence) {
	}

	private static AssignmentPersistence _persistence;
}