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

	public void setCidade(Long id, String cidade) {
		Cidade cid = new Cidade();
		cid.setId(id);
		cid.setCidade(cidade);

		this.cidade = cid;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Long id, String estado) {
		Estado uf = new Estado();
		uf.setId(id);
		uf.setEstado(estado);

		this.estado = uf;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Long id, String bairro) {
		Bairro bai = new Bairro();
		bai.setId(id);
		bai.setBairro(bairro);

		this.bairro = bai;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", endereco=" + endereco + ", cep=" + cep + ", cidade=" + cidade + ", estado="
				+ estado + ", bairro=" + bairro + "]";
	}
}
