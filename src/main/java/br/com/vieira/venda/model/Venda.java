package br.com.vieira.venda.model;

import java.util.Date;

public class Venda {

	private Long id;
	private Float precoTotal;
	private Float desconto;
	private String formaPagamento;
	private Float pagamento;
	private Date dataPagamento;
	private Float troco;
	private Pessoa pessoa;
	private Produto produto;

	public Venda() {

	}

	public Venda(Long id, Float precoTotal, Float desconto, String formaPagamento, Float pagamento, Date dataPagamento,
			Float troco, Pessoa pessoa, Produto produto) {
		super();
		this.id = id;
		this.precoTotal = precoTotal;
		this.desconto = desconto;
		this.formaPagamento = formaPagamento;
		this.pagamento = pagamento;
		this.dataPagamento = dataPagamento;
		this.troco = troco;
		this.pessoa = pessoa;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Float getDesconto() {
		return desconto;
	}

	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Float getPagamento() {
		return pagamento;
	}

	public void setPagamento(Float pagamento) {
		this.pagamento = pagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Float getTroco() {
		return troco;
	}

	public void setTroco(Float troco) {
		this.troco = troco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Long id, String primeiroNome, String segundoNome, String cpf, String email,
			String complemento, String numero, Long idEndereco, String endereco, String cep, Long idCidade,
			String cidade, Long idEstado, String estado, Long idBairro, String bairro) {
		Pessoa pess = new Pessoa();

		pess.setId(id);
		pess.setPrimeiroNome(primeiroNome);
		pess.setSegundoNome(segundoNome);
		pess.setCpf(cpf);
		pess.setEmail(email);
		pess.setComplemento(complemento);
		pess.setNumero(numero);
		pess.setEndereco(idEndereco, endereco, cep, idCidade, cidade, idEstado, estado, idBairro, bairro);

		this.pessoa = pess;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Long id, String produto, String descricao, Float precoUnitario, String ncm, Long idUnidade,
			String unidade, String abreviacao, Long idCategoria, String categoria) {
		Produto prod = new Produto();
		prod.setId(id);
		prod.setProduto(produto);
		prod.setDescricao(descricao);
		prod.setPrecoUnitario(precoUnitario);
		prod.setNcm(ncm);
		prod.setUnidade(idCategoria, unidade, abreviacao);
		prod.setCategoria(idCategoria, categoria);

		this.produto = prod;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", precoTotal=" + precoTotal + ", desconto=" + desconto + ", formaPagamento="
				+ formaPagamento + ", pagamento=" + pagamento + ", dataPagamento=" + dataPagamento + ", troco=" + troco
				+ ", pessoa=" + pessoa + ", produto=" + produto + "]";
	}
}
