package com.crud_jsf.managedBeans.conversores;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.crud_jsf.managedBeans.dao.Dao;
import com.crud_jsf.model.PlataformaModel;


@ManagedBean
public class PlataformaConverter implements Converter {
	
	@Inject
	private Dao<PlataformaModel> dao;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PlataformaModel plataforma = dao.findById(PlataformaModel.class, Long.valueOf(value).longValue());
		return plataforma;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof PlataformaModel) {
		PlataformaModel plataforma = (PlataformaModel) value;
		return plataforma.getId().toString();
		}else {
			return null;
		}
	}

}
