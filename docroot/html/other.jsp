<%@include file="/html/init.jsp" %>


<portlet:actionURL var="editCourse">
   <portlet:param name="action" value="editCourse" />
</portlet:actionURL>

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String greeting = (String)prefs.getValue("greeting","");

%>

<p><%=greeting%></p>

<aui:form name="addCourse" action="<%=editCourse%>">
	<aui:input name="title" title="title" type="text"/>
	<aui:input name="description" title="description" type="text"/>
	<aui:input name="provider" title="provider" type="text"/>
	<aui:input name="listPrice" title="price" type="text"/>
	
	<input type="submit" />
</aui:form>
