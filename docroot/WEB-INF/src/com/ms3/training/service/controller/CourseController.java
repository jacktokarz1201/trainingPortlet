package com.ms3.training.service.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ms3.training.services.NoSuchCourseException;
import com.ms3.training.services.model.Assignment;
import com.ms3.training.services.model.Course;
import com.ms3.training.services.service.AssignmentLocalServiceUtil;
import com.ms3.training.services.service.CourseLocalServiceUtil;


@Controller("CourseController")
@RequestMapping("VIEW")
public class CourseController extends MVCPortlet {
	@RenderMapping
	public String processRenderRequest(RenderRequest request,
			RenderResponse response, Model model) throws Exception {		
		PortletPreferences prefs = request.getPreferences();
//for permission and stuff
//  {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String permissableRole = GetterUtil.getString(prefs.getValue("ableRole", ""));
	System.out.println("Permission Role: "+permissableRole);
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		String hasPermission = "false";
		for(Role role: userRoles) {
			if(role.getName().equals(permissableRole)) {
				hasPermission = "true";
			}
		}
		prefs.setValue("hasPermission", hasPermission);
		prefs.store();
		
//  }
	
	//show the list of courses
		try {
			List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			request.setAttribute("courses", courses);
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			SessionErrors.add(request, "errorGetCourses");
			e.printStackTrace();
		}
		
	//Where are we going?
		String viewString = (String)request.getAttribute("goToEditCourse");
		if(viewString!=null) {
			return "editCourse";
		}
		String assignCourseString = (String)request.getAttribute("goToAssignCourse");
		if(assignCourseString!=null) {
			return "assignCourse";
		}
		String personalAssignmentsString = (String)request.getAttribute("goToPersonalAssignments");
		if(personalAssignmentsString!=null) {
			return "personalAssignments";
		}
		String viewUserAssignmentsString = (String)request.getAttribute("goToUserAssignments");
		if(viewUserAssignmentsString != null) {
			return "viewUserAssignments";
		}
		
		
		return "view";
	}

	
	
	
	@ActionMapping(params = "action=assignCoursePage")
	public void assignCoursePage(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("assignTitle", request.getParameter("submitTitle"));
		prefs.store();
		request.setAttribute("goToAssignCourse", "true");
	}
	
	@ActionMapping(params = "action=personalAssignmentsPage")
	public void personalAssignmentsPage(ActionRequest request, ActionResponse response) throws Exception{
		request.setAttribute("goToPersonalAssignments", "true");
	}
	
	@ActionMapping(params = "action=editCoursePage")
	public void editCoursePage(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("editTitle", request.getParameter("editTitle"));
		prefs.store();
		request.setAttribute("goToEditCourse", "true");
	}
	
	@ActionMapping(params = "action=viewUserAssignments")
	public void viewUserAssignments(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("userScreenName", request.getParameter("userAssignmentsScreenName"));
		prefs.store();
		request.setAttribute("goToUserAssignments", "true");
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
				request.setAttribute("addCourseError", "Make sure to fill in all of the fields.");
				return;
			}
			
			List<Course> courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
			long highestId = CourseLocalServiceUtil.getCoursesCount();
			for(Course course: courseResults) {
				
	//CHECK the entered title doesn't already exist.
				if(title.equals(course.getTitle())) {
					request.setAttribute("addCourseError", "That title has already been used.");
					return;
				}
	//CHECK the new course id isn't used and is higher than the rest.
				if(highestId <= course.getCourseId()) {
					highestId = course.getCourseId() + 1;
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(request, "errorAddCourse");
		}
	}
	
	@ActionMapping(params = "action=editCourse")
	public void editCourse(ActionRequest request, ActionResponse response) 
			throws PortletException, PortalException, SystemException, IOException{
		
		PortletPreferences prefs = request.getPreferences();
		
		String title = prefs.getValue("editTitle", "");
	//CHECK if they put in a title
		if(title==null) {
			request.setAttribute("editCourseError", "Put in a title.");
			request.setAttribute("goToEditCourse", "true");
			return;
		}
		
		Course course;
		try {
			course = CourseLocalServiceUtil.getCourse(title);
			if(!request.getParameter("description").equals("")) {
				course.setDescription(request.getParameter("description"));
			}
			if(!request.getParameter("listPrice").equals("")) {
				course.setListPrice(request.getParameter("listPrice"));
			}
			if(!request.getParameter("provider").equals("")) {
				course.setProvider(request.getParameter("provider"));
			}
			
			CourseLocalServiceUtil.updateCourse(course);	
			request.setAttribute("success", "The course "+course.getTitle()+" has been updated.");
		}
		catch (NoSuchCourseException e) {
			request.setAttribute("editCourseError", "A course by that title is not in the catalog.");
			request.setAttribute("goToEditCourse", "true");
			return;
		}
	}
	
	@ActionMapping(params = "action=deleteCourse")
	public void deleteCourse(ActionRequest request, ActionResponse response) {
		PortletPreferences prefs = request.getPreferences();
		String title = prefs.getValue("assignTitle", "");
		Course course;
		try {
			course = CourseLocalServiceUtil.getCourse(title);
			CourseLocalServiceUtil.deleteCourse(course);
			request.setAttribute("success", title+" was successfully deleted.");
		} catch (NoSuchCourseException e) {
			request.setAttribute("assignError", "A course by that title is not in the catalog.");
			request.setAttribute("goToAssignCourse", "true");
			return;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ActionMapping(params = "action=assignToUser")
	public void assignToUser(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		String screenName = request.getParameter("user");
		if(screenName == null || screenName.equals("")) {
			request.setAttribute("assignError", "Please fill in a screen name for the assignment.");
			request.setAttribute("goToAssignCourse", "true");
			return;
		}
		Long companyId = CompanyThreadLocal.getCompanyId();
		try {
	//to ensure user exists with catch
			User user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			String title = prefs.getValue("assignTitle", "");
	//to ensure course exists with catch
			Course course = CourseLocalServiceUtil.getCourse(title);
	//to ensure they aren't already assigned
			if(checkIfInAssignments(screenName, title)) {
				request.setAttribute("assignError", "The user "+screenName+" cannot be assigned "+title+".");
				request.setAttribute("goToAssignCourse", "true");
				return;
			}
		//make the assignment, with Id one higher than the existing highest
			long assignmentId = makeAssignmentId();
			Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
			assignment.setAssignedDate(setDate());
			assignment.setCourses_title(title);
			assignment.setMs3employeedb_uid(screenName);
			AssignmentLocalServiceUtil.addAssignment(assignment);
			request.setAttribute("success", "Your assignment of "+assignment.getCourses_title()+" to "+assignment.getMs3employeedb_uid()+" has been saved.");
		}
		catch (NoSuchUserException e) {
			request.setAttribute("assignError", "There are no users by that screen name.");
			request.setAttribute("goToAssignCourse", "true");
			return;
		}
		catch (NoSuchCourseException e) {
			request.setAttribute("assignError", "A course by that title is not in the catalog.");
			request.setAttribute("goToAssignCourse", "true");
			return;
		}
	}
	
	@ActionMapping(params = "action=requestCourse")
	public void requestCourse(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String title = request.getParameter("requestTitle");
		if(checkIfInAssignments(user.getScreenName(), title)) {
			request.setAttribute("requestError", "The user "+user.getScreenName()+" cannot request "+title+".");
			return;
		}
		long assignmentId = makeAssignmentId();
		Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
		assignment.setCourses_title(title);
		assignment.setMs3employeedb_uid(user.getScreenName());
	//not necessary, but to be safe.
		assignment.setAssignedDate(null);
		assignment.setStartDate(null);
	//for sorting
		assignment.setNotes("requested");
		AssignmentLocalServiceUtil.addAssignment(assignment);
		request.setAttribute("success", "Your course request has been saved.");
	}
	
	@ActionMapping(params = "action=approveRequest")
	public void approveRequest(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException {
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("requestId", request.getParameter("requestId"));
		prefs.store();
		long requestId = Long.parseLong(request.getParameter("requestId"));
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
		assignment.setAssignedDate(setDate());
		assignment.setNotes("Approved on "+setDate());
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		request.setAttribute("success", "You have approved "+assignment.getCourses_title()+" for "+assignment.getMs3employeedb_uid());
	}
	
	@ActionMapping(params = "action=approveRequestFromAssign")
	public void approveRequestFromAssign(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException{
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("requestId", request.getParameter("requestId"));
		prefs.store();
		long requestId = Long.parseLong(request.getParameter("requestId"));
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
		assignment.setAssignedDate(setDate());
		assignment.setNotes("Approved on "+setDate());
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		request.setAttribute("success", "You have approved "+assignment.getCourses_title()+" for "+assignment.getMs3employeedb_uid());
		request.setAttribute("goToAssignCourse", "true");
	}
	
	@ActionMapping(params = "action=updateAssignment")
	public void updateAssignment(ActionRequest request, ActionResponse response) throws Exception {
		PortletPreferences prefs = request.getPreferences();
		String reqId = prefs.getValue("updateAssignmentId", "");
		long requestId = Long.parseLong(reqId);
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
		assignment.setNotes(request.getParameter("notes"));
		if(request.getParameter("completed").equals("true")) {
			assignment.setEndDate(setDate());
		}
		if(request.getParameter("certified").equals("true")) {
			assignment.setCertification(true);
		}
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		request.setAttribute("goToPersonalAssignments", "true");
		request.setAttribute("success", assignment.getCourses_title()+" was updated.");
	}
	
	@ActionMapping(params = "action=startAssignment")
	public void startAssignment(ActionRequest request, ActionResponse response) throws Exception {
		PortletPreferences prefs = request.getPreferences();
		String reqId = prefs.getValue("startAssignmentId", "");
		long requestId = Long.parseLong(reqId);
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
		assignment.setCost(request.getParameter("cost"));
		assignment.setStartDate(setDate());
	//to be on the safe side
		assignment.setEndDate(null);
		assignment.setNotes(request.getParameter("notes"));
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		request.setAttribute("goToPersonalAssignments", "true");
		request.setAttribute("success", "You have begun "+assignment.getCourses_title());
	}
	
	
	
	
	
	
	
	public long makeAssignmentId() throws Exception {
		long assignmentId = (long)AssignmentLocalServiceUtil.getAssignmentsCount();
		if(assignmentId > 0) {
			List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
			for(Assignment assignment: assignments) {
				if(assignmentId <= assignment.getAssignmentId()) {
					assignmentId = assignment.getAssignmentId()+1;
				}
			}
		}
		return assignmentId;
	}
	
	public Date setDate() {
		//DateFormat df = new SimpleDateFormat("dd/MM/yy");
	    Date dateobj = new Date();
	    return dateobj;
	}
	
	public boolean checkIfInAssignments(String screenName, String title) throws SystemException {
		List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
		for(Assignment assignment: assignments) {
			if(assignment.getCourses_title().equals(title)) {
				if(assignment.getMs3employeedb_uid().equals(screenName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	@ActionMapping(params = "action=viewCourses")
	public void viewCourses(ActionRequest request, ActionResponse response) {
		
		List<Course> courseResults;
		try {
			courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
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
}

