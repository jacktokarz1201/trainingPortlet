<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" >
	<portlet:param name="action" value="configurationURL" />
</liferay-portlet:actionURL>
<%  
String selectedRole = GetterUtil.getString(portletPreferences.getValue("ableRole", StringPool.TRUE));
long companyId = themeDisplay.getCompanyId();
List<Role> roles = RoleLocalServiceUtil.getRoles(companyId);

String skillsetEndPoint = portletPreferences.getValue("skillsetEndPoint", StringPool.BLANK);
%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

    <aui:select name="preferences--ableRole--" label="Grant Power To">
<%
	for(Role role: roles) {
%>
		<aui:option label="<%= role.getName() %>" value="<%= role.getName() %>" selected="<%= selectedRole.equals(role.getName()) %>"></aui:option>
<%
	}
%>
    </aui:select>
    
    <aui:input name="skillsetEndPoint"  label="Employee Skillset API End Point 
    	<br><small>Example: http://52.201.204.44:8081/employee-api/employees/skillset/</small>" value="<%= skillsetEndPoint %>" type="text"> 
    </aui:input>

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>