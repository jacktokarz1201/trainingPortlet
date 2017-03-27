<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" >
	<portlet:param name="action" value="configurationURL" />
</liferay-portlet:actionURL>
<%  
boolean configKeyResult = GetterUtil.getBoolean(portletPreferences.getValue("configKey", StringPool.TRUE));
long companyId = themeDisplay.getCompanyId();
List<Role> roles = RoleLocalServiceUtil.getRoles(companyId);
System.out.println("Roles are: "+roles.toString());
roles.clear();
roles = RoleLocalServiceUtil.getRoles(0, RoleLocalServiceUtil.getRolesCount());
System.out.println("Or maybe its: "+roles.toString());
long userId= themeDisplay.getUserId();
roles.clear();
roles = RoleLocalServiceUtil.getUserRoles(userId);
System.out.println("This user's roles are: "+roles.toString());
%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

    <aui:input name="preferences--configKey--" type="checkbox" value="<%= configKeyResult %>" />

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>