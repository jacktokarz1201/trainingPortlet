<%@include file="/html/init.jsp" %>

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	String screenName = themeDisplay.getUser().getScreenName();
	List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
	List<Assignment> relevant = new ArrayList<Assignment>();
	for(Assignment assignment: assignments) {
		if(screenName.equals(assignment.getMs3employeedb_uid())) {
			relevant.add(assignment);
		}
	}
	
	if(relevant.isEmpty()) {
%>
	<div>This user does not have any courses assigned to them.</div>
<%	
	}
	else {
%>
		<p>Assigned Courses</p>
		<table class="listTable">
			<tr>
			    <th>Course Title</th>
			    <th>Start Date</th>
			    <th>End Date</th>
			    <th>Notes</th>
			</tr>
<%
		for(Assignment assignment: relevant) {
			if(assignment.getStartDate()!=null && assignment.getEndDate() == null) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td><%= assignment.getEndDate() %></td>
			    <td><%= assignment.getNotes() %></td>
			</tr>
<%
			}
		}
%>
		</table>

		<p>Requested Courses</p>
		<table class="listTable">
			<tr>
			    <th>Course Title</th>
			    <th>Start Date</th>
			    <th>End Date</th>
			    <th>Notes</th>
			</tr>
<%
		for(Assignment assignment: relevant) {
			if(assignment.getStartDate()==null && assignment.getNotes().equals("requested")) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td><%= assignment.getEndDate() %></td>
			    <td><%= assignment.getNotes() %></td>
			</tr>
<%
			}
		}
%>
		</table>

		<p>Completed Courses</p>
		<table class="listTable">
			<tr>
			    <th>Course Title</th>
			    <th>Start Date</th>
			    <th>End Date</th>
			    <th>Notes</th>
			</tr>
<%
		for(Assignment assignment: relevant) {
			if(assignment.getEndDate()!= null) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td><%= assignment.getEndDate() %></td>
			    <td><%= assignment.getNotes() %></td>
			</tr>
<%
			}
		}
%>
		</table>
<%
	}
%>