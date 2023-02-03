package br.com.vieira.venda.model;

public class Produto {

	private Long id;
	private String produto;
	private String descricao;
	private Float precoUnitario;
	private String ncm;
	private Unidade unidade;
	private Categoria categoria;

	public Produto() {

	}

	public Produto(Long id, String produto, String descricao, Float precoUnitario, String ncm, Unidade unidade,
			Categoria categoria) {
		super();
		this.id = id;
		this.produto = produto;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.ncm = ncm;
		this.unidade = unidade;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", produto=" + produto + ", descricao=" + descricao + ", precoUnitario="
				+ precoUnitario + ", ncm=" + ncm + ", unidade=" + unidade + ", categoria=" + categoria + "]";
	}
}
