package br.com.edivaniap.patterns.simplefactory;

import br.com.edivaniap.patterns.simplefactory.model.Post;
import br.com.edivaniap.patterns.simplefactory.model.PostBlog;
import br.com.edivaniap.patterns.simplefactory.model.PostNoticia;
import br.com.edivaniap.patterns.simplefactory.model.PostProduto;

/**
 * Representa uma fábrica de posts simples.
 */

public class PostFactory {

    private PostFactory() {
        throw new IllegalStateException("Não precisa ser instanciada");
    }

	public static Post createPost(String type) {
		switch(type) {
		case "blog":
				return new PostBlog();
		case "noticia":
				return new PostNoticia();
		case "produto":
				return new PostProduto();
		default:
				throw new IllegalArgumentException("O tipo do post é inválido");
		}
	}

}
