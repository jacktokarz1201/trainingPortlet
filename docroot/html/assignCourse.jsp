<%@page import="com.ms3.training.services.service.coursesLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String assignError = (String)prefs.getValue("assignError","");
	String sentTitle = (String)prefs.getValue("assignTitle","");
	Course course = CourseLocalServiceUtil.getCourse(sentTitle);
	
	List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
	List<Assignment> relevant = new ArrayList<Assignment>();
	List<User> users = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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

<%
for(Assignment assignment: assignments) {
	if(course.getTitle().equals(assignment.getCourses_title())) {
		relevant.add(assignment);
	}
}
if(relevant.isEmpty()) {
%>
	<p>This course has not been assigned to anybody yet.</p>
<%
}
else {
%>
	<div>This course has been assigned to </div>
	<table class="listTable">
		<tr>
			<td>Name</td>
			<td>Start Date</td>
		</tr>
<%
	for(Assignment assignment: relevant) {
%>
		<tr>
			<td><%= assignment.getMs3employeedb_uid() %></td>
			<td><%= assignment.getStartDate() %></td>
		</tr>
<%
	}
%>
	</table>
<%
}
%>

<p><%= assignError %></p>
<aui:form name="assignToUser" action="<%=assignToUser%>">
	<aui:input name="user" label="Screen Name" type="text"/>
	<input value="Assign By Screen Name	" type="submit" />
</aui:form>

<p>Available Users</p>
<table class="listTable">
	<tr>
		<td>Name</td>
		<td>Screen Name</td>
	</tr>
<%
for(User user: users) {
	boolean skip= false;
	for(Assignment assignment: assignments) {
		if(user.getScreenName().equals(assignment.getMs3employeedb_uid())) {
			skip=true;
		}
	}
	if(!skip) {
%>
	<tr>
		<td><%= user.getFullName() %></td>
		<td><%= user.getScreenName() %></td>
	</tr>	
<%
	}
}
%>
</table>



