package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.CategoriaMapper;
import br.com.vieira.venda.model.Categoria;

@Repository
@PropertySource("classpath:sql/categoria.xml")
public class CategoriaDaoImpl implements CategoriaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.categoria}")
	private String SQL_UPDATE_CATEGORIA;
	@Value("${sql.delete.categoria}")
	private String SQL_DELETE_CATEGORIA;
	@Value("${sql.select.categoria}")
	private String SQL_SELECT_CATEGORIA;
	@Value("${sql.select.cod.categoria}")
	private String SQL_SELECT_COD_CATEGORIA;
	@Value("${sql.select.name.categoria}")
	private String SQL_SELECT_NAME_CATEGORIA;

	public CategoriaDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Categoria adicionarCategoria(Categoria categoria) throws Exception {
		SimpleJdbcInsert addCategoria = new SimpleJdbcInsert(jdbcTemplate).withTableName("CATEGORIAS").usingColumns("CATEGORIA")
				.usingGeneratedKeyColumns("IDCATEGORIA");

		Number chave = addCategoria.executeAndReturnKey(new BeanPropertySqlParameterSource(categoria));

		categoria.setId(chave.longValue());
		return categoria;
	}

	@Override
	public Number deletarCategoria(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_CATEGORIA, cod);
	}

	@Override
	public Number editarCategoria(Categoria categoria) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_CATEGORIA, categoria.getCategoria(), categoria.getId());
	}

	@Override
	public Categoria buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_CATEGORIA, new CategoriaMapper(), cod);
	}

	@Override
	public List<Categoria> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_CATEGORIA, new CategoriaMapper());
	}

	@Override
	public List<Categoria> listarPorCategoria(String categoria) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_CATEGORIA, new CategoriaMapper(), categoria);
	}

}
