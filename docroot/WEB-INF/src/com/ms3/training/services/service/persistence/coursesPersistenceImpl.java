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

import com.ms3.training.services.NoSuchsException;
import com.ms3.training.services.model.courses;
import com.ms3.training.services.model.impl.coursesImpl;
import com.ms3.training.services.model.impl.coursesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the courses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see coursesPersistence
 * @see coursesUtil
 * @generated
 */
public class coursesPersistenceImpl extends BasePersistenceImpl<courses>
	implements coursesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link coursesUtil} to access the courses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = coursesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, coursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, coursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, coursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, coursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] { Long.class.getName() },
			coursesModelImpl.COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the courseses where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching courseses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<courses> findByCourseId(long courseId)
		throws SystemException {
		return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<courses> findByCourseId(long courseId, int start, int end)
		throws SystemException {
		return findByCourseId(courseId, start, end, null);
	}

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
	@Override
	public List<courses> findByCourseId(long courseId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId, start, end, orderByComparator };
		}

		List<courses> list = (List<courses>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (courses courses : list) {
				if ((courseId != courses.getCourseId())) {
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

			query.append(_SQL_SELECT_COURSES_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(coursesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				if (!pagination) {
					list = (List<courses>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<courses>(list);
				}
				else {
					list = (List<courses>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first courses in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses findByCourseId_First(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchsException, SystemException {
		courses courses = fetchByCourseId_First(courseId, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchsException(msg.toString());
	}

	/**
	 * Returns the first courses in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses fetchByCourseId_First(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<courses> list = findByCourseId(courseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last courses in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses findByCourseId_Last(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchsException, SystemException {
		courses courses = fetchByCourseId_Last(courseId, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchsException(msg.toString());
	}

	/**
	 * Returns the last courses in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses fetchByCourseId_Last(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(courseId);

		if (count == 0) {
			return null;
		}

		List<courses> list = findByCourseId(courseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public courses[] findByCourseId_PrevAndNext(String title, long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchsException, SystemException {
		courses courses = findByPrimaryKey(title);

		Session session = null;

		try {
			session = openSession();

			courses[] array = new coursesImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, courses, courseId,
					orderByComparator, true);

			array[1] = courses;

			array[2] = getByCourseId_PrevAndNext(session, courses, courseId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected courses getByCourseId_PrevAndNext(Session session,
		courses courses, long courseId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSES_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

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
			query.append(coursesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courses);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<courses> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courseses where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseId(long courseId) throws SystemException {
		for (courses courses : findByCourseId(courseId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching courseses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseId(long courseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSES_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

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

	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "courses.courseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, coursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, coursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
			new String[] { String.class.getName() },
			coursesModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the courseses where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching courseses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<courses> findByTitle(String title) throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<courses> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

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
	@Override
	public List<courses> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<courses> list = (List<courses>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (courses courses : list) {
				if (!Validator.equals(title, courses.getTitle())) {
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

			query.append(_SQL_SELECT_COURSES_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(coursesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<courses>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<courses>(list);
				}
				else {
					list = (List<courses>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first courses in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchsException, SystemException {
		courses courses = fetchByTitle_First(title, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchsException(msg.toString());
	}

	/**
	 * Returns the first courses in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<courses> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last courses in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws com.ms3.training.services.NoSuchsException if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchsException, SystemException {
		courses courses = fetchByTitle_Last(title, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchsException(msg.toString());
	}

	/**
	 * Returns the last courses in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<courses> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the courseses where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitle(String title) throws SystemException {
		for (courses courses : findByTitle(title, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching courseses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitle(String title) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLE;

		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSES_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "courses.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "courses.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(courses.title IS NULL OR courses.title = '')";

	public coursesPersistenceImpl() {
		setModelClass(courses.class);
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	@Override
	public void cacheResult(courses courses) {
		EntityCacheUtil.putResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesImpl.class, courses.getPrimaryKey(), courses);

		courses.resetOriginalValues();
	}

	/**
	 * Caches the courseses in the entity cache if it is enabled.
	 *
	 * @param courseses the courseses
	 */
	@Override
	public void cacheResult(List<courses> courseses) {
		for (courses courses : courseses) {
			if (EntityCacheUtil.getResult(
						coursesModelImpl.ENTITY_CACHE_ENABLED,
						coursesImpl.class, courses.getPrimaryKey()) == null) {
				cacheResult(courses);
			}
			else {
				courses.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all courseses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(coursesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(coursesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(courses courses) {
		EntityCacheUtil.removeResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesImpl.class, courses.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<courses> courseses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (courses courses : courseses) {
			EntityCacheUtil.removeResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
				coursesImpl.class, courses.getPrimaryKey());
		}
	}

	/**
	 * Creates a new courses with the primary key. Does not add the courses to the database.
	 *
	 * @param title the primary key for the new courses
	 * @return the new courses
	 */
	@Override
	public courses create(String title) {
		courses courses = new coursesImpl();

		courses.setNew(true);
		courses.setPrimaryKey(title);

		return courses;
	}

	/**
	 * Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param title the primary key of the courses
	 * @return the courses that was removed
	 * @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses remove(String title)
		throws NoSuchsException, SystemException {
		return remove((Serializable)title);
	}

	/**
	 * Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the courses
	 * @return the courses that was removed
	 * @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses remove(Serializable primaryKey)
		throws NoSuchsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			courses courses = (courses)session.get(coursesImpl.class, primaryKey);

			if (courses == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courses);
		}
		catch (NoSuchsException nsee) {
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
	protected courses removeImpl(courses courses) throws SystemException {
		courses = toUnwrappedModel(courses);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courses)) {
				courses = (courses)session.get(coursesImpl.class,
						courses.getPrimaryKeyObj());
			}

			if (courses != null) {
				session.delete(courses);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courses != null) {
			clearCache(courses);
		}

		return courses;
	}

	@Override
	public courses updateImpl(com.ms3.training.services.model.courses courses)
		throws SystemException {
		courses = toUnwrappedModel(courses);

		boolean isNew = courses.isNew();

		coursesModelImpl coursesModelImpl = (coursesModelImpl)courses;

		Session session = null;

		try {
			session = openSession();

			if (courses.isNew()) {
				session.save(courses);

				courses.setNew(false);
			}
			else {
				session.merge(courses);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !coursesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((coursesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coursesModelImpl.getOriginalCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { coursesModelImpl.getCourseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((coursesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { coursesModelImpl.getOriginalTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { coursesModelImpl.getTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}
		}

		EntityCacheUtil.putResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
			coursesImpl.class, courses.getPrimaryKey(), courses);

		return courses;
	}

	protected courses toUnwrappedModel(courses courses) {
		if (courses instanceof coursesImpl) {
			return courses;
		}

		coursesImpl coursesImpl = new coursesImpl();

		coursesImpl.setNew(courses.isNew());
		coursesImpl.setPrimaryKey(courses.getPrimaryKey());

		coursesImpl.setTitle(courses.getTitle());
		coursesImpl.setDescription(courses.getDescription());
		coursesImpl.setListPrice(courses.getListPrice());
		coursesImpl.setProvider(courses.getProvider());
		coursesImpl.setCourseId(courses.getCourseId());

		return coursesImpl;
	}

	/**
	 * Returns the courses with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the courses
	 * @return the courses
	 * @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses findByPrimaryKey(Serializable primaryKey)
		throws NoSuchsException, SystemException {
		courses courses = fetchByPrimaryKey(primaryKey);

		if (courses == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courses;
	}

	/**
	 * Returns the courses with the primary key or throws a {@link com.ms3.training.services.NoSuchsException} if it could not be found.
	 *
	 * @param title the primary key of the courses
	 * @return the courses
	 * @throws com.ms3.training.services.NoSuchsException if a courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses findByPrimaryKey(String title)
		throws NoSuchsException, SystemException {
		return findByPrimaryKey((Serializable)title);
	}

	/**
	 * Returns the courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the courses
	 * @return the courses, or <code>null</code> if a courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		courses courses = (courses)EntityCacheUtil.getResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
				coursesImpl.class, primaryKey);

		if (courses == _nullcourses) {
			return null;
		}

		if (courses == null) {
			Session session = null;

			try {
				session = openSession();

				courses = (courses)session.get(coursesImpl.class, primaryKey);

				if (courses != null) {
					cacheResult(courses);
				}
				else {
					EntityCacheUtil.putResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
						coursesImpl.class, primaryKey, _nullcourses);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(coursesModelImpl.ENTITY_CACHE_ENABLED,
					coursesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courses;
	}

	/**
	 * Returns the courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param title the primary key of the courses
	 * @return the courses, or <code>null</code> if a courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public courses fetchByPrimaryKey(String title) throws SystemException {
		return fetchByPrimaryKey((Serializable)title);
	}

	/**
	 * Returns all the courseses.
	 *
	 * @return the courseses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<courses> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<courses> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<courses> findAll(int start, int end,
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

		List<courses> list = (List<courses>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSES;

				if (pagination) {
					sql = sql.concat(coursesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<courses>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<courses>(list);
				}
				else {
					list = (List<courses>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the courseses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (courses courses : findAll()) {
			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses.
	 *
	 * @return the number of courseses
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

				Query q = session.createQuery(_SQL_COUNT_COURSES);

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
	 * Initializes the courses persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ms3.training.services.model.courses")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<courses>> listenersList = new ArrayList<ModelListener<courses>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<courses>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(coursesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSES = "SELECT courses FROM courses courses";
	private static final String _SQL_SELECT_COURSES_WHERE = "SELECT courses FROM courses courses WHERE ";
	private static final String _SQL_COUNT_COURSES = "SELECT COUNT(courses) FROM courses courses";
	private static final String _SQL_COUNT_COURSES_WHERE = "SELECT COUNT(courses) FROM courses courses WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courses.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No courses exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No courses exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(coursesPersistenceImpl.class);
	private static courses _nullcourses = new coursesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<courses> toCacheModel() {
				return _nullcoursesCacheModel;
			}
		};

	private static CacheModel<courses> _nullcoursesCacheModel = new CacheModel<courses>() {
			@Override
			public courses toEntityModel() {
				return _nullcourses;
			}
		};
}