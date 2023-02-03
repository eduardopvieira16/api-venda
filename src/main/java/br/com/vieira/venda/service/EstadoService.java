package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Estado;

public interface EstadoService {
	
	public Estado adicionarEstado(Estado estado) throws Exception;

	public Number deletarEstado(Long cod) throws Exception;

	public Number editarEstado(Estado estado) throws Exception;

	public Estado buscarPorCod(Long cod) throws Exception;

	public List<Estado> listarTodos() throws Exception;

	public List<Estado> listarPorEstado(String estado) throws Exception;

}
