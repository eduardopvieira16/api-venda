package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.UnidadeDaoImpl;
import br.com.vieira.venda.model.Unidade;

@Service
@Transactional
public class UnidadeServiceImpl implements UnidadeService {

	@Autowired
	private UnidadeDaoImpl unidadeDao;

	@Override
	public Unidade adicionarUnidade(Unidade unidade) throws Exception {
		return unidadeDao.adicionarUnidade(unidade);
	}

	@Override
	public Number deletarUnidade(Long cod) throws Exception {
		return unidadeDao.deletarUnidade(cod);
	}

	@Override
	public Number editarUnidade(Unidade unidade) throws Exception {
		return unidadeDao.editarUnidade(unidade);
	}

	@Override
	public Unidade buscarPorCod(Long cod) throws Exception {
		return unidadeDao.buscarPorCod(cod);
	}

	@Override
	public List<Unidade> listarTodos() throws Exception {
		return unidadeDao.listarTodos();
	}

	@Override
	public List<Unidade> listarPorUnidade(String unidade) throws Exception {
		return unidadeDao.listarPorUnidade(unidade);
	}

}
