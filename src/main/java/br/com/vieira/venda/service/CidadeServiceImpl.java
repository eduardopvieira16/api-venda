package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.CidadeDaoImpl;
import br.com.vieira.venda.model.Cidade;

@Service
@Transactional
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeDaoImpl cidadeDao;

	@Override
	public Cidade adicionarCidade(Cidade cidade) throws Exception {
		return cidadeDao.adicionarCidade(cidade);
	}

	@Override
	public Number deletarCidade(Long cod) throws Exception {
		return cidadeDao.deletarCidade(cod);
	}

	@Override
	public Number editarCidade(Cidade cidade) throws Exception {
		return cidadeDao.editarCidade(cidade);
	}

	@Override
	public Cidade buscarPorCod(Long cod) throws Exception {
		return cidadeDao.buscarPorCod(cod);
	}

	@Override
	public List<Cidade> listarTodos() throws Exception {
		return cidadeDao.listarTodos();
	}

	@Override
	public List<Cidade> listarPorCidade(String cidade) throws Exception {
		return cidadeDao.listarPorCidade(cidade);
	}

}
