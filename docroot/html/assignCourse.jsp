<%@page import="com.ms3.training.services.service.coursesLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<%

	String assignError = (String)request.getAttribute("assignError");
	String sentTitle = (String)prefs.getValue("assignTitle","");
	Course course = CourseLocalServiceUtil.getCourse(sentTitle);
	
	List<Assignment> relevant = new ArrayList<Assignment>();
	
%>

<portlet:actionURL var="assignToUser">
	<portlet:param name="action" value="assignToUser" />
</portlet:actionURL>
<portlet:actionURL var="viewUserAssignments">
	<portlet:param name="action" value="viewUserAssignments" />
</portlet:actionURL>
<portlet:actionURL var="approveRequestFromAssign">
	<portlet:param name="action" value="approveRequestFromAssign" />
</portlet:actionURL>
<portlet:actionURL var="deleteCourse">
	<portlet:param name="action" value="deleteCourse" />
</portlet:actionURL>

<table class="listTable">
	<tr class="listTableHeader">
		<td>Title</td>
		<td>Description</td>
		<td>Provider</td>
		<td>Course ID</td>
		<td>List Price</td>
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


	<p><aui:a href= "<%= deleteCourse %>">Delete this Course!</aui:a></p>

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

//separate assignments into appropriate lists
	List<Assignment> inProgress = new ArrayList<Assignment>();
	List<Assignment> requested = new ArrayList<Assignment>();
	List<Assignment> assigned = new ArrayList<Assignment>();
	List<Assignment> completed = new ArrayList<Assignment>();
	for(Assignment assignment: relevant) {
		if(assignment.getStartDate()!=null && assignment.getEndDate() == null) {
			inProgress.add(assignment);
		}
		else if(assignment.getAssignedDate()!=null && assignment.getStartDate() == null) {
			assigned.add(assignment);	
		}
		else if(assignment.getAssignedDate()==null && assignment.getNotes().equals("requested")) {
			requested.add(assignment);
		}
		else if(assignment.getEndDate()!= null) {
			completed.add(assignment);
		}
	}

	if(inProgress.isEmpty()) {
%>
	<p class="tableReplacement">Nobody is currently working on this course</p>
<%
	}
	else {
%>
		<div class="tableTitle">Currently Working on this Course</div>
		<table class="listTable">
			<tr>
			    <th>Screen Name</th>
			    <th>Date Started</th>
			    <th>Progress</th>
			    <th>Notes</th>
			</tr>
<%
		for(Assignment assignment: inProgress) {
%>
			<tr>
			    <td><%= assignment.getMs3employeedb_uid() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td> ? </td>
			    <td><%= assignment.getNotes() %></td>
			</tr>
<%
			}
%>
		</table>
<%
		}
	if(assigned.isEmpty()) {
%>
	<p class="tableReplacement">This course is not currently assigned to anybody</p>
<%
	}
	else {
%>
		<div class="tableTitle">This course has been assigned to </div>
		<table class="listTable">
		<tr class="listTableHeader">
			<td>Name</td>
			<td>Date Assigned</td>
		</tr>
<%
	for(Assignment assignment: assigned) {
%>
		<tr>
			<td><%= assignment.getMs3employeedb_uid() %></td>
			<td><%= assignment.getAssignedDate() %></td>
		</tr>
<%
		}
%>
	</table>
<% 
	}
	if(requested.isEmpty()) {
%>
	<p class="tableReplacement">There are no outstanding requests to take this course</p>
<%
	}
	else {
%>
	<div class="tableTitle">This course has been requested by </div>
	<table class="listTable">
		<tr class="listTableHeader">
			<td>Name</td>
			<td>Approve</td>
		</tr>
<%
		for(Assignment assignment: requested) {
%>
		<tr>
			<td><%= assignment.getMs3employeedb_uid() %></td>
			<td>
		    	<aui:form name="approveRequestFromAssign" action="<%=approveRequestFromAssign%>">
					<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
					<input id="doApprove" type="submit" value="Approve"/>
				</aui:form>
			</td>
		</tr>
<%
		}
%>
	</table>
<% 
	}
	if(completed.isEmpty()) {
%>
	<p class="tableReplacement">Nobody has completed this course yet</p>
<%
	}
	else {
%>
		<div class="tableTitle">This course has been completed by </div>
	<table class="listTable">
		<tr class="listTableHeader">
			<td>Name</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Certified</td>
		</tr>
<%
		for(Assignment assignment: completed) {
%>
		<tr>
			<td><%= assignment.getMs3employeedb_uid() %></td>
			<td><%= assignment.getStartDate() %></td>
			<td><%= assignment.getEndDate() %></td>
			<td><%= assignment.getCertification() %></td>
		</tr>
<%
		}
%>
	</table>
<% 
	}

//end of the else, seeing if there are any assignments linked to this course
}

	if(assignError!=null) {
%>
<p class="error"><%= assignError %></p>
<%
	}
%>
<aui:form class="inputForm" name="assignToUser" action="<%=assignToUser%>">
	<aui:input name="user" label="Screen Name" type="text"/>
	<input value="Assign By Screen Name	" type="submit" />
</aui:form>

<p>Available Users</p>
<table class="listTable">
	<tr class="listTableHeader">
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
		<td>
			<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
				<aui:input name="userAssignmentsScreenName" label="" value="<%= user.getScreenName() %>" style="display:none;" />
				<input class="linkImitation" id="doView" type="submit" value="<%= user.getScreenName() %>" />
			</aui:form>
		</td>
	</tr>	
<%
	}
}
%>
</table>



