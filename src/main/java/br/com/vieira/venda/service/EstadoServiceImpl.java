package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.EstadoDaoImpl;
import br.com.vieira.venda.model.Estado;

@Service
@Transactional
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoDaoImpl estadoDao;

	@Override
	public Estado adicionarEstado(Estado estado) throws Exception {
		return estadoDao.adicionarEstado(estado);
	}

	@Override
	public Number deletarEstado(Long cod) throws Exception {
		return estadoDao.deletarEstado(cod);
	}

	@Override
	public Number editarEstado(Estado estado) throws Exception {
		return estadoDao.editarEstado(estado);
	}

	@Override
	public Estado buscarPorCod(Long cod) throws Exception {
		return estadoDao.buscarPorCod(cod);
	}

	@Override
	public List<Estado> listarTodos() throws Exception {
		return estadoDao.listarTodos();
	}

	@Override
	public List<Estado> listarPorEstado(String estado) throws Exception {
		return estadoDao.listarPorEstado(estado);
	}

}
