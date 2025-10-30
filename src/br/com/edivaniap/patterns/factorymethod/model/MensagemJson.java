package br.com.edivaniap.patterns.factorymethod.model;

public class MensagemJson extends Mensagem {

	@Override
	public String getConteudo() {
		return "{\"json\":[]}";
	}

}
