package br.com.vieira.venda.dao;

import java.util.List;

import br.com.vieira.venda.model.Cidade;

public interface CidadeDao {
	
	public Cidade adicionarCidade(Cidade cidade) throws Exception;

	public Number deletarCidade(Long cod) throws Exception;

	public Number editarCidade(Cidade cidade) throws Exception;

	public Cidade buscarPorCod(Long cod) throws Exception;

	public List<Cidade> listarTodos() throws Exception;

	public List<Cidade> listarPorCidade(String cidade) throws Exception;
	
}
