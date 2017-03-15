<%@include file="/html/interaction/init.jsp" %>

<portlet:renderURL var ="home">
	<portlet:param name="mvcPath" value="/html/interaction/view.jsp"/>
</portlet:renderURL>

<p>
	<a href="<%= home%>">Go back</a>
</p>