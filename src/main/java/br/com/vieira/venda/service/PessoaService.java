package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Pessoa;

public interface PessoaService {
	
	public Pessoa adicionarPessoa(Pessoa pessoa) throws Exception;

	public Number deletarPessoa(Long cod) throws Exception;

	public Number editarPessoa(Pessoa pessoa) throws Exception;

	public Pessoa buscarPorCod(Long cod) throws Exception;

	public List<Pessoa> listarTodos() throws Exception;

	public List<Pessoa> listarPorPessoa(String pessoa) throws Exception;

}
