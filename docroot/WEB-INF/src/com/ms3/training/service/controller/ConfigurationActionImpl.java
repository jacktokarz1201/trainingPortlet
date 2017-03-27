package com.ms3.training.service.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
 
	@Override
	public void processAction(PortletConfig config, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
		
		super.processAction(config, actionRequest, actionResponse);

	    PortletPreferences prefs = actionRequest.getPreferences();

	    String configKey = prefs.getValue(
	        "configKey", "true");
	}
}
