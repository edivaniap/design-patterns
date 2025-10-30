package br.com.edivaniap.patterns.factorymethod;

import br.com.edivaniap.patterns.factorymethod.model.Mensagem;
import br.com.edivaniap.patterns.factorymethod.model.MensagemTexto;

/**
 * Fornece implementação para criação de mensagens de texto.
 */

public class MensagemTextoCreator extends MensagemCreator {

	@Override
	public Mensagem criarMensagem() {
		return new MensagemTexto();
	}

}
