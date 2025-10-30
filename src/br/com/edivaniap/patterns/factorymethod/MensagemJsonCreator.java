package br.com.edivaniap.patterns.factorymethod;


import br.com.edivaniap.patterns.factorymethod.model.Mensagem;
import br.com.edivaniap.patterns.factorymethod.model.MensagemJson;

/**
 * Fornece implementação para criação de mensagens JSON.
 */

public class MensagemJsonCreator extends MensagemCreator {

	@Override
	public Mensagem criarMensagem() {
		return new MensagemJson();
	}

}
