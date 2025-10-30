package br.com.edivaniap.patterns.factorymethod;

import br.com.edivaniap.patterns.factorymethod.model.Mensagem;

/**
 * Classe abstrata para o criador da mensagem.
 * O metodo criarMensagem() deve ser implementada por suas subclasses.
 */

public abstract class MensagemCreator {

	public Mensagem getMensagem() {
		Mensagem msg = criarMensagem();

        // Opicional: realizar alguma operação comum após a criação
		msg.criptografar();
		msg.registrarEnvio();
		
		return msg;
	}
	
	//Factory method
	protected abstract Mensagem criarMensagem();

}
