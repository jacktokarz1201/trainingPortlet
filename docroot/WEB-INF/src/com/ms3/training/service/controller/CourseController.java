package com.ms3.training.service.controller;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.ms3.training.services.model.courses;
import com.ms3.training.services.service.coursesLocalServiceUtil;
import com.ms3.training.services.service.persistence.coursesPersistenceImpl;

public class CourseController {

	public void viewCourses(ActionRequest request, ActionResponse response) {
		String courseTitle = request.getParameter("title");
		try {
			courses cou = coursesLocalServiceUtil.fetchcourses(courseTitle);
			System.out.println(cou.toString());
		}
		catch (SystemException e) {
			System.out.println("Server error.");
		}
		System.out.println("No course by name: "+courseTitle);
	}
	
}
