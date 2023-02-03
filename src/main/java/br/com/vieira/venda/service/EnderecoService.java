package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Endereco;

public interface EnderecoService {

	public Endereco adicionarEndereco(Endereco endereco) throws Exception;

	public Number deletarEndereco(Long cod) throws Exception;

	public Number editarEndereco(Endereco endereco) throws Exception;

	public Endereco buscarPorCod(Long cod) throws Exception;

	public List<Endereco> listarTodos() throws Exception;

	public List<Endereco> listarPorEndereco(String endereco) throws Exception;

}
