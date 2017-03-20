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
import com.ms3.training.services.NoSuchCourseException;
import com.ms3.training.services.model.Course;
import com.ms3.training.services.service.AssignmentLocalServiceUtil;
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
	//Where are we going?
		String viewString = (String)request.getAttribute("viewCall");
		if(viewString!=null) {
			return "other";
		}
		String assignCourseString = (String)request.getAttribute("goToAssignCourse");
		if(assignCourseString!=null) {
			return "assignCourse";
		}
		
		return "view";
	}

	
	@ActionMapping(params = "action=assignCoursePage")
	public void assignCoursePage(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
	System.out.println("Passed to assignCoursePage --> "+prefs.getValue("assignTitle", ""));
//		prefs.setValue("assignTitle", request.getParameter("assignTitle"));
//		prefs.store();
		request.setAttribute("goToAssignCourse", "true");
		
	}
	
	@ActionMapping(params = "action=assignToUser")
	public void assignToUser(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		
		String user = request.getParameter("user");
		String title = request.getParameter("assignTitle");
		System.out.println("User is "+user+", and title is "+title);
		//AssignmentLocalServiceUtil.addAssignment(assignment);
		if(user==null || title==null) {
			prefs.setValue("assignError", "Either the title or user isn't assigned.");
			prefs.store();
			request.setAttribute("goToAssignCourse", "true");
		}
		
	}
	
	@ActionMapping(params = "action=addCourse")
	public void addCourse(ActionRequest request, ActionResponse response){
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		PortletPreferences prefs = request.getPreferences();
		
		try {
	//take all inputs into strings
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String provider = request.getParameter("provider");
			String listPrice = request.getParameter("listPrice");
	//CHECK all fields are filled in.
			if(title.equals("") || description.equals("") || provider.equals("") || listPrice.equals("")) {
				prefs.setValue("addCourseError", "Make sure to fill in all of the fields.");
				prefs.store();
				return;
			}
			
			List<Course> courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			long highestId = CourseLocalServiceUtil.getCoursesCount();
			for(Course course: courseResults) {
				
	//CHECK the entered title doesn't already exist.
				if(title.equals(course.getTitle())) {
					prefs.setValue("addCourseError", "That title has already been used.");
					prefs.store();
					return;
				}
	//CHECK the new course id isn't used and is higher than the rest.
				if(highestId <= course.getCourseId()) {
					highestId = course.getCourseId();
				}
			}
			
			long courseId = highestId;
	//set a new course with these values and add it to the table.
			Course course = CourseLocalServiceUtil.createCourse(title);
			course.setTitle(title);
			course.setCourseId(courseId);
			course.setDescription(description);
			course.setProvider(provider);
			course.setListPrice(listPrice);
			CourseLocalServiceUtil.updateCourse(course);
			SessionMessages.add(request, "successAddCourse");
	//clear the error message
			prefs.setValue("addCourseError", "");
			prefs.store();
			
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
	//CHECK there is title input
		if(searchCriteria == null) {
			prefs.setValue("findCourseError", "You must put in a query to get a result.");
			prefs.store();
			return;
		}
		request.setAttribute("fromAction", searchCriteria);
		try {
			if(CourseLocalServiceUtil.getCoursesCount()==0) {
	//CHECK some courses exist
				prefs.setValue("findCourseError", "There are no stored courses.");
				prefs.store();
				return;
			}
			courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
	//CHECK title against all existing ones
			for(Course objectCourse: courseResults) {
				if(objectCourse.getTitle().equals(searchCriteria)) {
					System.out.println("You found it! \n courseId: "+objectCourse.getCourseId()+" \ncourseName: "+objectCourse.getTitle()+
							" \ncourseDescription: "+objectCourse.getDescription()+" \netc...\n");
					prefs.setValue("findCourseError", "");
					prefs.store();
					return;
				}
			}
			prefs.setValue("findCourseError", "A course by that title does not exist in our catalog.");
			prefs.store();
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
		}
		
	}
	
	
	@ActionMapping(params = "action=editCourse")
	public void editCourse(ActionRequest request, ActionResponse response) 
			throws PortletException, PortalException, SystemException, IOException{
		
		PortletPreferences prefs = request.getPreferences();
		
		String title = request.getParameter("title");
	//CHECK if they put in a title
		if(title==null) {
			prefs.setValue("editCourseError", "Put in a title.");
			prefs.store();
			request.setAttribute("viewCall", "viewTime");
			return;
		}
		
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
			prefs.setValue("editCourseError", "");
			prefs.store();
		}
		catch (NoSuchCourseException e) {
			prefs.setValue("editCourseError", "A course by that title is not in the catalog.");
			prefs.store();
			request.setAttribute("viewCall", "viewTime");
			return;
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

