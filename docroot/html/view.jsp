<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addCourse">
   <portlet:param name="action" value="addCourse" />
</portlet:actionURL>
<portlet:actionURL var="assignCoursePage">
   <portlet:param name="action" value="assignCoursePage" />
</portlet:actionURL>
<portlet:actionURL var="personalAssignmentsPage">
   <portlet:param name="action" value="personalAssignmentsPage" />
</portlet:actionURL>
<portlet:actionURL var="requestCourse">
   <portlet:param name="action" value="requestCourse" />
</portlet:actionURL>
<portlet:actionURL var="approveRequest">
   <portlet:param name="action" value="approveRequest" />
</portlet:actionURL>
<%
	User user = themeDisplay.getUser();
if(user.getFullName().equals("")) {
%>
	<p>Please sign in to access this portlet.</p>
<%
	}
else {
	String addCourseError = (String)request.getAttribute("addCourseError");
	String hasPermission = prefs.getValue("hasPermission", "");
	
%>

<!-- display the courses in a table, a different table for admins and non-admins -->

<div class="tableHolder">
<div class="tableTitle">Courses</div>
<table>
	<thead>
	<tr>
		<th>Title: </th>
		<th>Description: </th>
		<th>Provider: </th>
		<th>List Price: </th>
<%
	if(!hasPermission.equals("true")) {
%>
		<th>Request Course</th>
<%
	}
%>	

	</tr>
	</thead>
	<tbody>
<%
	for(Course course: courses) {
%>	
	<tr>
<%
		if(hasPermission.equals("true")) {
%>
		<td>
			<aui:form name="assignCoursePage" action="<%=assignCoursePage%>">
				<aui:input name="submitTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
				<input class="linkImitation" id="doAssign" type="submit" value="<%= course.getTitle() %>"/>
			</aui:form>
		</td>
<%
		}
		else {
%>
		<td><div><%=course.getTitle() %></div></td>
<%
		}
%>
		<td><div><%=course.getDescription() %></div></td>
		<td><div><%=course.getProvider() %></div></td>
		<td><div><%=course.getListPrice() %></div></td>
<%
		if(!hasPermission.equals("true")) {
			boolean alreadyAssigned = false;
			for(Assignment assignment: assignments) {
				if(assignment.getCourses_title().equals(course.getTitle())) {
					if(assignment.getMs3employeedb_uid().equals(user.getScreenName())) {
						alreadyAssigned=true;
						break;
					}
				}
			}
			if(!alreadyAssigned) {
%>
			<td>
					<aui:form name="requestCourse" action="<%=requestCourse%>">
						<aui:input name="requestTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
						<input id="doAssign" type="submit" value="Request"/>
					</aui:form>
			</td>	
<%
			}
		}
%>
	</tr>
<%
	}
%>
	</tbody>
</table>
</div>

<%
	if(hasPermission.equals("true")) {
		//only the training supervisors can add or edit courses and approve requests.
%>

<%
	if(addCourseError!=null) {
%>
		<p class="error"><%= addCourseError %></p>
<%
	}
%>



<div id = "makeCourseDialog" title = "Course Creation">
	<aui:form cssClass="inputForm" name="addCourse" action="<%=addCourse%>">
	<aui:input cssClass="normalInput" name="title" label="Title" type="text"/>
	<aui:input class="normalInput" name="description" label="Description" type="textarea"/>
	<aui:input name="provider" label="Provider" type="text"/>
	<aui:input name="listPrice" label="List Price" type="text"/>
	
	<input id="submitCourse" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Make Course" onclick="initialValidation();"/>
</aui:form>
	
</div>

<button id = "opener">Make Course</button>



	<div class="tableHolder">
	<div class="tableTitle">Course Requests</div>
		<table>
		<thead>
			<tr>
				<td>Employee</td>
			    <td>Course Title</td>
			    <td>Approve Request</td>
			</tr>
		</thead>
		<tbody>
	<%
		for(Assignment assignment: assignments) {
			if(assignment.getAssignedDate()==null && assignment.getNotes().equals("requested")) {
	%>
			<tr>
				<td><%= assignment.getMs3employeedb_uid() %></td>
			    <td><%= assignment.getCourses_title() %></td>
			    <td>
			    	<aui:form name="approveRequest" action="<%=approveRequest%>">
						<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input id="doApprove" type="submit" value="Approve"/>
					</aui:form>
				</td>
			</tr>
	<%
			}
		}
	}
	%>
		</tbody>
		</table>
	</div>



<aui:a href="<%= personalAssignmentsPage %>">Check out your courses.</aui:a>

<%
//ending the original if/else checking if they're signed in.
}
%>

<script>

</script>