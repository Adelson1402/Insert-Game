package com.crud_jsf.managedBeans.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import com.crud_jsf.managedBeans.Queries.Queries;
import com.crud_jsf.managedBeans.dao.Dao;
import com.crud_jsf.managedBeans.messagesMB.Exceptions;
import com.crud_jsf.model.GamesModel;


public class GameService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Dao<GamesModel> dao;
	
	
	private Queries queries = new Queries();
	
	
	public void save(GamesModel game) throws Exceptions{
		
		game.setNomeGame(game.getNomeGame());
		if(game.getNomeGame() == null || game.getNomeGame().length() < 3 ) {
			throw new Exceptions("O nome do Jogo não pode ser vazio ou conter menos que 3 caracteres");
			
		}
		
		dao.save(game);
	}
	
	public void delete(GamesModel game) throws Exceptions{
		dao.delete(GamesModel.class, game.getId());	
	}
	
	public List<GamesModel> findAll(){
		return dao.findAll("select g from GamesModel g order by g.nomeGame");	
	}
	public List<GamesModel> search(String param){
		//return dao.search("select g from GamesModel g where g.nomeGame like '%"+param+"%'");
		return dao.search(queries.search("GamesModel", "nomeGame", param));
				
	}

}
