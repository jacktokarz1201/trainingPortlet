<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<portlet:actionURL var="addCourse">
   <portlet:param name="action" value="addCourse" />
</portlet:actionURL>

This is the <b>Training</b> portlet.

<aui:form name="addCourse" action="<%=addCourse%>">
	<aui:input name="title" title="title" type="text"/>
	<aui:input name="description" title="description" type="text"/>
	<aui:input name="provider" title="provider" type="text"/>
	<aui:input name="price" title="price" type="text"/>
	
	<input id="submitCourse" type="submit" style="display:none;"/>
	<aui:button name="submit" value="Make Course" onclick="initialValidation();"/>
</aui:form>



<script>

function initialValidation(){
		document.getElementById("submitCourse").click();
	}

</script>