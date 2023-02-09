package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.ProdutoDaoImpl;
import br.com.vieira.venda.model.Produto;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoDaoImpl produtoDao;

	@Override
	public Produto adicionarProduto(Produto produto) throws Exception {
		return produtoDao.adicionarProduto(produto);
	}

	@Override
	public Number deletarProduto(Long cod) throws Exception {
		return produtoDao.deletarProduto(cod);
	}

	@Override
	public Number editarProduto(Produto produto) throws Exception {
		return produtoDao.editarProduto(produto);
	}

	@Override
	public Produto buscarPorCod(Long cod) throws Exception {
		return produtoDao.buscarPorCod(cod);
	}

	@Override
	public List<Produto> listarTodos() throws Exception {
		return produtoDao.listarTodos();
	}

	@Override
	public List<Produto> listarPorProduto(String produto) throws Exception {
		return produtoDao.listarPorProduto(produto);
	}

}
