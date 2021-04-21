package com.crud_jsf.managedBeans.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.crud_jsf.managedBeans.messagesMB.Exceptions;
import com.crud_jsf.managedBeans.messagesMB.MessagesStruct;
import com.crud_jsf.managedBeans.services.GameService;
import com.crud_jsf.managedBeans.services.PlataformaService;
import com.crud_jsf.model.GamesModel;
import com.crud_jsf.model.PlataformaModel;



@Named(value="gameMB")
@ViewScoped
public class GamesMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GamesModel game;
	
	@Inject
	private GameService gameService;
	
	private List<String> plataformas = null;
	
	private List<GamesModel> gamesList;
	
	private List<String> consoles;
	
	@Inject
	private PlataformaService plataformaService;	
	
	private List<PlataformaModel> plataforms;
	
	@Inject
	private PlataformaModel plataforma; 
	
	private String nomePlataforma;
	
	private String findString;
	
	
	
	@PostConstruct
	public void load() {
		gamesList = gameService.findAll();
		plataforms = plataformaService.findAll();
	
		
	}
	
	public void adicionar() {
	
		System.out.println(plataformas);
		try {
		
		  System.out.println("esse é um teste "+game.getPlataformas());
			gameService.save(game);
			game = new GamesModel();	
			load();
			MessagesStruct.info("Game cadastrado com sucesso!");
			
		} catch (Exceptions e) {
			MessagesStruct.warn(e.getMessage());
		}
		
		
	}
	
	public void remove() {
		try {
			gameService.delete(game);
			MessagesStruct.info(game.getNomeGame() + " foi removido com sucesso!");
			load();
			
		} catch (Exceptions e) {
			MessagesStruct.warn(e.getMessage());
		}
		
	}
	
	
	public void buscar(){
		System.out.println("buscando por " + findString);
	    gamesList =  gameService.search(findString);
	
	}
	
	public void adicionarPlataforma() {
		
		 PlataformaModel plataformaModel = new PlataformaModel();
			plataformaModel.setNomePlataforma(nomePlataforma);
			plataformaModel.setGames(game);
	        game.getPlataformas().add(plataformaModel);
	        
	        setNomePlataforma("");	
	}
	
	public void excluirPlataforma(PlataformaModel plataformaModel) {
		game.getPlataformas().remove(plataformaModel);
		plataformaService.delete(plataformaModel);
	}
	
	
	
	public String getFindString() {
		return findString;
	}

	public void setFindString(String findString) {
		this.findString = findString;
	}

	public GamesModel getGame() {
		return game;
	}

	public void setGame(GamesModel game) {
		this.game = game;
	}

	public List<GamesModel> getGamesList() {
		return gamesList;
	}

	public void setGamesList(List<GamesModel> gamesList) {
		this.gamesList = gamesList;
	}

	public List<String> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<String> plataformas) {
		this.plataformas = plataformas;
	}

	public List<PlataformaModel> getPlataforms() {
		return plataforms;
	}

	public void setPlataforms(List<PlataformaModel> plataforms) {
		this.plataforms = plataforms;
	}

	public PlataformaModel getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(PlataformaModel plataforma) {
		this.plataforma = plataforma;
	}

	public String getNomePlataforma() {
		return nomePlataforma;
	}

	public void setNomePlataforma(String nomePlataforma) {
		this.nomePlataforma = nomePlataforma;
	}

	public List<String> getConsoles() {
		return consoles;
	}

	public void setConsoles(List<String> consoles) {
		this.consoles = consoles;
	}

	

	

	

	
}
