package br.com.vieira.venda.service;

import java.util.List;

import br.com.vieira.venda.model.Venda;

public interface VendaService {
	
	public Venda adicionarVenda(Venda venda) throws Exception;

	public Number deletarVenda(Long cod) throws Exception;

	public Number editarVenda(Venda venda) throws Exception;

	public Venda buscarPorCod(Long cod) throws Exception;

	public List<Venda> listarTodos() throws Exception;

	public List<Venda> listarPorVenda(String venda) throws Exception;

}
