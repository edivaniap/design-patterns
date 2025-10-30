package br.com.edivaniap.patterns.simplefactory.model;

import java.time.LocalDate;

/**
 * Especialização de Post para Notícia.
 */

public class PostNoticia extends Post {

	private String manchete;
	
	private LocalDate dataNoticia;

	public String getManchete() {
		return manchete;
	}

	public void setManchete(String manchete) {
		this.manchete = manchete;
	}

	public LocalDate getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(LocalDate dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

}
