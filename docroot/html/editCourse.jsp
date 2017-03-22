<%@include file="/html/init.jsp" %>


<portlet:actionURL var="editCourse">
   <portlet:param name="action" value="editCourse" />
</portlet:actionURL>

<%
	String editCourseError = (String)prefs.getValue("editCourseError","");

%>

<p><%=editCourseError%></p>

<aui:form name="editCourse" action="<%=editCourse%>">
	<aui:input name="title" title="title" type="text"/>
	<aui:input name="description" title="description" type="text"/>
	<aui:input name="provider" title="provider" type="text"/>
	<aui:input name="listPrice" title="price" type="text"/>
	
	<input type="submit" />
</aui:form>
