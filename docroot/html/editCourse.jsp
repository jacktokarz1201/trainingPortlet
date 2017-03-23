<%@include file="/html/init.jsp" %>


<portlet:actionURL var="editCourse">
   <portlet:param name="action" value="editCourse" />
</portlet:actionURL>

<%
	String editCourseError = (String)request.getAttribute("editCourseError");
	String title = (String)prefs.getValue("editTitle", "");
	Course course= CourseLocalServiceUtil.getCourse(title);

	if(editCourseError!=null) {
%>
<p class="error"><%=editCourseError%></p>
<%
	}
%>

<aui:form class="inputForm" name="editCourse" action="<%=editCourse%>">
	<div>Title: <br /><b><%= course.getTitle() %></b></div>
	<aui:input name="description" label="Description: " type="textarea" value="<%= course.getDescription() %>"/>
	<aui:input name="provider" label="Provider: " type="text" value="<%= course.getProvider() %>" />
	<aui:input name="listPrice" label="List Price" type="text" value="<%= course.getListPrice() %>"/>
	<input type="submit" />
</aui:form>
