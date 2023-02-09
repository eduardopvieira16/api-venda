package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.EnderecoMapper;
import br.com.vieira.venda.model.Endereco;

@Repository
@PropertySource("classpath:sql/endereco.xml")
public class EnderecoDaoImpl implements EnderecoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.endereco}")
	private String SQL_UPDATE_ENDERECO;
	@Value("${sql.delete.endereco}")
	private String SQL_DELETE_ENDERECO;
	@Value("${sql.select.endereco}")
	private String SQL_SELECT_ENDERECO;
	@Value("${sql.select.cod.endereco}")
	private String SQL_SELECT_COD_ENDERECO;
	@Value("${sql.select.name.endereco}")
	private String SQL_SELECT_NAME_ENDERECO;

	public EnderecoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Endereco adicionarEndereco(Endereco endereco) throws Exception {
		SimpleJdbcInsert addEndereco = new SimpleJdbcInsert(jdbcTemplate).withTableName("ENDERECOS")
				.usingColumns("IDCIDADE_PK", "IDBAIRRO_PK", "IDESTADO_PK", "ENDERECO", "CEP")
				.usingGeneratedKeyColumns("IDENDERECO");

		Number chave = addEndereco.executeAndReturnKey(new BeanPropertySqlParameterSource(endereco));

		endereco.setId(chave.longValue());
		return endereco;
	}

	@Override
	public Number deletarEndereco(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_ENDERECO, cod);
	}

	@Override
	public Number editarEndereco(Endereco endereco) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_ENDERECO, endereco.getCidade(), endereco.getBairro(),
				endereco.getEstado(), endereco.getEndereco(), endereco.getCep(), endereco.getId());
	}

	@Override
	public Endereco buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_ENDERECO, new EnderecoMapper(), cod);
	}

	@Override
	public List<Endereco> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_ENDERECO, new EnderecoMapper());
	}

	@Override
	public List<Endereco> listarPorEndereco(String endereco) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_ENDERECO, new EnderecoMapper(), endereco);
	}

}
