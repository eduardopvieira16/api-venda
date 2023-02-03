package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Unidade;

public interface UnidadeService {
	
	public Unidade adicionarUnidade(Unidade unidade) throws Exception;

	public Number deletarUnidade(Long cod) throws Exception;

	public Number editarUnidade(Unidade unidade) throws Exception;

	public Unidade buscarPorCod(Long cod) throws Exception;

	public List<Unidade> listarTodos() throws Exception;

	public List<Unidade> listarPorUnidade(String unidade) throws Exception;

}
