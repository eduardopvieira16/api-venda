package br.com.vieira.venda.dao;

import java.util.List;

import br.com.vieira.venda.model.Bairro;

public interface BairroDao {
	
	public Bairro adicionarBairro(Bairro bairro) throws Exception;

	public Number deletarBairro(Long cod) throws Exception;

	public Number editarBairro(Bairro bairro) throws Exception;

	public Bairro buscarPorCod(Long cod) throws Exception;

	public List<Bairro> listarTodos() throws Exception;

	public List<Bairro> listarPorBairro(String bairro) throws Exception;
	
}
