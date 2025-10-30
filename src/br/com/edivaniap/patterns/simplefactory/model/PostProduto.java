package br.com.edivaniap.patterns.simplefactory.model;

/**
 * Especialização de Post para Produto.
 */

public class PostProduto extends Post {

	private String linkImagem;
	
	private Double valor;

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
