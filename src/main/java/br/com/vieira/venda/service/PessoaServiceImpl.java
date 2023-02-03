package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.PessoaDaoImpl;
import br.com.vieira.venda.model.Pessoa;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDaoImpl pessoaDao;

	@Override
	public Pessoa adicionarPessoa(Pessoa pessoa) throws Exception {
		return pessoaDao.adicionarPessoa(pessoa);
	}

	@Override
	public Number deletarPessoa(Long cod) throws Exception {
		return pessoaDao.deletarPessoa(cod);
	}

	@Override
	public Number editarPessoa(Pessoa pessoa) throws Exception {
		return pessoaDao.editarPessoa(pessoa);
	}

	@Override
	public Pessoa buscarPorCod(Long cod) throws Exception {
		return pessoaDao.buscarPorCod(cod);
	}

	@Override
	public List<Pessoa> listarTodos() throws Exception {
		return pessoaDao.listarTodos();
	}

	@Override
	public List<Pessoa> listarPorPessoa(String pessoa) throws Exception {
		return pessoaDao.listarPorPessoa(pessoa);
	}

}
