package br.com.vieira.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vieira.venda.dao.CategoriaDaoImpl;
import br.com.vieira.venda.model.Categoria;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDaoImpl categoriaDao;

	@Override
	public Categoria adicionarCategoria(Categoria categoria) throws Exception {
		return categoriaDao.adicionarCategoria(categoria);
	}

	@Override
	public Number deletarCategoria(Long cod) throws Exception {
		return categoriaDao.deletarCategoria(cod);
	}

	@Override
	public Number editarCategoria(Categoria categoria) throws Exception {
		return categoriaDao.editarCategoria(categoria);
	}

	@Override
	public Categoria buscarPorCod(Long cod) throws Exception {
		return categoriaDao.buscarPorCod(cod);
	}

	@Override
	public List<Categoria> listarTodos() throws Exception {
		return categoriaDao.listarTodos();
	}

	@Override
	public List<Categoria> listarPorCategoria(String categoria) throws Exception {
		return categoriaDao.listarPorCategoria(categoria);
	}

}
