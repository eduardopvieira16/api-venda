package br.com.vieira.venda.dao;

import java.util.List;

import br.com.vieira.venda.model.Produto;

public interface ProdutoDao {

	public Produto adicionarProduto(Produto produto) throws Exception;

	public Number deletarProduto(Long cod) throws Exception;

	public Number editarProduto(Produto Produto) throws Exception;

	public Produto buscarPorCod(Long cod) throws Exception;

	public List<Produto> listarTodos() throws Exception;

	public List<Produto> listarPorProduto(String Produto) throws Exception;

}
