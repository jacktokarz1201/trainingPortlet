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

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String title = (String)prefs.getValue("title","");

%>

<p><%=title%></p>

This is the portlet in HTML folder.

<aui:form name="addCourse" action="<%=addCourse%>">
	<aui:input name="title" title="title" type="text"/>
	<aui:input name="description" title="description" type="text"/>
	<aui:input name="provider" title="provider" type="text"/>
	<aui:input name="price" title="price" type="text"/>
	
	<input id="submitCourse" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Make Course" onclick="initialValidation();"/>
</aui:form>

<aui:a href="<%= viewCourses %>">Edit a course</aui:a>

<%
	List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
	for(Course course: courses) {
%>
<div id="allCoursesDisplay">
	<p>Title: "<%=course.getTitle() %>"</p>
	<p>Description: "<%=course.getDescription() %>"</p>
	<p>Provider: "<%=course.getProvider() %>"</p>
	<p>Course ID: "<%=course.getCourseId() %>"</p>
</div>
<%
	}
%>

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

<script>

function initialValidation(){
		document.getElementById("submitCourse").click();
	}

function makeSelectHappen(){
	document.getElementById("submitSelect").click();
}

</script>