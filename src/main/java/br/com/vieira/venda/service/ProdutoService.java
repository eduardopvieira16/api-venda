package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Produto;

public interface ProdutoService {
	
	public Produto adicionarProduto(Produto produto) throws Exception;

	public Number deletarProduto(Long cod) throws Exception;

	public Number editarProduto(Produto produto) throws Exception;

	public Produto buscarPorCod(Long cod) throws Exception;

	public List<Produto> listarTodos() throws Exception;

	public List<Produto> listarPorProduto(String produto) throws Exception;

}
