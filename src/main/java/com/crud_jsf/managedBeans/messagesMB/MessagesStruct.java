package com.crud_jsf.managedBeans.messagesMB;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesStruct {
	
	public static void info(String msn) {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msn, null);
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void warn(String msn) {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msn, null);
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
