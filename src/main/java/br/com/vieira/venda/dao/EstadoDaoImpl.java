package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.EstadoMapper;
import br.com.vieira.venda.model.Estado;

@Repository
@PropertySource("classpath:sql/estado.xml")
public class EstadoDaoImpl implements EstadoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.estado}")
	private String SQL_UPDATE_ESTADO;
	@Value("${sql.delete.estado}")
	private String SQL_DELETE_ESTADO;
	@Value("${sql.select.estado}")
	private String SQL_SELECT_ESTADO;
	@Value("${sql.select.cod.estado}")
	private String SQL_SELECT_COD_ESTADO;
	@Value("${sql.select.name.estado}")
	private String SQL_SELECT_NAME_ESTADO;

	public EstadoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Estado adicionarEstado(Estado estado) throws Exception {
		SimpleJdbcInsert addEstado = new SimpleJdbcInsert(jdbcTemplate).withTableName("ESTADOS").usingColumns("ESTADO")
				.usingGeneratedKeyColumns("IDESTADO");

		Number chave = addEstado.executeAndReturnKey(new BeanPropertySqlParameterSource(estado));

		estado.setId(chave.longValue());
		return estado;
	}

	@Override
	public Number deletarEstado(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_ESTADO, cod);
	}

	@Override
	public Number editarEstado(Estado estado) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_ESTADO, estado.getEstado(), estado.getId());
	}

	@Override
	public Estado buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_ESTADO, new EstadoMapper(), cod);
	}

	@Override
	public List<Estado> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_ESTADO, new EstadoMapper());
	}

	@Override
	public List<Estado> listarPorEstado(String estado) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_ESTADO, new EstadoMapper(), estado);
	}

}
