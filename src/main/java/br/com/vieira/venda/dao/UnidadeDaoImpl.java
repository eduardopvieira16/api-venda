package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.UnidadeMapper;
import br.com.vieira.venda.model.Unidade;

@Repository
@PropertySource("classpath:sql/unidade.xml")
public class UnidadeDaoImpl implements UnidadeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.unidade}")
	private String SQL_UPDATE_UNIDADE;
	@Value("${sql.delete.unidade}")
	private String SQL_DELETE_UNIDADE;
	@Value("${sql.select.unidade}")
	private String SQL_SELECT_UNIDADE;
	@Value("${sql.select.cod.unidade}")
	private String SQL_SELECT_COD_UNIDADE;
	@Value("${sql.select.name.unidade}")
	private String SQL_SELECT_NAME_UNIDADE;

	public UnidadeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Unidade adicionarUnidade(Unidade unidade) throws Exception {
		SimpleJdbcInsert addUnidade = new SimpleJdbcInsert(jdbcTemplate).withTableName("UNDIADES")
				.usingColumns("UNDIADE", "ABREVIACAO").usingGeneratedKeyColumns("IDUNDIADE");

		Number chave = addUnidade.executeAndReturnKey(new BeanPropertySqlParameterSource(unidade));

		unidade.setId(chave.longValue());
		return unidade;
	}

	@Override
	public Number deletarUnidade(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_UNIDADE, cod);
	}

	@Override
	public Number editarUnidade(Unidade unidade) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_UNIDADE, unidade.getUnidade(), unidade.getId());
	}

	@Override
	public Unidade buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_UNIDADE, new UnidadeMapper(), cod);
	}

	@Override
	public List<Unidade> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_UNIDADE, new UnidadeMapper());
	}

	@Override
	public List<Unidade> listarPorUnidade(String unidade) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_UNIDADE, new UnidadeMapper(), unidade);
	}

}
