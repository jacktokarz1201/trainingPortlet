<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addCourse">
   <portlet:param name="action" value="addCourse" />
</portlet:actionURL>
<portlet:actionURL var="viewCourses">
   <portlet:param name="action" value="viewCourses" />
</portlet:actionURL>
<portlet:actionURL var="findCourseByTitle">
   <portlet:param name="action" value="findCourseByTitle" />
</portlet:actionURL>
<portlet:actionURL var="assignCoursePage">
   <portlet:param name="action" value="assignCoursePage" />
</portlet:actionURL>
<portlet:actionURL var="personalAssignmentsPage">
   <portlet:param name="action" value="personalAssignmentsPage" />
</portlet:actionURL>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String addCourseError = (String)prefs.getValue("addCourseError","");
	String isTrainingSupervisor = (String)prefs.getValue("isTrainingSupervisor", "");
	if(isTrainingSupervisor.equals("true")) {
		//only the training supervisors can add or edit courses.
%>

<p><%= addCourseError %></p>
<aui:form name="addCourse" action="<%=addCourse%>">
	<aui:input name="title" type="text"/>
	<aui:input name="description" type="text"/>
	<aui:input name="provider" type="text"/>
	<aui:input name="listPrice" type="text"/>
	
	<input id="submitCourse" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Make Course" onclick="initialValidation();"/>
</aui:form>

<aui:a href="<%= viewCourses %>">Edit a course</aui:a>

<%
	}
%>


<!-- display the courses in a table, hopefully -->

<div id="allCoursesDisplay">
<table class="listTable">
	<tr>
		<td>
			<p>Title: </p>
		</td>
		<td>
			<p>Description: </p>
		</td>
		<td>
			<p>Provider: </p>
		</td>
		<td>
			<p>Course ID: </p>
		</td>
		<td>
			<p>List Price: </p>
		</td>
<%
	if(isTrainingSupervisor.equals("true")) {
%>
		<td>
			<p>Assign to Employee</p>
		</td>
	</tr>
<%
	}
%>
<%
	List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
	for(Course course: courses) {
%>
		
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
%>
	</tr>

<%
	}
%>

</table>
</div>


<p id="error"></p>

<aui:form name="findCourseByTitle" action="<%=findCourseByTitle%>">
	<aui:input name="searchTitle" title="title" type="text"/>
	<input id="submitSelect" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Find Course" onclick="makeSelectHappen();"/>
</aui:form>

 
<div id="selectedCourseDisplay" style="display:none;">
	<p id="selectedTitle">Title: </p>
	<p id="selectedDescription">Description: ""</p>
	<p id="selectedProvider">Provider: ""</p>
	<p id="selectedCourseId">Course ID: ""</p>
</div>

<aui:a href="<%= personalAssignmentsPage %>">Check out which courses are assigned to you.</aui:a>


<script>

function initialValidation(){
		document.getElementById("submitCourse").click();
	}

function makeSelectHappen(){
	document.getElementById("submitSelect").click();
}

</script>