package br.com.vieira.venda.dao;

import java.util.List;

import br.com.vieira.venda.model.Pessoa;

public interface PessoaDao {
	
	public Pessoa adicionarPessoa(Pessoa pessoa) throws Exception;

	public Number deletarPessoa(Long cod) throws Exception;

	public Number editarPessoa(Pessoa pessoa) throws Exception;

	public Pessoa buscarPorCod(Long cod) throws Exception;

	public List<Pessoa> listarTodos() throws Exception;

	public List<Pessoa> listarPorPessoa(String pessoa) throws Exception;
	
}
