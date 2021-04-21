package com.crud_jsf.managedBeans.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named(value="dialog")
@RequestScoped
public class DialogView {
	
	public void dialogVieww() {
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 1000);
		options.put("height", 700);
		options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
		PrimeFaces.current().dialog().openDynamic("dialogView", options, null);
		
	}

}
