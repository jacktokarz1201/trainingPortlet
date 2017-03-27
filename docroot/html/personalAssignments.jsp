<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>

<portlet:actionURL var="updateAssignmentPage">
	<portlet:param name="action" value="updateAssignmentPage" />
</portlet:actionURL>
<portlet:actionURL var="startAssignmentPage">
	<portlet:param name="action" value="startAssignmentPage" />
</portlet:actionURL>

<%
	String screenName = themeDisplay.getUser().getScreenName();
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
		System.out.println("Relevant: "+relevant.toString());
		System.out.println("In Progress: "+inProgress.toString());
		System.out.println("Assigned: "+assigned.toString());
		System.out.println("Requested: "+requested.toString());
		System.out.println("Completed: "+completed.toString());
		
//show off the lists
		if(inProgress.isEmpty()) {
%>
		<p class="tableReplacement">You aren't currently working on any courses.</p>
<%
		}
		else {
%>
		<div class="tableTitle">Courses in Progress</div>
		<table class="listTable">
			<tr class="listTableHeader">
			    <td>Course Title</td>
			    <td>Date Started</td>
			    <td>Progress</td>
			    <td>Notes</td>
			    <td>Work on it</td>
			</tr>
<%
		for(Assignment assignment: inProgress) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td> ? </td>
			    <td><%= assignment.getNotes() %></td>
			    <td>
			    	<aui:form name="updateAssignmentPage" action="<%=updateAssignmentPage%>">
						<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input id="doWork" type="submit" value="Select"/>
					</aui:form>
			    </td>
			</tr>
<%
		}
%>
		</table>
<%
		}
		if(assigned.isEmpty()) {
%>
		<p class="tableReplacement">You are not assigned any courses.</p>
<%
		}
		else {
%>
		<div class="tableTitle">Assigned Courses</div>
		<table class="listTable">
			<tr class="listTableHeader">
			    <td>Course Title</td>
			    <td>Date Assigned</td>
			    <td>Notes</td>
			    <td>Start Training</td>
			</tr>
<%
		for(Assignment assignment: assigned) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getAssignedDate() %></td>
			    <td><%= assignment.getNotes() %></td>
			    <td>
			    	<aui:form name="startAssignmentPage" action="<%=startAssignmentPage%>">
						<aui:input name="startAssignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input id="doWork" type="submit" value="Select"/>
					</aui:form>
			    </td>
			</tr>
<%
			}
%>
		</table>
<%
		}
		if(requested.isEmpty()) {
%>
		<p class="tableReplacement">You do not have any outstanding course requests.</p>
<%
		}
		else {
%>
		<div class="tableTitle">Requested Courses</div>
		<table class="listTable">
			<tr class="listTableHeader">
			    <td>Course Title</td>
			    <td>Provider</td>
			    <td>List Price</td>
			    <td>Notes</td>
			</tr>
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
		</table>
<%
		}
		if(completed.isEmpty()) {
%>
		<p class="tableReplacement">you have not completed any courses yet</p>
<%
		}
		else {
%>
		<div class="tableTitle">Completed Courses</div>
		<table class="listTable">
			<tr class="listTableHeader">
			    <td>Course Title</td>
			    <td>Start Date</td>
			    <td>End Date</td>
			    <td>Certified</td>
			    <td>Notes</td>
			</tr>
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
		</table>
<%
		}
	}
%>