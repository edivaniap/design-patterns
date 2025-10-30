package br.com.edivaniap.patterns.simplefactory;

import br.com.edivaniap.patterns.simplefactory.model.Post;

public class Aplicacao {

	public static void main(String[] args) {
        Post post1 = PostFactory.createPost("noticia");
        Post post2 = PostFactory.createPost("produto");
        Post post3 = PostFactory.createPost("blog");
        System.out.println(post1);
        System.out.println(post2);
        System.out.println(post3);

        try {
            Post post4 = PostFactory.createPost("instagram");
            System.out.println(post4);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
