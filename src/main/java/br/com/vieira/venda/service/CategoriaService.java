package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Categoria;

public interface CategoriaService {
	
	public Categoria adicionarCategoria(Categoria categoria) throws Exception;

	public Number deletarCategoria(Long cod) throws Exception;

	public Number editarCategoria(Categoria categoria) throws Exception;

	public Categoria buscarPorCod(Long cod) throws Exception;

	public List<Categoria> listarTodos() throws Exception;

	public List<Categoria> listarPorCategoria(String categoria) throws Exception;

}
