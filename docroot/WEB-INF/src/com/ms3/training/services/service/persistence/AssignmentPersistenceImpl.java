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

import com.ms3.training.services.NoSuchAssignmentException;
import com.ms3.training.services.model.Assignment;
import com.ms3.training.services.model.impl.AssignmentImpl;
import com.ms3.training.services.model.impl.AssignmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see AssignmentPersistence
 * @see AssignmentUtil
 * @generated
 */
public class AssignmentPersistenceImpl extends BasePersistenceImpl<Assignment>
	implements AssignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssignmentUtil} to access the assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSES_TITLE =
		new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourses_title",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE =
		new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourses_title",
			new String[] { String.class.getName() },
			AssignmentModelImpl.COURSES_TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSES_TITLE = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourses_title",
			new String[] { String.class.getName() });

	/**
	 * Returns all the assignments where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @return the matching assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assignment> findByCourses_title(String courses_title)
		throws SystemException {
		return findByCourses_title(courses_title, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Assignment> findByCourses_title(String courses_title,
		int start, int end) throws SystemException {
		return findByCourses_title(courses_title, start, end, null);
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
	@Override
	public List<Assignment> findByCourses_title(String courses_title,
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

		List<Assignment> list = (List<Assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Assignment assignment : list) {
				if (!Validator.equals(courses_title,
							assignment.getCourses_title())) {
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

			query.append(_SQL_SELECT_ASSIGNMENT_WHERE);

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
				query.append(AssignmentModelImpl.ORDER_BY_JPQL);
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
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assignment>(list);
				}
				else {
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first assignment in the ordered set where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByCourses_title_First(String courses_title,
		OrderByComparator orderByComparator)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByCourses_title_First(courses_title,
				orderByComparator);

		if (assignment != null) {
			return assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courses_title=");
		msg.append(courses_title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssignmentException(msg.toString());
	}

	/**
	 * Returns the first assignment in the ordered set where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByCourses_title_First(String courses_title,
		OrderByComparator orderByComparator) throws SystemException {
		List<Assignment> list = findByCourses_title(courses_title, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Assignment findByCourses_title_Last(String courses_title,
		OrderByComparator orderByComparator)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByCourses_title_Last(courses_title,
				orderByComparator);

		if (assignment != null) {
			return assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courses_title=");
		msg.append(courses_title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssignmentException(msg.toString());
	}

	/**
	 * Returns the last assignment in the ordered set where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByCourses_title_Last(String courses_title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourses_title(courses_title);

		if (count == 0) {
			return null;
		}

		List<Assignment> list = findByCourses_title(courses_title, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Assignment[] findByCourses_title_PrevAndNext(long assignmentId,
		String courses_title, OrderByComparator orderByComparator)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = findByPrimaryKey(assignmentId);

		Session session = null;

		try {
			session = openSession();

			Assignment[] array = new AssignmentImpl[3];

			array[0] = getByCourses_title_PrevAndNext(session, assignment,
					courses_title, orderByComparator, true);

			array[1] = assignment;

			array[2] = getByCourses_title_PrevAndNext(session, assignment,
					courses_title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Assignment getByCourses_title_PrevAndNext(Session session,
		Assignment assignment, String courses_title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSIGNMENT_WHERE);

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
			query.append(AssignmentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(assignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Assignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the assignments where courses_title = &#63; from the database.
	 *
	 * @param courses_title the courses_title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourses_title(String courses_title)
		throws SystemException {
		for (Assignment assignment : findByCourses_title(courses_title,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(assignment);
		}
	}

	/**
	 * Returns the number of assignments where courses_title = &#63;.
	 *
	 * @param courses_title the courses_title
	 * @return the number of matching assignments
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

			query.append(_SQL_COUNT_ASSIGNMENT_WHERE);

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

	private static final String _FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_1 = "assignment.courses_title IS NULL";
	private static final String _FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_2 = "assignment.courses_title = ?";
	private static final String _FINDER_COLUMN_COURSES_TITLE_COURSES_TITLE_3 = "(assignment.courses_title IS NULL OR assignment.courses_title = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID =
		new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMs3employeedb_uid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID =
		new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMs3employeedb_uid", new String[] { String.class.getName() },
			AssignmentModelImpl.MS3EMPLOYEEDB_UID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMs3employeedb_uid", new String[] { String.class.getName() });

	/**
	 * Returns all the assignments where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @return the matching assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assignment> findByMs3employeedb_uid(String ms3employeedb_uid)
		throws SystemException {
		return findByMs3employeedb_uid(ms3employeedb_uid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Assignment> findByMs3employeedb_uid(String ms3employeedb_uid,
		int start, int end) throws SystemException {
		return findByMs3employeedb_uid(ms3employeedb_uid, start, end, null);
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
	@Override
	public List<Assignment> findByMs3employeedb_uid(String ms3employeedb_uid,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<Assignment> list = (List<Assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Assignment assignment : list) {
				if (!Validator.equals(ms3employeedb_uid,
							assignment.getMs3employeedb_uid())) {
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

			query.append(_SQL_SELECT_ASSIGNMENT_WHERE);

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
				query.append(AssignmentModelImpl.ORDER_BY_JPQL);
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
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assignment>(list);
				}
				else {
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first assignment in the ordered set where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByMs3employeedb_uid_First(String ms3employeedb_uid,
		OrderByComparator orderByComparator)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByMs3employeedb_uid_First(ms3employeedb_uid,
				orderByComparator);

		if (assignment != null) {
			return assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ms3employeedb_uid=");
		msg.append(ms3employeedb_uid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssignmentException(msg.toString());
	}

	/**
	 * Returns the first assignment in the ordered set where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByMs3employeedb_uid_First(String ms3employeedb_uid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Assignment> list = findByMs3employeedb_uid(ms3employeedb_uid, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Assignment findByMs3employeedb_uid_Last(String ms3employeedb_uid,
		OrderByComparator orderByComparator)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByMs3employeedb_uid_Last(ms3employeedb_uid,
				orderByComparator);

		if (assignment != null) {
			return assignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ms3employeedb_uid=");
		msg.append(ms3employeedb_uid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssignmentException(msg.toString());
	}

	/**
	 * Returns the last assignment in the ordered set where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByMs3employeedb_uid_Last(String ms3employeedb_uid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMs3employeedb_uid(ms3employeedb_uid);

		if (count == 0) {
			return null;
		}

		List<Assignment> list = findByMs3employeedb_uid(ms3employeedb_uid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Assignment[] findByMs3employeedb_uid_PrevAndNext(long assignmentId,
		String ms3employeedb_uid, OrderByComparator orderByComparator)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = findByPrimaryKey(assignmentId);

		Session session = null;

		try {
			session = openSession();

			Assignment[] array = new AssignmentImpl[3];

			array[0] = getByMs3employeedb_uid_PrevAndNext(session, assignment,
					ms3employeedb_uid, orderByComparator, true);

			array[1] = assignment;

			array[2] = getByMs3employeedb_uid_PrevAndNext(session, assignment,
					ms3employeedb_uid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Assignment getByMs3employeedb_uid_PrevAndNext(Session session,
		Assignment assignment, String ms3employeedb_uid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSIGNMENT_WHERE);

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
			query.append(AssignmentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(assignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Assignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the assignments where ms3employeedb_uid = &#63; from the database.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMs3employeedb_uid(String ms3employeedb_uid)
		throws SystemException {
		for (Assignment assignment : findByMs3employeedb_uid(
				ms3employeedb_uid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(assignment);
		}
	}

	/**
	 * Returns the number of assignments where ms3employeedb_uid = &#63;.
	 *
	 * @param ms3employeedb_uid the ms3employeedb_uid
	 * @return the number of matching assignments
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

			query.append(_SQL_COUNT_ASSIGNMENT_WHERE);

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
		"assignment.ms3employeedb_uid IS NULL";
	private static final String _FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_2 =
		"assignment.ms3employeedb_uid = ?";
	private static final String _FINDER_COLUMN_MS3EMPLOYEEDB_UID_MS3EMPLOYEEDB_UID_3 =
		"(assignment.ms3employeedb_uid IS NULL OR assignment.ms3employeedb_uid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_ASSIGNMENTID = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, AssignmentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByassignmentId",
			new String[] { Long.class.getName() },
			AssignmentModelImpl.ASSIGNMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNMENTID = new FinderPath(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassignmentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the assignment where assignmentId = &#63; or throws a {@link com.ms3.training.services.NoSuchAssignmentException} if it could not be found.
	 *
	 * @param assignmentId the assignment ID
	 * @return the matching assignment
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByassignmentId(long assignmentId)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByassignmentId(assignmentId);

		if (assignment == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assignmentId=");
			msg.append(assignmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAssignmentException(msg.toString());
		}

		return assignment;
	}

	/**
	 * Returns the assignment where assignmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assignmentId the assignment ID
	 * @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByassignmentId(long assignmentId)
		throws SystemException {
		return fetchByassignmentId(assignmentId, true);
	}

	/**
	 * Returns the assignment where assignmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assignmentId the assignment ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByassignmentId(long assignmentId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { assignmentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID,
					finderArgs, this);
		}

		if (result instanceof Assignment) {
			Assignment assignment = (Assignment)result;

			if ((assignmentId != assignment.getAssignmentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_ASSIGNMENTID_ASSIGNMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assignmentId);

				List<Assignment> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AssignmentPersistenceImpl.fetchByassignmentId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Assignment assignment = list.get(0);

					result = assignment;

					cacheResult(assignment);

					if ((assignment.getAssignmentId() != assignmentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID,
							finderArgs, assignment);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Assignment)result;
		}
	}

	/**
	 * Removes the assignment where assignmentId = &#63; from the database.
	 *
	 * @param assignmentId the assignment ID
	 * @return the assignment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment removeByassignmentId(long assignmentId)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = findByassignmentId(assignmentId);

		return remove(assignment);
	}

	/**
	 * Returns the number of assignments where assignmentId = &#63;.
	 *
	 * @param assignmentId the assignment ID
	 * @return the number of matching assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByassignmentId(long assignmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSIGNMENTID;

		Object[] finderArgs = new Object[] { assignmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_ASSIGNMENTID_ASSIGNMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assignmentId);

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

	private static final String _FINDER_COLUMN_ASSIGNMENTID_ASSIGNMENTID_2 = "assignment.assignmentId = ?";

	public AssignmentPersistenceImpl() {
		setModelClass(Assignment.class);
	}

	/**
	 * Caches the assignment in the entity cache if it is enabled.
	 *
	 * @param assignment the assignment
	 */
	@Override
	public void cacheResult(Assignment assignment) {
		EntityCacheUtil.putResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentImpl.class, assignment.getPrimaryKey(), assignment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID,
			new Object[] { assignment.getAssignmentId() }, assignment);

		assignment.resetOriginalValues();
	}

	/**
	 * Caches the assignments in the entity cache if it is enabled.
	 *
	 * @param assignments the assignments
	 */
	@Override
	public void cacheResult(List<Assignment> assignments) {
		for (Assignment assignment : assignments) {
			if (EntityCacheUtil.getResult(
						AssignmentModelImpl.ENTITY_CACHE_ENABLED,
						AssignmentImpl.class, assignment.getPrimaryKey()) == null) {
				cacheResult(assignment);
			}
			else {
				assignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AssignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AssignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Assignment assignment) {
		EntityCacheUtil.removeResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentImpl.class, assignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(assignment);
	}

	@Override
	public void clearCache(List<Assignment> assignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Assignment assignment : assignments) {
			EntityCacheUtil.removeResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
				AssignmentImpl.class, assignment.getPrimaryKey());

			clearUniqueFindersCache(assignment);
		}
	}

	protected void cacheUniqueFindersCache(Assignment assignment) {
		if (assignment.isNew()) {
			Object[] args = new Object[] { assignment.getAssignmentId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSIGNMENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID, args,
				assignment);
		}
		else {
			AssignmentModelImpl assignmentModelImpl = (AssignmentModelImpl)assignment;

			if ((assignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ASSIGNMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { assignment.getAssignmentId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSIGNMENTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID,
					args, assignment);
			}
		}
	}

	protected void clearUniqueFindersCache(Assignment assignment) {
		AssignmentModelImpl assignmentModelImpl = (AssignmentModelImpl)assignment;

		Object[] args = new Object[] { assignment.getAssignmentId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID, args);

		if ((assignmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ASSIGNMENTID.getColumnBitmask()) != 0) {
			args = new Object[] { assignmentModelImpl.getOriginalAssignmentId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSIGNMENTID, args);
		}
	}

	/**
	 * Creates a new assignment with the primary key. Does not add the assignment to the database.
	 *
	 * @param assignmentId the primary key for the new assignment
	 * @return the new assignment
	 */
	@Override
	public Assignment create(long assignmentId) {
		Assignment assignment = new AssignmentImpl();

		assignment.setNew(true);
		assignment.setPrimaryKey(assignmentId);

		return assignment;
	}

	/**
	 * Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment that was removed
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment remove(long assignmentId)
		throws NoSuchAssignmentException, SystemException {
		return remove((Serializable)assignmentId);
	}

	/**
	 * Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the assignment
	 * @return the assignment that was removed
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment remove(Serializable primaryKey)
		throws NoSuchAssignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Assignment assignment = (Assignment)session.get(AssignmentImpl.class,
					primaryKey);

			if (assignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(assignment);
		}
		catch (NoSuchAssignmentException nsee) {
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
	protected Assignment removeImpl(Assignment assignment)
		throws SystemException {
		assignment = toUnwrappedModel(assignment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(assignment)) {
				assignment = (Assignment)session.get(AssignmentImpl.class,
						assignment.getPrimaryKeyObj());
			}

			if (assignment != null) {
				session.delete(assignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (assignment != null) {
			clearCache(assignment);
		}

		return assignment;
	}

	@Override
	public Assignment updateImpl(
		com.ms3.training.services.model.Assignment assignment)
		throws SystemException {
		assignment = toUnwrappedModel(assignment);

		boolean isNew = assignment.isNew();

		AssignmentModelImpl assignmentModelImpl = (AssignmentModelImpl)assignment;

		Session session = null;

		try {
			session = openSession();

			if (assignment.isNew()) {
				session.save(assignment);

				assignment.setNew(false);
			}
			else {
				session.merge(assignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AssignmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((assignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assignmentModelImpl.getOriginalCourses_title()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSES_TITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE,
					args);

				args = new Object[] { assignmentModelImpl.getCourses_title() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSES_TITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSES_TITLE,
					args);
			}

			if ((assignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assignmentModelImpl.getOriginalMs3employeedb_uid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID,
					args);

				args = new Object[] { assignmentModelImpl.getMs3employeedb_uid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MS3EMPLOYEEDB_UID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MS3EMPLOYEEDB_UID,
					args);
			}
		}

		EntityCacheUtil.putResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
			AssignmentImpl.class, assignment.getPrimaryKey(), assignment);

		clearUniqueFindersCache(assignment);
		cacheUniqueFindersCache(assignment);

		return assignment;
	}

	protected Assignment toUnwrappedModel(Assignment assignment) {
		if (assignment instanceof AssignmentImpl) {
			return assignment;
		}

		AssignmentImpl assignmentImpl = new AssignmentImpl();

		assignmentImpl.setNew(assignment.isNew());
		assignmentImpl.setPrimaryKey(assignment.getPrimaryKey());

		assignmentImpl.setCourses_title(assignment.getCourses_title());
		assignmentImpl.setMs3employeedb_uid(assignment.getMs3employeedb_uid());
		assignmentImpl.setAssignedDate(assignment.getAssignedDate());
		assignmentImpl.setStartDate(assignment.getStartDate());
		assignmentImpl.setEndDate(assignment.getEndDate());
		assignmentImpl.setNotes(assignment.getNotes());
		assignmentImpl.setCost(assignment.getCost());
		assignmentImpl.setCertification(assignment.isCertification());
		assignmentImpl.setAssignmentId(assignment.getAssignmentId());

		return assignmentImpl;
	}

	/**
	 * Returns the assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the assignment
	 * @return the assignment
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssignmentException, SystemException {
		Assignment assignment = fetchByPrimaryKey(primaryKey);

		if (assignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return assignment;
	}

	/**
	 * Returns the assignment with the primary key or throws a {@link com.ms3.training.services.NoSuchAssignmentException} if it could not be found.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment
	 * @throws com.ms3.training.services.NoSuchAssignmentException if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment findByPrimaryKey(long assignmentId)
		throws NoSuchAssignmentException, SystemException {
		return findByPrimaryKey((Serializable)assignmentId);
	}

	/**
	 * Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the assignment
	 * @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Assignment assignment = (Assignment)EntityCacheUtil.getResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
				AssignmentImpl.class, primaryKey);

		if (assignment == _nullAssignment) {
			return null;
		}

		if (assignment == null) {
			Session session = null;

			try {
				session = openSession();

				assignment = (Assignment)session.get(AssignmentImpl.class,
						primaryKey);

				if (assignment != null) {
					cacheResult(assignment);
				}
				else {
					EntityCacheUtil.putResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
						AssignmentImpl.class, primaryKey, _nullAssignment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AssignmentModelImpl.ENTITY_CACHE_ENABLED,
					AssignmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return assignment;
	}

	/**
	 * Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assignment fetchByPrimaryKey(long assignmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)assignmentId);
	}

	/**
	 * Returns all the assignments.
	 *
	 * @return the assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Assignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Assignment> findAll(int start, int end,
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

		List<Assignment> list = (List<Assignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSIGNMENT;

				if (pagination) {
					sql = sql.concat(AssignmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assignment>(list);
				}
				else {
					list = (List<Assignment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Assignment assignment : findAll()) {
			remove(assignment);
		}
	}

	/**
	 * Returns the number of assignments.
	 *
	 * @return the number of assignments
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

				Query q = session.createQuery(_SQL_COUNT_ASSIGNMENT);

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
	 * Initializes the assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ms3.training.services.model.Assignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Assignment>> listenersList = new ArrayList<ModelListener<Assignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Assignment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AssignmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASSIGNMENT = "SELECT assignment FROM Assignment assignment";
	private static final String _SQL_SELECT_ASSIGNMENT_WHERE = "SELECT assignment FROM Assignment assignment WHERE ";
	private static final String _SQL_COUNT_ASSIGNMENT = "SELECT COUNT(assignment) FROM Assignment assignment";
	private static final String _SQL_COUNT_ASSIGNMENT_WHERE = "SELECT COUNT(assignment) FROM Assignment assignment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "assignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Assignment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Assignment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AssignmentPersistenceImpl.class);
	private static Assignment _nullAssignment = new AssignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Assignment> toCacheModel() {
				return _nullAssignmentCacheModel;
			}
		};

	private static CacheModel<Assignment> _nullAssignmentCacheModel = new CacheModel<Assignment>() {
			@Override
			public Assignment toEntityModel() {
				return _nullAssignment;
			}
		};
}