package com.ms3.training;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ms3.training.services.model.Course;
import com.ms3.training.services.model.impl.CourseImpl;
import com.ms3.training.services.service.CourseLocalServiceUtil;

/**
 * Portlet implementation class Interaction
 */
public class Interaction extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }
    
    @ProcessAction(name="viewCourses")
    public void viewCourses(ActionRequest request, ActionResponse response) {
		String courseTitle = request.getParameter("title");
		try {
			Course cou = CourseLocalServiceUtil.getCourse(courseTitle);
			System.out.println(cou.toString());
			return;
		}
		catch (PortalException p) {
			System.out.println("Server error.");
		} catch (SystemException e) {
			e.printStackTrace();
		}
		System.out.println("No course by name: "+courseTitle);
	}

    @ProcessAction(name="addCourse")
    public void addCourse(ActionRequest request, ActionResponse response) {
    	
    	long id= countCourses();
    	if(id == -1) {
    		System.out.println("Error reading Courses in database");
    		return;
    	}
    	id++;
    	
    	Course addition = new CourseImpl();
    	addition.setCourseId(id);
    	addition.setTitle(request.getParameter("title"));
    	addition.setDescription(request.getParameter("description"));
    	addition.setProvider(request.getParameter("provider"));
    	addition.setListPrice(request.getParameter("price"));
    	
    	try {
    		CourseLocalServiceUtil.addCourse(addition); 
    	}
    	catch (SystemException e) {
    		
    	}
    }
    
    @ProcessAction(name="nothing")
    public void nothing(ActionRequest request, ActionResponse response) {
    	System.out.println("nothing...");
    }
    
    
    public long countCourses() {
    	try {
    		return CourseLocalServiceUtil.getCoursesCount();
    	}
    	catch (SystemException e) {
    		e.printStackTrace();
    		return -1;
    	}
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

    	
    	System.out.println("There are "+ countCourses() + " courses.");
    	
        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(Interaction.class);

}
