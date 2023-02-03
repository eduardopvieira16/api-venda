package br.com.vieira.venda.model;

public class Cidade {

	private Long id;
	private String cidade;

	public Cidade() {

	}

	public Cidade(Long id, String cidade) {
		this.id = id;
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", cidade=" + cidade + "]";
	}
}
