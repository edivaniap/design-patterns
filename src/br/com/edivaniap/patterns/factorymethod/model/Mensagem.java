package br.com.edivaniap.patterns.factorymethod.model;

public abstract class Mensagem {

	public abstract String getConteudo();
	
	public void registrarEnvio() {
        // Adiciona log ou marca a data/hora de envio
	}
	
	public void criptografar() {
		// Adiciona alguma criptografia ao conteudo da mensagem
	}

}
