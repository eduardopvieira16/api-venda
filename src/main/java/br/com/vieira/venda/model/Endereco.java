package br.com.vieira.venda.model;

public class Endereco {

	private Long id;
	private String endereco;
	private String cep;
	private Cidade cidade;
	private Estado estado;
	private Bairro bairro;

	public Endereco() {

	}

	public Endereco(Long id, String endereco, String cep, Cidade cidade, Estado estado, Bairro bairro) {
		this.id = id;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", endereco=" + endereco + ", cep=" + cep + ", cidade=" + cidade + ", estado="
				+ estado + ", bairro=" + bairro + "]";
	}
}
