package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.CidadeMapper;
import br.com.vieira.venda.model.Cidade;

@Repository
@PropertySource("classpath:sql/cidade.xml")
public class CidadeDaoImpl implements CidadeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * @Value("${sql.insert.cidade}") private String SQL_INSERT_CIDADE;
	 */
	@Value("${sql.update.cidade}")
	private String SQL_UPDATE_CIDADE;
	@Value("${sql.delete.cidade}")
	private String SQL_DELETE_CIDADE;
	@Value("${sql.select.cidade}")
	private String SQL_SELECT_CIDADE;
	@Value("${sql.select.cod.cidade}")
	private String SQL_SELECT_COD_CIDADE;
	@Value("${sql.select.name.cidade}")
	private String SQL_SELECT_NAME_CIDADE;

	public CidadeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Cidade adicionarCidade(Cidade cidade) throws Exception {
		SimpleJdbcInsert addCidade = new SimpleJdbcInsert(jdbcTemplate).withTableName("CIDADES").usingColumns("CIDADE")
				.usingGeneratedKeyColumns("IDCIDADE");

		Number chave = addCidade.executeAndReturnKey(new BeanPropertySqlParameterSource(cidade));

		cidade.setId(chave.longValue());
		return cidade;
	}

	@Override
	public Number deletarCidade(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_CIDADE, cod);
	}

	@Override
	public Number editarCidade(Cidade cidade) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_CIDADE, cidade.getCidade(), cidade.getId());
	}

	@Override
	public Cidade buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_CIDADE, new CidadeMapper(), cod);
	}

	@Override
	public List<Cidade> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_CIDADE, new CidadeMapper());
	}

	@Override
	public List<Cidade> listarPorCidade(String cidade) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_CIDADE, new CidadeMapper(), cidade);
	}

}
