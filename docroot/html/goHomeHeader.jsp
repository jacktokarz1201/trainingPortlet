<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:renderURL var ="home">
	<portlet:param name="mvcPath" value="/html/interaction/view.jsp"/>
</portlet:renderURL>


<a id="headerHomeLink" href="<%=home%>">Go Home</a>