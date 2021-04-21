package com.crud_jsf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crud_jsf.managedBeans.repository.GameRepository;


@Entity
@Table(name="plataforma_tb")
public class PlataformaModel implements Serializable, GameRepository {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="plataforma_id")
	private Long id;
	
	private String nomePlataforma;

	@ManyToOne
	@JoinColumn
	private GamesModel games;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePlataforma() {
		return nomePlataforma;
	}

	public void setNomePlataforma(String nomePlataforma) {
		this.nomePlataforma = nomePlataforma;
	}

	public GamesModel getGames() {
		return games;
	}

	public void setGames(GamesModel games) {
		this.games = games;
	}

	
	
	

}
