<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>


<%@ page import="java.util.List" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import= "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import= "com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import= "com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import= "com.liferay.portal.model.User" %>
<%@ page import= "com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import= "com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import= "com.liferay.portal.kernel.util.Constants" %>
<%@ page import= "com.liferay.portal.kernel.util.StringPool"  %>
<%@ page import= "com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import= "com.liferay.portal.model.Role" %>
<%@ page import="com.ms3.training.services.model.Course" %>
<%@ page import="com.ms3.training.services.model.Assignment" %>
<%@ page import="com.ms3.training.services.service.CourseLocalServiceUtil" %>
<%@ page import="com.ms3.training.services.service.AssignmentLocalServiceUtil" %>

<%@include file="/html/scripts.jsp" %>

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
List<User> users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
	String success = (String)request.getAttribute("success");
	if(success!=null) {
%>
		<p id="successText"><%= success %></p>
<%
	}
%>