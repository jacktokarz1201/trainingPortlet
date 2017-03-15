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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.ms3.training.services.NoSuch_assignmentException;
import com.ms3.training.services.model.course_assignment;
import com.ms3.training.services.model.impl.course_assignmentImpl;
import com.ms3.training.services.model.impl.course_assignmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course_assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see course_assignmentPersistence
 * @see course_assignmentUtil
 * @generated
 */
public class course_assignmentPersistenceImpl extends BasePersistenceImpl<course_assignment>
	implements course_assignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link course_assignmentUtil} to access the course_assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = course_assignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED,
			course_assignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED,
			course_assignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSES_TITLE =
		new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED,
			course_assignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourses_title",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE =
		new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED,
			course_assignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourses_title",
			new String[] { String.class.getName() },
			course_assignmentModelImpl.COURSES_TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSES_TITLE = new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourses_title",
			new String[] { String.class.getName() });

	/**
	 * Returns all the course_assignments where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @return the matching course_assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<course_assignment> findByCourses_title(String courses_title)
		throws SystemException {
		return findByCourses_title(courses_title, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<course_assignment> findByCourses_title(String courses_title,
		int start, int end) throws SystemException {
		return findByCourses_title(courses_title, start, end, null);
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
	@Override
	public List<course_assignment> findByCourses_title(String courses_title,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE;
			finderArgs = new Object[] { courses_title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSES_TITLE;
			finderArgs = new Object[] {
					courses_title,
					
					start, end, orderByComparator
				};
		}

		List<course_assignment> list = (List<course_assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (course_assignment course_assignment : list) {
				if (!Validator.equals(courses_title,
							course_assignment.getCourses_title())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_ASSIGNMENT_WHERE);

			boolean bindCourses_title = false;

			if (courses_title == null) {
				query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_1);
			}
			else if (courses_title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_3);
			}
			else {
				bindCourses_title = true;

				query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(course_assignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCourses_title) {
					qPos.add(courses_title);
				}

				if (!pagination) {
					list = (List<course_assignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<course_assignment>(list);
				}
				else {
					list = (List<course_assignment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public course_assignment findByCourses_title_First(String courses_title,
		OrderByComparator orderByComparator)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = fetchByCourses_title_First(courses_title,
				orderByComparator);

		if (course_assignment != null) {
			return course_assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courses_title=");
		msg.append(courses_title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuch_assignmentException(msg.toString());
	}

	/**
	 * Returns the first course_assignment in the ordered set where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment fetchByCourses_title_First(String courses_title,
		OrderByComparator orderByComparator) throws SystemException {
		List<course_assignment> list = findByCourses_title(courses_title, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course_assignment findByCourses_title_Last(String courses_title,
		OrderByComparator orderByComparator)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = fetchByCourses_title_Last(courses_title,
				orderByComparator);

		if (course_assignment != null) {
			return course_assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courses_title=");
		msg.append(courses_title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuch_assignmentException(msg.toString());
	}

	/**
	 * Returns the last course_assignment in the ordered set where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment fetchByCourses_title_Last(String courses_title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourses_title(courses_title);

		if (count == 0) {
			return null;
		}

		List<course_assignment> list = findByCourses_title(courses_title,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course_assignment[] findByCourses_title_PrevAndNext(
		long assignmentId, String courses_title,
		OrderByComparator orderByComparator)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = findByPrimaryKey(assignmentId);

		Session session = null;

		try {
			session = openSession();

			course_assignment[] array = new course_assignmentImpl[3];

			array[0] = getByCourses_title_PrevAndNext(session,
					course_assignment, courses_title, orderByComparator, true);

			array[1] = course_assignment;

			array[2] = getByCourses_title_PrevAndNext(session,
					course_assignment, courses_title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected course_assignment getByCourses_title_PrevAndNext(
		Session session, course_assignment course_assignment,
		String courses_title, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_ASSIGNMENT_WHERE);

		boolean bindCourses_title = false;

		if (courses_title == null) {
			query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_1);
		}
		else if (courses_title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_3);
		}
		else {
			bindCourses_title = true;

			query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(course_assignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCourses_title) {
			qPos.add(courses_title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course_assignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<course_assignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course_assignments where courses_title = &#63; from the database.
	 *
	 * @param courses_title the courses_title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourses_title(String courses_title)
		throws SystemException {
		for (course_assignment course_assignment : findByCourses_title(
				courses_title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(course_assignment);
		}
	}

	/**
	 * Returns the number of course_assignments where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @return the number of matching course_assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourses_title(String courses_title)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSES_TITLE;

		Object[] finderArgs = new Object[] { courses_title };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_ASSIGNMENT_WHERE);

			boolean bindCourses_title = false;

			if (courses_title == null) {
				query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_1);
			}
			else if (courses_title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_3);
			}
			else {
				bindCourses_title = true;

				query.append(_FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCourses_title) {
					qPos.add(courses_title);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_1 = "course_assignment.courses_title IS NULL";
	private static final String _FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_2 = "course_assignment.courses_title = ?";
	private static final String _FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_3 = "(course_assignment.courses_title IS NULL OR course_assignment.courses_title = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID =
		new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED,
			course_assignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMs3employeedb_uid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID =
		new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED,
			course_assignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMs3employeedb_uid", new String[] { String.class.getName() },
			course_assignmentModelImpl.MS3EMPLOYEEDB_UID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID = new FinderPath(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMs3employeedb_uid", new String[] { String.class.getName() });

	/**
	 * Returns all the course_assignments where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @return the matching course_assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<course_assignment> findByMs3employeedb_uid(
		String ms3employeedb_uid) throws SystemException {
		return findByMs3employeedb_uid(ms3employeedb_uid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<course_assignment> findByMs3employeedb_uid(
		String ms3employeedb_uid, int start, int end) throws SystemException {
		return findByMs3employeedb_uid(ms3employeedb_uid, start, end, null);
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
	@Override
	public List<course_assignment> findByMs3employeedb_uid(
		String ms3employeedb_uid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID;
			finderArgs = new Object[] { ms3employeedb_uid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID;
			finderArgs = new Object[] {
					ms3employeedb_uid,
					
					start, end, orderByComparator
				};
		}

		List<course_assignment> list = (List<course_assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (course_assignment course_assignment : list) {
				if (!Validator.equals(ms3employeedb_uid,
							course_assignment.getMs3employeedb_uid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_ASSIGNMENT_WHERE);

			boolean bindMs3employeedb_uid = false;

			if (ms3employeedb_uid == null) {
				query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_1);
			}
			else if (ms3employeedb_uid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_3);
			}
			else {
				bindMs3employeedb_uid = true;

				query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(course_assignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMs3employeedb_uid) {
					qPos.add(ms3employeedb_uid);
				}

				if (!pagination) {
					list = (List<course_assignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<course_assignment>(list);
				}
				else {
					list = (List<course_assignment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public course_assignment findByMs3employeedb_uid_First(
		String ms3employeedb_uid, OrderByComparator orderByComparator)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = fetchByMs3employeedb_uid_First(ms3employeedb_uid,
				orderByComparator);

		if (course_assignment != null) {
			return course_assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ms3employeedb_uid=");
		msg.append(ms3employeedb_uid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuch_assignmentException(msg.toString());
	}

	/**
	 * Returns the first course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment fetchByMs3employeedb_uid_First(
		String ms3employeedb_uid, OrderByComparator orderByComparator)
		throws SystemException {
		List<course_assignment> list = findByMs3employeedb_uid(ms3employeedb_uid,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course_assignment findByMs3employeedb_uid_Last(
		String ms3employeedb_uid, OrderByComparator orderByComparator)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = fetchByMs3employeedb_uid_Last(ms3employeedb_uid,
				orderByComparator);

		if (course_assignment != null) {
			return course_assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ms3employeedb_uid=");
		msg.append(ms3employeedb_uid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuch_assignmentException(msg.toString());
	}

	/**
	 * Returns the last course_assignment in the ordered set where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course_assignment, or <code>null</code> if a matching course_assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment fetchByMs3employeedb_uid_Last(
		String ms3employeedb_uid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMs3employeedb_uid(ms3employeedb_uid);

		if (count == 0) {
			return null;
		}

		List<course_assignment> list = findByMs3employeedb_uid(ms3employeedb_uid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course_assignment[] findByMs3employeedb_uid_PrevAndNext(
		long assignmentId, String ms3employeedb_uid,
		OrderByComparator orderByComparator)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = findByPrimaryKey(assignmentId);

		Session session = null;

		try {
			session = openSession();

			course_assignment[] array = new course_assignmentImpl[3];

			array[0] = getByMs3employeedb_uid_PrevAndNext(session,
					course_assignment, ms3employeedb_uid, orderByComparator,
					true);

			array[1] = course_assignment;

			array[2] = getByMs3employeedb_uid_PrevAndNext(session,
					course_assignment, ms3employeedb_uid, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected course_assignment getByMs3employeedb_uid_PrevAndNext(
		Session session, course_assignment course_assignment,
		String ms3employeedb_uid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_ASSIGNMENT_WHERE);

		boolean bindMs3employeedb_uid = false;

		if (ms3employeedb_uid == null) {
			query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_1);
		}
		else if (ms3employeedb_uid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_3);
		}
		else {
			bindMs3employeedb_uid = true;

			query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(course_assignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMs3employeedb_uid) {
			qPos.add(ms3employeedb_uid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course_assignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<course_assignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course_assignments where ms3employeedb_uid = &#63; from the database.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMs3employeedb_uid(String ms3employeedb_uid)
		throws SystemException {
		for (course_assignment course_assignment : findByMs3employeedb_uid(
				ms3employeedb_uid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(course_assignment);
		}
	}

	/**
	 * Returns the number of course_assignments where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @return the number of matching course_assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMs3employeedb_uid(String ms3employeedb_uid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID;

		Object[] finderArgs = new Object[] { ms3employeedb_uid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_ASSIGNMENT_WHERE);

			boolean bindMs3employeedb_uid = false;

			if (ms3employeedb_uid == null) {
				query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_1);
			}
			else if (ms3employeedb_uid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_3);
			}
			else {
				bindMs3employeedb_uid = true;

				query.append(_FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMs3employeedb_uid) {
					qPos.add(ms3employeedb_uid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_1 =
		"course_assignment.ms3employeedb_uid IS NULL";
	private static final String _FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_2 =
		"course_assignment.ms3employeedb_uid = ?";
	private static final String _FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_3 =
		"(course_assignment.ms3employeedb_uid IS NULL OR course_assignment.ms3employeedb_uid = '')";

	public course_assignmentPersistenceImpl() {
		setModelClass(course_assignment.class);
	}

	/**
	 * Caches the course_assignment in the entity cache if it is enabled.
	 *
	 * @param course_assignment the course_assignment
	 */
	@Override
	public void cacheResult(course_assignment course_assignment) {
		EntityCacheUtil.putResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentImpl.class, course_assignment.getPrimaryKey(),
			course_assignment);

		course_assignment.resetOriginalValues();
	}

	/**
	 * Caches the course_assignments in the entity cache if it is enabled.
	 *
	 * @param course_assignments the course_assignments
	 */
	@Override
	public void cacheResult(List<course_assignment> course_assignments) {
		for (course_assignment course_assignment : course_assignments) {
			if (EntityCacheUtil.getResult(
						course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
						course_assignmentImpl.class,
						course_assignment.getPrimaryKey()) == null) {
				cacheResult(course_assignment);
			}
			else {
				course_assignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course_assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(course_assignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(course_assignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course_assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(course_assignment course_assignment) {
		EntityCacheUtil.removeResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentImpl.class, course_assignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<course_assignment> course_assignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (course_assignment course_assignment : course_assignments) {
			EntityCacheUtil.removeResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
				course_assignmentImpl.class, course_assignment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course_assignment with the primary key. Does not add the course_assignment to the database.
	 *
	 * @param assignmentId the primary key for the new course_assignment
	 * @return the new course_assignment
	 */
	@Override
	public course_assignment create(long assignmentId) {
		course_assignment course_assignment = new course_assignmentImpl();

		course_assignment.setNew(true);
		course_assignment.setPrimaryKey(assignmentId);

		return course_assignment;
	}

	/**
	 * Removes the course_assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assignmentId the primary key of the course_assignment
	 * @return the course_assignment that was removed
	 * @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment remove(long assignmentId)
		throws NoSuch_assignmentException, SystemException {
		return remove((Serializable)assignmentId);
	}

	/**
	 * Removes the course_assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course_assignment
	 * @return the course_assignment that was removed
	 * @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment remove(Serializable primaryKey)
		throws NoSuch_assignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			course_assignment course_assignment = (course_assignment)session.get(course_assignmentImpl.class,
					primaryKey);

			if (course_assignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuch_assignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(course_assignment);
		}
		catch (NoSuch_assignmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected course_assignment removeImpl(course_assignment course_assignment)
		throws SystemException {
		course_assignment = toUnwrappedModel(course_assignment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(course_assignment)) {
				course_assignment = (course_assignment)session.get(course_assignmentImpl.class,
						course_assignment.getPrimaryKeyObj());
			}

			if (course_assignment != null) {
				session.delete(course_assignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (course_assignment != null) {
			clearCache(course_assignment);
		}

		return course_assignment;
	}

	@Override
	public course_assignment updateImpl(
		com.ms3.training.services.model.course_assignment course_assignment)
		throws SystemException {
		course_assignment = toUnwrappedModel(course_assignment);

		boolean isNew = course_assignment.isNew();

		course_assignmentModelImpl course_assignmentModelImpl = (course_assignmentModelImpl)course_assignment;

		Session session = null;

		try {
			session = openSession();

			if (course_assignment.isNew()) {
				session.save(course_assignment);

				course_assignment.setNew(false);
			}
			else {
				session.merge(course_assignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !course_assignmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((course_assignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						course_assignmentModelImpl.getOriginalCourses_title()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSES_TITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE,
					args);

				args = new Object[] {
						course_assignmentModelImpl.getCourses_title()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSES_TITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE,
					args);
			}

			if ((course_assignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						course_assignmentModelImpl.getOriginalMs3employeedb_uid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID,
					args);

				args = new Object[] {
						course_assignmentModelImpl.getMs3employeedb_uid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID,
					args);
			}
		}

		EntityCacheUtil.putResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
			course_assignmentImpl.class, course_assignment.getPrimaryKey(),
			course_assignment);

		return course_assignment;
	}

	protected course_assignment toUnwrappedModel(
		course_assignment course_assignment) {
		if (course_assignment instanceof course_assignmentImpl) {
			return course_assignment;
		}

		course_assignmentImpl course_assignmentImpl = new course_assignmentImpl();

		course_assignmentImpl.setNew(course_assignment.isNew());
		course_assignmentImpl.setPrimaryKey(course_assignment.getPrimaryKey());

		course_assignmentImpl.setCourses_title(course_assignment.getCourses_title());
		course_assignmentImpl.setMs3employeedb_uid(course_assignment.getMs3employeedb_uid());
		course_assignmentImpl.setStartDate(course_assignment.getStartDate());
		course_assignmentImpl.setEndDate(course_assignment.getEndDate());
		course_assignmentImpl.setNotes(course_assignment.getNotes());
		course_assignmentImpl.setCost(course_assignment.getCost());
		course_assignmentImpl.setCertification(course_assignment.isCertification());
		course_assignmentImpl.setAssignmentId(course_assignment.getAssignmentId());

		return course_assignmentImpl;
	}

	/**
	 * Returns the course_assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course_assignment
	 * @return the course_assignment
	 * @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuch_assignmentException, SystemException {
		course_assignment course_assignment = fetchByPrimaryKey(primaryKey);

		if (course_assignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuch_assignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return course_assignment;
	}

	/**
	 * Returns the course_assignment with the primary key or throws a {@link com.ms3.training.services.NoSuch_assignmentException} if it could not be found.
	 *
	 * @param assignmentId the primary key of the course_assignment
	 * @return the course_assignment
	 * @throws com.ms3.training.services.NoSuch_assignmentException if a course_assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment findByPrimaryKey(long assignmentId)
		throws NoSuch_assignmentException, SystemException {
		return findByPrimaryKey((Serializable)assignmentId);
	}

	/**
	 * Returns the course_assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course_assignment
	 * @return the course_assignment, or <code>null</code> if a course_assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		course_assignment course_assignment = (course_assignment)EntityCacheUtil.getResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
				course_assignmentImpl.class, primaryKey);

		if (course_assignment == _nullcourse_assignment) {
			return null;
		}

		if (course_assignment == null) {
			Session session = null;

			try {
				session = openSession();

				course_assignment = (course_assignment)session.get(course_assignmentImpl.class,
						primaryKey);

				if (course_assignment != null) {
					cacheResult(course_assignment);
				}
				else {
					EntityCacheUtil.putResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
						course_assignmentImpl.class, primaryKey,
						_nullcourse_assignment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(course_assignmentModelImpl.ENTITY_CACHE_ENABLED,
					course_assignmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return course_assignment;
	}

	/**
	 * Returns the course_assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assignmentId the primary key of the course_assignment
	 * @return the course_assignment, or <code>null</code> if a course_assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public course_assignment fetchByPrimaryKey(long assignmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)assignmentId);
	}

	/**
	 * Returns all the course_assignments.
	 *
	 * @return the course_assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<course_assignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<course_assignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<course_assignment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<course_assignment> list = (List<course_assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSE_ASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE_ASSIGNMENT;

				if (pagination) {
					sql = sql.concat(course_assignmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<course_assignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<course_assignment>(list);
				}
				else {
					list = (List<course_assignment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the course_assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (course_assignment course_assignment : findAll()) {
			remove(course_assignment);
		}
	}

	/**
	 * Returns the number of course_assignments.
	 *
	 * @return the number of course_assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSE_ASSIGNMENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the course_assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ms3.training.services.model.course_assignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<course_assignment>> listenersList = new ArrayList<ModelListener<course_assignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<course_assignment>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(course_assignmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSE_ASSIGNMENT = "SELECT course_assignment FROM course_assignment course_assignment";
	private static final String _SQL_SELECT_COURSE_ASSIGNMENT_WHERE = "SELECT course_assignment FROM course_assignment course_assignment WHERE ";
	private static final String _SQL_COUNT_COURSE_ASSIGNMENT = "SELECT COUNT(course_assignment) FROM course_assignment course_assignment";
	private static final String _SQL_COUNT_COURSE_ASSIGNMENT_WHERE = "SELECT COUNT(course_assignment) FROM course_assignment course_assignment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "course_assignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No course_assignment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No course_assignment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(course_assignmentPersistenceImpl.class);
	private static course_assignment _nullcourse_assignment = new course_assignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<course_assignment> toCacheModel() {
				return _nullcourse_assignmentCacheModel;
			}
		};

	private static CacheModel<course_assignment> _nullcourse_assignmentCacheModel =
		new CacheModel<course_assignment>() {
			@Override
			public course_assignment toEntityModel() {
				return _nullcourse_assignment;
			}
		};
}