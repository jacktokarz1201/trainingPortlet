<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@ page import="java.util.List" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import= "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import= "com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import= "com.liferay.portal.model.User" %>
<%@ page import= "com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import= "com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.ms3.training.services.model.Course" %>
<%@ page import="com.ms3.training.services.model.Assignment" %>
<%@ page import="com.ms3.training.services.service.CourseLocalServiceUtil" %>
<%@ page import="com.ms3.training.services.service.AssignmentLocalServiceUtil" %>

<portlet:defineObjects />

<portlet:renderURL var ="home">
	<portlet:param name="mvcPath" value="/html/interaction/view.jsp"/>
</portlet:renderURL>

<a class="headerHomeLink" href="<%=home%>">Go To Home</a>