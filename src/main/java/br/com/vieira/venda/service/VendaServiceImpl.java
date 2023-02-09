package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.VendaDaoImpl;
import br.com.vieira.venda.model.Venda;

@Service
@Transactional
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaDaoImpl vendaDao;

	@Override
	public Venda adicionarVenda(Venda venda) throws Exception {
		return vendaDao.adicionarVenda(venda);
	}

	@Override
	public Number deletarVenda(Long cod) throws Exception {
		return vendaDao.deletarVenda(cod);
	}

	@Override
	public Number editarVenda(Venda venda) throws Exception {
		return vendaDao.editarVenda(venda);
	}

	@Override
	public Venda buscarPorCod(Long cod) throws Exception {
		return vendaDao.buscarPorCod(cod);
	}

	@Override
	public List<Venda> listarTodos() throws Exception {
		return vendaDao.listarTodos();
	}

	@Override
	public List<Venda> listarPorVenda(String venda) throws Exception {
		return vendaDao.listarPorVenda(venda);
	}

}
