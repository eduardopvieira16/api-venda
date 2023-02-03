package br.com.vieira.venda.model;

public class Estado {

	private Long id;
	private String estado;

	public Estado() {

	}

	public Estado(Long id, String estado) {
		this.id = id;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", estado=" + estado + "]";
	}
}
