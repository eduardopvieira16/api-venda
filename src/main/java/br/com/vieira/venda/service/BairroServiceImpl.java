package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.BairroDaoImpl;
import br.com.vieira.venda.model.Bairro;

@Service
@Transactional
public class BairroServiceImpl implements BairroService {

	@Autowired
	private BairroDaoImpl bairroDao;

	@Override
	public Bairro adicionarBairro(Bairro bairro) throws Exception {
		return bairroDao.adicionarBairro(bairro);
	}

	@Override
	public Number deletarBairro(Long cod) throws Exception {
		return bairroDao.deletarBairro(cod);
	}

	@Override
	public Number editarBairro(Bairro bairro) throws Exception {
		return bairroDao.editarBairro(bairro);
	}

	@Override
	public Bairro buscarPorCod(Long cod) throws Exception {
		return bairroDao.buscarPorCod(cod);
	}

	@Override
	public List<Bairro> listarTodos() throws Exception {
		return bairroDao.listarTodos();
	}

	@Override
	public List<Bairro> listarPorBairro(String bairro) throws Exception {
		return bairroDao.listarPorBairro(bairro);
	}

}
