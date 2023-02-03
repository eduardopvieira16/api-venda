package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.EnderecoDaoImpl;
import br.com.vieira.venda.model.Endereco;

@Service
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoDaoImpl enderecoDao;

	@Override
	public Endereco adicionarEndereco(Endereco endereco) throws Exception {
		return enderecoDao.adicionarEndereco(endereco);
	}

	@Override
	public Number deletarEndereco(Long cod) throws Exception {
		return enderecoDao.deletarEndereco(cod);
	}

	@Override
	public Number editarEndereco(Endereco endereco) throws Exception {
		return enderecoDao.editarEndereco(endereco);
	}

	@Override
	public Endereco buscarPorCod(Long cod) throws Exception {
		return enderecoDao.buscarPorCod(cod);
	}

	@Override
	public List<Endereco> listarTodos() throws Exception {
		return enderecoDao.listarTodos();
	}

	@Override
	public List<Endereco> listarPorEndereco(String endereco) throws Exception {
		return enderecoDao.listarPorEndereco(endereco);
	}

}
