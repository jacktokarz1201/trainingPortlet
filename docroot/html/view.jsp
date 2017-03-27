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
	String configKeyResult = prefs.getValue("somePreferenceKey", "");
	boolean confKeyR = GetterUtil.getBoolean(portletPreferences.getValue("somePreferenceKey", StringPool.TRUE));
	System.out.println("config Key is: "+configKeyResult);
	System.out.println("Or is it: "+confKeyR);
%>

<!-- display the courses in a table, a different table for admins and non-admins -->

<div>
<table id="allCoursesTable">
	<thead>
	<tr>
		<th>Title: </th>
		<th>Description: </th>
		<th>Provider: </th>
		<th>List Price: </th>
		<th>Course ID: </th>
<%
	if(!isTrainingSupervisor.equals("true")) {
%>
		<th>Request Course</th>
<%
	}
	else {
%>
		<th>Edit Course</th>
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
		if(isTrainingSupervisor.equals("true")) {
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
		<td><div><%=course.getCourseId() %></div></td>
<%
		if(!isTrainingSupervisor.equals("true")) {
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
		else {
%>

			<td>
					<aui:form name="editCoursePage" action="<%=editCoursePage%>">
						<aui:input name="editTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
						<input id="doEdit" type="submit" value="Edit"/>
					</aui:form>

<%
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
	if(isTrainingSupervisor.equals("true")) {
		//only the training supervisors can add or edit courses and approve requests.
%>

<%
	if(addCourseError!=null) {
%>
		<p class="error"><%= addCourseError %></p>
<%
	}
%>

<aui:form cssClass="inputForm" name="addCourse" action="<%=addCourse%>">
	<aui:input name="title" type="text"/>
	<aui:input name="description" type="textarea"/>
	<aui:input name="provider" type="text"/>
	<aui:input name="listPrice" type="text"/>
	
	<input id="submitCourse" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Make Course" onclick="initialValidation();"/>
</aui:form>

		<p>Course Requests</p>
		<table class="listTable">
			<tr class="listTableHeader">
				<td>Employee</td>
			    <td>Course Title</td>
			    <td>Approve Request</td>
			</tr>
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