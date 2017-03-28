<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>

<portlet:actionURL var="approveRequestFromAssign">
	<portlet:param name="action" value="approveRequestFromAssign" />
</portlet:actionURL>

<%
	String theirScreenName = prefs.getValue("userScreenName", "");
	List<Assignment> relevant = new ArrayList<Assignment>();
	for(Assignment assignment: assignments) {
		if(theirScreenName.equals(assignment.getMs3employeedb_uid())) {
			relevant.add(assignment);
		}
	}
	
	if(relevant.isEmpty()) {
%>
		<div><%= theirScreenName %> does not have any relationship with any courses.</div>
<%	
	}
	else {
%>
		<div class="tableTitle">The assignments of <%= theirScreenName %></div>
<%
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
			<p class="tableReplacement"><%= theirScreenName %> is not currently working on any courses.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Courses in Progress</div>
		<table>
			<thead>
			<tr>
				    <th>Course Title</th>
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
				    <td><%= assignment.getCourses_title() %></td>
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
			<p class="tableReplacement"><%= theirScreenName %> is not currently assigned any courses.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Assigned Courses</div>
		<table>
			<thead>
			<tr>
			    <th>Course Title</th>
			    <th>Date Assigned</th>
			    <th>Notes</th>
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
		<p class="tableReplacement"><%= theirScreenName %> does not have any outstanding course requests.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Requested Courses</div>
		<table>
			<thead>
			<tr>
			    <th>Course Title</th>
			    <th>Provider</th>
			    <th>List Price</th>
			    <th>Notes</th>
			    <th>Approve</th>
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
			<p class="tableReplacement"><%= theirScreenName %> has not completed any courses yet</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Compelted Courses</div>
		<table>
			<thead>
				<tr>
				    <th>Course Title</th>
				    <th>Start Date</th>
				    <th>End Date</th>
				    <th>Certified</th>
				    <th>Notes</th>
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