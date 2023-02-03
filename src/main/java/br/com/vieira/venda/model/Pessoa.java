package br.com.vieira.venda.model;

public class Pessoa {

	private Long id;
	private String primeiroNome;
	private String segundoNome;
	private String cpf;
	private String email;
	private String complemento;
	private String numero;
	private Endereco endereco;

	public Pessoa() {

	}

	public Pessoa(Long id, String primeiroNome, String segundoNome, String cpf, String email, String complemento,
			String numero, Long idEndereco, Endereco endereco) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.segundoNome = segundoNome;
		this.cpf = cpf;
		this.email = email;
		this.complemento = complemento;
		this.numero = numero;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", primeiroNome=" + primeiroNome + ", segundoNome=" + segundoNome + ", cpf=" + cpf
				+ ", email=" + email + ", complemento=" + complemento + ", numero=" + numero + ", idEndereco="
				+ endereco + "]";
	}
}
