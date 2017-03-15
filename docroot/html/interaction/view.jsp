<%@include file="/html/interaction/init.jsp" %>

<portlet:defineObjects />

This is the <b>Interaction</b> portlet in View mode.

<portlet:actionURL name="addCourse" var="urlVar" ></portlet:actionURL>
<aui:form method ="POST" action="<%=urlVar%>">
	<aui:input name="title" title="title" type="text"/>
	<aui:input name="description" title="description" type="text"/>
	<aui:input name="provider" type="text"/>
	<aui:input name="price" title="price" type="text"/>
	
	<aui:input type="submit" name="urlVar" value="Submit"></aui:input>
</aui:form>

<portlet:renderURL var ="addCourse">
	<portlet:param name="mvcPath" value="/html/interaction/addCourse.jsp"/>
</portlet:renderURL>

<p>
	<a href="<%= addCourse%>">Go nowhere</a>
</p>

<portlet:actionURL name="nothing" var="nothingVar">
</portlet:actionURL>

<p>
	<aui:button name="nothingVar">Do nothing</aui:button>
</p>

<portlet:renderURL var ="other">
	<portlet:param name="mvcPath" value="/html/other.jsp"/>
</portlet:renderURL>

<p>
	<a href="<%= other%>">Another thing</a>
</p>

<portlet:actionURL name="viewCourses" var="urlVar" ></portlet:actionURL>

<aui:form method ="POST" action="<%=urlVar%>">
	<aui:input name="title" title="title" type="text"/>
	<aui:input name="submit" type="submit" value="Add course"></aui:input>
</aui:form>