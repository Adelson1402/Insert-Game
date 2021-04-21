package com.crud_jsf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crud_jsf.managedBeans.repository.GameRepository;

@Entity
@Table(name="games_tb")
public class GamesModel implements Serializable, GameRepository {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nomeGame;
	
	private String genero;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="games", fetch=FetchType.EAGER)
	private List<PlataformaModel> plataformas = new ArrayList<PlataformaModel>();
	
	
	private String desenvolvedora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeGame() {
		return nomeGame;
	}

	public void setNomeGame(String nomeGame) {
		this.nomeGame = nomeGame;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
 

	public List<PlataformaModel> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<PlataformaModel> plataformas) {
		this.plataformas = plataformas;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
	
	

}
