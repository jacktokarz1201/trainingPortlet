<%@include file="/html/init.jsp" %>


<portlet:actionURL var="updateAssignment">
   <portlet:param name="action" value="updateAssignment" />
</portlet:actionURL>

<%
	String updateAssignmentError = (String)request.getAttribute("updateAssignmentError");
	String updateAssignmentId = (String)prefs.getValue("updateAssignmentId", "");
	long assignmentId = Long.parseLong(updateAssignmentId);
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(assignmentId);
	if(updateAssignmentError!=null) {
%>
<p class="error"><%=updateAssignmentError%></p>
<%
	}
%>

<aui:form class="inputForm" name="updateAssigment" action="<%=updateAssignment%>">
	<div>Title: <br /><b><%= assignment.getCourses_title() %></b></div>
	<aui:input name="notes" label="Notes" type="textarea" value="<%= assignment.getNotes() %>"/>
	<aui:input name="progress" label="Progress" type="text" value="?" />
	<aui:input name="certified" label="Certified" type="checkbox" value="<%= assignment.getCertification() %>"/>
	<aui:input name="completed" label="Completed" type="checkbox"/>
	<input type="submit" value="Update"/>
</aui:form>