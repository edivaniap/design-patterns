package br.com.edivaniap.patterns.factorymethod;

import br.com.edivaniap.patterns.factorymethod.model.Mensagem;

public class Aplicacao {

	public static void main(String[] args) {
        printMensagem(new MensagemTextoCreator());
		printMensagem(new MensagemJsonCreator());
	}

	public static void printMensagem(MensagemCreator creator) {
		Mensagem msg = creator.getMensagem();
		System.out.println(msg);
		System.out.println(msg.getConteudo());
	}

}
