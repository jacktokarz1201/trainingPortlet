
<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>
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
<portlet:actionURL var="editCoursePage">
   <portlet:param name="action" value="editCoursePage" />
</portlet:actionURL>

<div class="tableHolder">
<table class="plain">
	<thead>
	<tr>
		<td>Title</td>
		<td>Description</td>
		<td>Provider</td>
		<td>Course ID</td>
		<td>List Price</td>
		<td>Edit</td>
	</tr>
	</thead>
	<tbody>
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
		<td>
			<aui:form name="editCoursePage" action="<%=editCoursePage%>">
				<aui:input name="editTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
				<input id="doEdit" type="submit" value="Edit"/>
			</aui:form>
		</td>
	</tr>
	</tbody>
</table>
</div>

<div id = "deleteCourseDialog" title = "Are You Sure?">
	<p><aui:a href= "<%= deleteCourse %>">Yes!</aui:a></p>
</div>
	
	<button id = "deleteOpener">Delete This Course!</button>

<%
for(Assignment assignment: assignments) {
	if(course.getTitle().equals(assignment.getCourses_title())) {
		relevant.add(assignment);
	}
}
if(relevant.isEmpty()) {
%>
	<p class="tableReplacement">This course has not been assigned to anybody yet.</p>
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
	<p class="tableReplacement">Nobody is currently working on this course.</p>
<%
	}
	else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Currently working on this course</div>
		<table>
			<thead>
			<tr>
			    <th>Screen Name</th>
			    <th>Date Started</th>
			    <th>Progress</th>
			    <th>Notes</th>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: inProgress) {
%>
			<tr>
			    <td>
					<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
						<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
						<input class="linkImitation" id="doView" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
					</aui:form>
				</td>
			    <td><%= assignment.getStartDate() %></td>
			    <td> ? </td>
			    <td><%= assignment.getNotes() %></td>
			</tr>
<%
			}
%>
			</tbody>
		</table>
	</div>
<%
		}
	if(assigned.isEmpty()) {
%>
	<p class="tableReplacement">This course is not currently assigned to anybody.</p>
<%
	}
	else {
%>
		<div class="tableHolder">
			<div class="tableTitle">This course has been assigned to </div>
			<table>
				<thead>
				<tr>
					<td>Name</td>
					<td>Date Assigned</td>
				</tr>	
				</thead>
				<tbody>
<%
	for(Assignment assignment: assigned) {
%>
				<tr>
					<td>
						<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
							<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
							<input class="linkImitation" id="doView" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
						</aui:form>
					</td>
					<td><%= assignment.getAssignedDate() %></td>
				</tr>
<%
		}
%>
				</tbody>
			</table>
		</div>
<% 
	}
	if(requested.isEmpty()) {
%>
	<p class="tableReplacement">There are no outstanding requests to take this course.</p>
<%
	}
	else {
%>
<div class="tableHolder">
	<div class="tableTitle">This course has been requested by </div>
	<table>
		<thead>
		<tr>
			<td>Name</td>
			<td>Approve</td>
		</tr>
		</thead>
		<tbody>
<%
		for(Assignment assignment: requested) {
%>
		<tr>
			<td>
				<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
					<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
					<input class="linkImitation" id="doView" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
				</aui:form>
			</td>
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
		</tbody>
	</table>
</div>
<% 
	}
	if(completed.isEmpty()) {
%>
	<p class="tableReplacement">Nobody has completed this course yet</p>
<%
	}
	else {
%>
	<div class="tableHolder">
		<div class="tableTitle">This course has been completed by </div>
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Certified</td>
				</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: completed) {
%>
				<tr>
					<td>
						<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
							<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
							<input class="linkImitation" id="doView" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
						</aui:form>
					</td>
					<td><%= assignment.getStartDate() %></td>
					<td><%= assignment.getEndDate() %></td>
					<td><%= assignment.getCertification() %></td>
				</tr>
<%
		}
%>
			</tbody>
		</table>
	</div>
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

<p>Available Users</p>
<div class="tableHolder">
	<table>
		<thead>
		<tr>
			<td>Name</td>
			<td>Screen Name</td>
			<td>Assign This Course</td>
		</tr>
		</thead>
		<tbody>
<%
for(User user: users) {
	boolean skip= false;
	for(Assignment assignment: relevant) {
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
			<td>
				<aui:form class="inputForm" name="assignToUser" action="<%=assignToUser%>">
					<aui:input name="user" label="" value="<%= user.getScreenName() %>" style="display:none;"/>
					<input value="Assign By Screen Name	" type="submit" />
				</aui:form>
			</td>
		</tr>	
<%
	}
}
%>
		</tbody>
	</table>
</div>
