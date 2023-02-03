package br.com.vieira.venda.model;

public class Unidade {

	private Long id;
	private String unidade;
	private String abreviacao;

	public Unidade() {
	}

	public Unidade(Long id, String unidade, String abreviacao) {
		this.id = id;
		this.unidade = unidade;
		this.abreviacao = abreviacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	@Override
	public String toString() {
		return "Unidade [id=" + id + ", unidade=" + unidade + ", abreviacao=" + abreviacao + "]";
	}
}
