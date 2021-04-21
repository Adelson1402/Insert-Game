package com.crud_jsf.managedBeans.Queries;

public class Queries {
	
	private String searchQuery ;//= "SELECT m FROM "+this.model+" m WHERE LOWER(m."+this.property+") like '%"+this.param+"%' OR m."+this.property+" like '%"+this.param+"%'";
	
	
	public String search(String model, String property, String param) {
		/*
		 * É necessário passar como parametro a Classe Model/Entity em -model- o nome do campo ou coluna em -property- e o parametro
		 * 
		 * que será pesquisado -param-, no caso do -param- ele pode vir direto do ManagedBean em formato String, para assim o mesmo
		 * 
		 * ser concatenado e a Query ser formada
		 */
		this.searchQuery ="SELECT m FROM "+model+" m WHERE LOWER(m."+property+") like '%"+param+"%' OR m."+property+" like '%"+param+"%'" ;
		return searchQuery;
	}
	
	
	
	
}
