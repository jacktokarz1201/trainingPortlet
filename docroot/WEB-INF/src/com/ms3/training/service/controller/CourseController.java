package com.ms3.training.service.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ms3.training.services.model.Course;
import com.ms3.training.services.service.CourseLocalServiceUtil;


@Controller("CourseController")
@RequestMapping("VIEW")
public class CourseController extends MVCPortlet {
	
	@RenderMapping
	public String processRenderRequest(RenderRequest request,
			RenderResponse response, Model model) {		
		
		String fromString = (String)request.getAttribute("fromAction");
		if(fromString!=null) {
			System.out.println("From Action was passed! --> "+fromString);
		}
		
		try {
			List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			request.setAttribute("courses", courses);
			System.out.println("showing!");
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			SessionErrors.add(request, "errorGetCourses");
			e.printStackTrace();
		}
		String viewString = (String)request.getAttribute("viewCall");
		if(viewString!=null) {
			return "other";
		}
		
		return "view";
	}

	
	@ActionMapping(params = "action=addCourse")
	public void addCourse(ActionRequest request, ActionResponse response){
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		try {
			long courseId = CourseLocalServiceUtil.getCoursesCount()+1;
			System.out.println("courseId is 1 more than courses count, ie: "+courseId);
			String title = request.getParameter("title");
			
			String description = request.getParameter("description");
			String provider = request.getParameter("provider");		
			String listPrice = request.getParameter("listPrice");
			
			Course course = CourseLocalServiceUtil.createCourse(title);
			course.setTitle(title);
			course.setCourseId(courseId);
			course.setDescription(description);
			course.setProvider(provider);
			course.setListPrice(listPrice);
			CourseLocalServiceUtil.updateCourse(course);
			
			SessionMessages.add(request, "successAddCourse");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(request, "errorAddCourse");
		}
	}
	
	@ActionMapping(params = "action=findCourseByTitle")
	public void findCourseByTitle(ActionRequest request, ActionResponse response) throws PortletException, IOException{
		List<Course> courseResults;
		String searchCriteria = request.getParameter("searchTitle");
		
		PortletPreferences prefs = request.getPreferences();
		String title= request.getParameter("searchTitle");
		if( title != null) {
			prefs.setValue("title", title);
			prefs.store();
		}
		
		if(searchCriteria == null) {
			System.out.println("You must put in a query to get a result.");
			return;
		}
		request.setAttribute("fromAction", searchCriteria);
		try {
			if(CourseLocalServiceUtil.getCoursesCount()==0) {
				System.out.println("There are no courses to view.");
				return;
			}
			courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			for(Course objectCourse: courseResults) {
				if(objectCourse.getTitle().equals(searchCriteria)) {
					System.out.println("You found it! \n courseId: "+objectCourse.getCourseId()+" \ncourseName: "+objectCourse.getTitle()+
							" \ncourseDescription: "+objectCourse.getDescription()+" \netc...\n");
					return;
				}
			}
			System.out.println("That course is not in our catalog.");
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
		}
		
	}
	
	
	@ActionMapping(params = "action=editCourse")
	public void editCourse(ActionRequest request, ActionResponse response){
		
		String title = request.getParameter("title");
		Course course;
		try {
			course = CourseLocalServiceUtil.getCourse(title);
			if(request.getParameter("description")!=null) {
				course.setDescription(request.getParameter("description"));
			}
			if(request.getParameter("listPrice")!=null) {
				course.setListPrice(request.getParameter("listPrice"));
			}
			if(request.getParameter("provider")!=null) {
				course.setProvider(request.getParameter("provider"));
			}
			
			CourseLocalServiceUtil.updateCourse(course);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@ActionMapping(params = "action=viewCourses")
	public void viewCourses(ActionRequest request, ActionResponse response) {
		//System.out.println("ajax called");		
		
		request.setAttribute("viewCall", "viewTime");
		
		List<Course> courseResults;
		try {
//			String courseIdstr = request.getParameter("courseId");
//			long courseId = Long.parseLong(courseIdstr);
//			System.out.println("courseId: "+courseId);
			
			//courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			//DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Course.class).add(PropertyFactoryUtil.forName("courseId").eq(new Long(courseId)));
			//courses = CourseLocalServiceUtil.dynamicQuery(dynamicQuery,0,CourseLocalServiceUtil.getCoursesCount());
			//courses = CourseLocalServiceUtil.findByCourseId(courseId);
			
			if(CourseLocalServiceUtil.getCoursesCount()==0) {
				System.out.println("There are no courses to view.");
				return;
			}
			
			courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			//System.out.println("objectCourseResults.size: "+objectCourseResults.size());
			
			//Map<Long, CourseModel> courseResults = new HashMap<Long, CourseModel>();
			
			for(Course objectCourse: courseResults){
				
				System.out.println("courseId: "+objectCourse.getCourseId()+" \ncourseName: "+objectCourse.getTitle()+" \ncourseDescription: "+objectCourse.getDescription()+" \netc...\n");
				
			}
			
			//System.out.println("courses: "+courses.toString());
//			Gson coursesGson = new GsonBuilder().disableHtmlEscaping().create();
//			String coursesJson = coursesGson.toJson(courseResults);			
//			response.getWriter().println(coursesJson);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
		}
	}
}

