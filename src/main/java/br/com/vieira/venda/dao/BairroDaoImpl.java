package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.BairroMapper;
import br.com.vieira.venda.model.Bairro;

@Repository
@PropertySource("classpath:sql/bairro.xml")
public class BairroDaoImpl implements BairroDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.bairro}")
	private String SQL_UPDATE_BAIRRO;
	@Value("${sql.delete.bairro}")
	private String SQL_DELETE_BAIRRO;
	@Value("${sql.select.bairro}")
	private String SQL_SELECT_BAIRRO;
	@Value("${sql.select.cod.bairro}")
	private String SQL_SELECT_COD_BAIRRO;
	@Value("${sql.select.name.bairro}")
	private String SQL_SELECT_NAME_BAIRRO;

	public BairroDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Bairro adicionarBairro(Bairro bairro) throws Exception {
		SimpleJdbcInsert addBairro = new SimpleJdbcInsert(jdbcTemplate).withTableName("BAIRROS").usingColumns("BAIRRO")
				.usingGeneratedKeyColumns("IDBAIRRO");

		Number chave = addBairro.executeAndReturnKey(new BeanPropertySqlParameterSource(bairro));

		bairro.setId(chave.longValue());
		return bairro;
	}

	@Override
	public Number deletarBairro(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_BAIRRO, cod);
	}

	@Override
	public Number editarBairro(Bairro bairro) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_BAIRRO, bairro.getBairro(), bairro.getId());
	}

	@Override
	public Bairro buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_BAIRRO, new BairroMapper(), cod);
	}

	@Override
	public List<Bairro> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_BAIRRO, new BairroMapper());
	}

	@Override
	public List<Bairro> listarPorBairro(String bairro) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_BAIRRO, new BairroMapper(), bairro);
	}

}
