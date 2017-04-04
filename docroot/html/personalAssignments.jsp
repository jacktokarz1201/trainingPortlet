<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>

<portlet:actionURL var="updateAssignment">
   <portlet:param name="action" value="updateAssignment" />
</portlet:actionURL>
<portlet:actionURL var="startAssignment">
   <portlet:param name="action" value="startAssignment" />
</portlet:actionURL>

<%
	String screenName = themeDisplay.getUser().getScreenName();

	String updateAssignmentError = (String)request.getAttribute("updateAssignmentError");
	String startAssignmentError = (String)request.getAttribute("startAssignmentError");
//make sure this user has assignments
	List<Assignment> relevant = new ArrayList<Assignment>();
	for(Assignment assignment: assignments) {
		if(screenName.equals(assignment.getMs3employeedb_uid())) {
			relevant.add(assignment);
		}
	}
	if(relevant.isEmpty()) {
%>
	<div class="tableReplacement">This user does not have any courses assigned to them.</div>
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
		
//show off the lists
		if(inProgress.isEmpty()) {
%>
			<p class="tableReplacement">You aren't currently working on any courses.</p>
<%
		}
	else {
		if(updateAssignmentError!=null) {
%>
			<p class="error"><%=updateAssignmentError%></p>
<%
		}
%>
	<div class="tableHolder">
		<div class="tableTitle">Courses in Progress</div>
		<table>
			<thead>
			<tr>
			    <td>Course Title</td>
			    <td>Date Started</td>
			    <td>Progress</td>
			    <td>Notes</td>
			    <td>Work on it</td>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: inProgress) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td> ? </td>
			    <td><%= assignment.getNotes() %></td>
			    <td>
			    	<div id = "updateAssignmentDialog" title = "Progress Update">
				    	<aui:form cssClass="inputForm" name="updateAssigment" action="<%=updateAssignment%>">
							<div cssClass="dialogHeader"><%= assignment.getCourses_title() %></div>
							<aui:input name="notes" label="Notes" type="textarea" value="<%= assignment.getNotes() %>"/>
							<aui:input name="progress" label="Progress" type="text" value="?" />
							<aui:input name="certified" label="Certified" type="checkbox" value="<%= assignment.getCertification() %>"/>
							<aui:input name="completed" label="Completed" type="checkbox"/>
							<input type="submit" value="Update"/>
						</aui:form>
			    	</div>
			    	<button id="updateOpener">Update</button>
			    	
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
	if(assigned.isEmpty()) {
%>
	<p class="tableReplacement">You are not assigned any courses.</p>
<%
	}
	else {
		if(startAssignmentError!=null) {
%>
			<p class="error"><%=startAssignmentError%></p>
<%
		}
%>
	<div class="tableHolder">
		<div class="tableTitle">Assigned Courses</div>
		<table>
			<thead>
			<tr>
			    <td>Course Title</td>
			    <td>Date Assigned</td>
			    <td>Notes</td>
			    <td>Start Training</td>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: assigned) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getAssignedDate() %></td>
			    <td><%= assignment.getNotes() %></td>
			    <td>
					<div id = "startAssignmentDialog" title = "Start Course">
						<aui:form cssClass="inputForm" name="startAssigment" action="<%=startAssignment%>">
							<div cssClass="dialogHeader"><b><%= assignment.getCourses_title() %></b></div>
							<aui:input name="cost" label="Cost" type="text"/>
							<aui:input name="notes" label="Notes" type="textarea" value="<%= assignment.getNotes() %>"/>
							<input type="submit" value="Commence!"/>
						</aui:form>
					</div>
					<button id="startOpener">Start Course</button>
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
		if(requested.isEmpty()) {
%>
		<p class="tableReplacement">You do not have any outstanding course requests.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Requested Courses</div>
		<table>
			<thead>
			<tr>
			    <td>Course Title</td>
			    <td>Provider</td>
			    <td>List Price</td>
			    <td>Notes</td>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: requested) {
			Course course = CourseLocalServiceUtil.getCourse(assignment.getCourses_title());
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= course.getProvider() %></td>
			    <td><%= course.getListPrice() %></td>
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
		if(completed.isEmpty()) {
%>
		<p class="tableReplacement">You have not completed any courses yet.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Completed Courses</div>
		<table>
			<thead>
			<tr>
			    <td>Course Title</td>
			    <td>Start Date</td>
			    <td>End Date</td>
			    <td>Certified</td>
			    <td>Notes</td>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: completed) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td><%= assignment.getEndDate() %></td>
			    <td><%= assignment.getCertification() %></td>
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
	}
%>