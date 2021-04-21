package com.crud_jsf.managedBeans.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.crud_jsf.managedBeans.dao.Dao;
import com.crud_jsf.managedBeans.messagesMB.Exceptions;
import com.crud_jsf.model.PlataformaModel;

public class PlataformaService implements Serializable{


	private static final long serialVersionUID = 1L;

	@Inject
	private Dao<PlataformaModel> dao;
	
	public void save(PlataformaModel plataforma) throws Exceptions {
		
		if(plataforma.getNomePlataforma() == null || plataforma.getNomePlataforma().length() < 3) {
			throw new Exceptions("O nome da Plataforma não pode ser vazio ou conter menos de 3 caracteres");
			
		}
		
		dao.save(plataforma);
	}
	
	public void delete(PlataformaModel plataformaModel) {
		dao.delete(PlataformaModel.class, plataformaModel.getId());
		
	}

	public List<PlataformaModel> findAll(){
		
		return dao.findAll("SELECT p from PlataformaModel p");
	}

}

