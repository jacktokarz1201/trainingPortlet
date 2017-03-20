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
	
	if(relevant == null) {
%>
	<div>This user does not have any courses assigned to them.</div>
<%	
	}
	else {
%>
		<table class="listTable">
			<tr>
			    <th>Course Title</th>
			    <th>Start Date</th>
			    <th>End Date</th>
			</tr>
<%
		for(Assignment assignment: relevant) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate() %></td>
			    <td><%= assignment.getEndDate() %></td>
			</tr>
<%
		}
%>
		</table>
<%
	}
%>

