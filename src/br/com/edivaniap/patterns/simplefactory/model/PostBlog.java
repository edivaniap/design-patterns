package br.com.edivaniap.patterns.simplefactory.model;

/**
 * Especialização de Post para Blog.
 */

public class PostBlog extends Post {

	private String autor;
	
	private String[] tags;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

}
