<%@include file="/html/init.jsp" %>

<portlet:actionURL var="startAssignment">
   <portlet:param name="action" value="startAssignment" />
</portlet:actionURL>

<%
	String startAssignmentError = (String)request.getAttribute("startAssignmentError");
	String startAssignmentId = (String)prefs.getValue("startAssignmentId", "");
	long assignmentId = Long.parseLong(startAssignmentId);
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(assignmentId);

	if(startAssignmentError!=null) {
%>
		<p class="error"><%=startAssignmentError%></p>
<%
	}
%>
<aui:form class="inputForm" name="startAssigment" action="<%=startAssignment%>">
	<div>Title: <br /><b><%= assignment.getCourses_title() %></b></div>
	<aui:input name="cost" label="Cost" type="text"/>
	<aui:input name="notes" label="Notes" type="textarea" value="<%= assignment.getNotes() %>"/>
	<input type="submit" value="Begin Course"/>
</aui:form>