<%@page import="com.ms3.training.services.service.coursesLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String assignError = (String)prefs.getValue("assignError","");
	String sentTitle = (String)prefs.getValue("assignTitle","");
System.out.println("received by assignCourse.jsp --> "+sentTitle);
	Course course = CourseLocalServiceUtil.getCourse(sentTitle);
%>

<portlet:actionURL var="assignToUser">
   <portlet:param name="action" value="assignToUser" />
   <portlet:param name="assignTitle" value="<%=sentTitle %>" />
</portlet:actionURL>

<table class="listTable">
	<tr>
		<td>
			<p><aui:input name="title" type="text" style="display:none;"/></p>
		</td>
		<td>
			<p><aui:input name="description" type="text" style="display:none;"/></p>
		</td>
		<td>
			<p><aui:input name="provider" type="text" style="display:none;"/></p>
		</td>
		<td>
			<p><aui:input name="courseId" type="text" style="display:none;"/></p>
		</td>
		<td>
			<p><aui:input name="listPrice" type="text" style="display:none;"/></p>
		</td>
	</tr>
	<tr>
		<td>
			<div><%=course.getTitle() %></div>
		</td>
		<td>
			<div><%=course.getDescription() %></div>
		</td>
		<td>
			<div><%=course.getProvider() %></div>
		</td>
		<td>
			<div><%=course.getCourseId() %></div>
		</td>
		<td>
			<div><%=course.getListPrice() %></div>
		</td>
	</tr>
</table>

<p><%= assignError %></p>
<aui:form name="assignToUser" action="<%=assignToUser%>">
	<aui:input name="user" type="text"/>
	<input value="Assign" type="submit" />
</aui:form>