<%@include file="/html/init.jsp" %>

<portlet:renderURL var ="home">
	<portlet:param name="mvcPath" value="/html/interaction/view.jsp"/>
</portlet:renderURL>


<a class="headerHomeLink" href="<%=home%>">Go Home</a>