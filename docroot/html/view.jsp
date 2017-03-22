<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addCourse">
   <portlet:param name="action" value="addCourse" />
</portlet:actionURL>
<portlet:actionURL var="editCoursePage">
   <portlet:param name="action" value="editCoursePage" />
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
	String isTrainingSupervisor = (String)prefs.getValue("isTrainingSupervisor", "");
%>

<!-- display the courses in a table, hopefully -->

<div id="allCoursesDisplay">
<table class="listTable">
	<tr>
		<td><p>Title: </p></td>
		<td><p>Description: </p></td>
		<td><p>Provider: </p></td>
		<td><p>Course ID: </p></td>
		<td><p>List Price: </p></td>
<%
	if(isTrainingSupervisor.equals("true")) {
%>
		<td><p>Assign to Employee</p></td>
	</tr>
<%
	}
	else {
%>
		<td><p>Request Course</p></td>
	</tr>
<%
	}

	List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
	for(Course course: courses) {
%>
		
	<tr>
		<td><div><%=course.getTitle() %></div></td>
		<td><div><%=course.getDescription() %></div></td>
		<td><div><%=course.getProvider() %></div></td>
		<td><div><%=course.getCourseId() %></div></td>
		<td><div><%=course.getListPrice() %></div></td>
<%
		if(isTrainingSupervisor.equals("true")) {
%>
			<td>
					<aui:form name="assignCoursePage" action="<%=assignCoursePage%>">
						<aui:input name="submitTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
						<input id="doAssign" type="submit" value="Assign"/>
					</aui:form>
			</td>
<%
		}
		else {
%>
			<td>
					<aui:form name="requestCourse" action="<%=requestCourse%>">
						<aui:input name="requestTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
						<input id="doAssign" type="submit" value="Request"/>
					</aui:form>
			</td>	
<%
		}
%>
	</tr>
<%
	}
%>
</table>
</div>

<%
	if(isTrainingSupervisor.equals("true")) {
		//only the training supervisors can add or edit courses.
%>
<aui:a href="<%= editCoursePage %>">Edit a course</aui:a>
<%
	if(addCourseError!=null) {
%>
		<p><%= addCourseError %></p>
<%
	}
%>

<aui:form name="addCourse" action="<%=addCourse%>">
	<aui:input name="title" type="text"/>
	<aui:input name="description" type="text"/>
	<aui:input name="provider" type="text"/>
	<aui:input name="listPrice" type="text"/>
	
	<input id="submitCourse" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Make Course" onclick="initialValidation();"/>
</aui:form>
<%
	}
%>
		<p>Course Requests</p>
		<table class="listTable">
			<tr>
				<th>Employee</th>
			    <th>Course Title</th>
			    <th>Approve Request</th>
			</tr>
	<%
	List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
		for(Assignment assignment: assignments) {
			if(assignment.getStartDate()==null && assignment.getNotes().equals("requested")) {
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
	%>
		</table>



<aui:a href="<%= personalAssignmentsPage %>">Check out your courses.</aui:a>

<%
//ending the original if/else checking if they're signed in.
}
%>

<script>

function initialValidation(){
		document.getElementById("submitCourse").click();
	}

function makeSelectHappen(){
	document.getElementById("submitSelect").click();
}

</script>