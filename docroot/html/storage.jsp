<%@include file="/html/init.jsp" %>


<portlet:actionURL var="findCourseByTitle">
   <portlet:param name="action" value="findCourseByTitle" />
</portlet:actionURL>



<!--  Find a course by title... not super effective. -->

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