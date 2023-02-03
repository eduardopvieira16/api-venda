package br.com.vieira.venda.model;

public class Bairro {

	private Long id;
	private String bairro;

	public Bairro() {
	}

	public Bairro(Long id, String bairro) {
		this.id = id;
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Bairro [id=" + id + ", bairro=" + bairro + "]";
	}

}
