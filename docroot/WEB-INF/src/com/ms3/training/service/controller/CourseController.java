package com.ms3.training.service.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
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
			RenderResponse response, Model model) {		
		PortletPreferences prefs = request.getPreferences();
//for permission and stuff
//  {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(user.getUserId(), 0, QueryUtil.ALL_POS, null);
			Long companyId = CompanyThreadLocal.getCompanyId();
			Organization trainingSupervisorOrg = OrganizationLocalServiceUtil.getOrganization(companyId, "TrainingSupervisor");
			prefs.setValue("isTrainingSupervisor", "false");
			for(Organization org: organizations){
	            if(org.getOrganizationId()==trainingSupervisorOrg.getOrganizationId()){                    
	                prefs.setValue("isTrainingSupervisor", "true"); //flag to determine if he's in trainee organization    
	                break;
	            }
	        }
			prefs.store();
	System.out.println("This is a Training Supervisor: "+prefs.getValue("isTrainingSupervisor", ""));
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ReadOnlyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//  }
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
		prefs.setValue("assignError", "");
		prefs.store();
		request.setAttribute("goToAssignCourse", "true");
		
	}
	
	@ActionMapping(params = "action=personalAssignmentsPage")
	public void personalAssignmentsPage(ActionRequest request, ActionResponse response) throws Exception{
		request.setAttribute("goToPersonalAssignments", "true");
	}
	
	@ActionMapping(params = "action=editCoursePage")
	public void editCoursePage(ActionRequest request, ActionResponse response) throws Exception{
		request.setAttribute("goToEditCourse", "true");
	}
	
	@ActionMapping(params = "action=viewUserAssignments")
	public void viewUserAssignments(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("userScreenName", request.getParameter("userAssignmentsScreenName"));
		prefs.store();
		request.setAttribute("goToUserAssignments", "true");
	}
	
	@ActionMapping(params = "action=assignToUser")
	public void assignToUser(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		String screenName = request.getParameter("user");
		if(screenName == null || screenName.equals("")) {
			prefs.setValue("assignError", "Please fill in a screen name for the assignment.");
			prefs.store();
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
		//make the assignment, with Id one higher than the existing highest
			long assignmentId = makeAssignmentId();
			Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
			assignment.setStartDate(setDate());
			assignment.setCourses_title(title);
			assignment.setMs3employeedb_uid(screenName);
			AssignmentLocalServiceUtil.addAssignment(assignment);
			request.setAttribute("success", "Your assignment of "+assignment.getCourses_title()+" to "+assignment.getMs3employeedb_uid()+" has been saved.");
		}
		catch (NoSuchUserException e) {
			prefs.setValue("assignError", "There are no users by that screen name.");
			prefs.store();
			request.setAttribute("goToAssignCourse", "true");
			return;
		}
		catch (NoSuchCourseException e) {
			prefs.setValue("assignError", "A course by that title is not in the catalog.");
			prefs.store();
			request.setAttribute("goToAssignCourse", "true");
			return;
		}
	}
	
	@ActionMapping(params = "action=requestCourse")
	public void requestCourse(ActionRequest request, ActionResponse response) throws Exception{
		PortletPreferences prefs = request.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		long assignmentId = makeAssignmentId();
		Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
		assignment.setCourses_title(request.getParameter("requestTitle"));
		assignment.setMs3employeedb_uid(user.getScreenName());
		assignment.setStartDate(null);
		assignment.setNotes("requested");
		AssignmentLocalServiceUtil.addAssignment(assignment);
		request.setAttribute("success", "Your course request has been saved.");
	System.out.println("Your request has been saved. Or at a minimum, this function worked.");
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
					prefs.setValue("addCourseError", "That title has already been used.");
					prefs.store();
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
	//clear the error message
			prefs.setValue("addCourseError", "");
			prefs.store();
			
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
		
		String title = request.getParameter("title");
	//CHECK if they put in a title
		if(title==null) {
			prefs.setValue("editCourseError", "Put in a title.");
			prefs.store();
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
			prefs.setValue("editCourseError", "A course by that title is not in the catalog.");
			prefs.store();
			request.setAttribute("goToEditCourse", "true");
			return;
		}
	}
	
	@ActionMapping(params = "action=approveRequest")
	public void approveRequest(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long requestId = Long.parseLong(request.getParameter("requestId"));
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
		assignment.setStartDate(setDate());
		assignment.setNotes("Approved on "+setDate());
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		request.setAttribute("success", "You have approved "+assignment.getCourses_title()+" for "+assignment.getMs3employeedb_uid());
	}
	
	@ActionMapping(params = "action=approveRequestFromAssign")
	public void approveRequestFromAssign(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long requestId = Long.parseLong(request.getParameter("requestId"));
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
		assignment.setStartDate(setDate());
		assignment.setNotes("Approved on "+setDate());
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		request.setAttribute("success", "You have approved "+assignment.getCourses_title()+" for "+assignment.getMs3employeedb_uid());
		request.setAttribute("goToAssignCourse", "true");
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
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
	    Calendar calobj = Calendar.getInstance();
	    System.out.println(df.format(calobj.getTime()));
	    return dateobj;
	}
	
	
	
	@ActionMapping(params = "action=viewCourses")
	public void viewCourses(ActionRequest request, ActionResponse response) {
		//System.out.println("ajax called");		
		
//		request.setAttribute("viewCall", "viewTime");
		
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
}

