package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.PessoaMapper;
import br.com.vieira.venda.model.Pessoa;

@Repository
@PropertySource("classpath:sql/pessoa.xml")
public class PessoaDaoImpl implements PessoaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.pessoa}")
	private String SQL_UPDATE_PESSOA;
	@Value("${sql.delete.pessoa}")
	private String SQL_DELETE_PESSOA;
	@Value("${sql.select.pessoa}")
	private String SQL_SELECT_PESSOA;
	@Value("${sql.select.cod.pessoa}")
	private String SQL_SELECT_COD_PESSOA;
	@Value("${sql.select.name.pessoa}")
	private String SQL_SELECT_NAME_PESSOA;

	public PessoaDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Pessoa adicionarPessoa(Pessoa pessoa) throws Exception {
		SimpleJdbcInsert addPessoa = new SimpleJdbcInsert(jdbcTemplate).withTableName("PESSOAS")
				.usingColumns("PRIMEIRONOME", "SEGUNDONOME", "CPF", "EMAIL", "COMPLMENTO", "NUMERO","IDENDERECO_PK")
				.usingGeneratedKeyColumns("IDPESSOA");

		Number chave = addPessoa.executeAndReturnKey(new BeanPropertySqlParameterSource(pessoa));

		pessoa.setId(chave.longValue());
		return pessoa;
	}

	@Override
	public Number deletarPessoa(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_PESSOA, cod);
	}

	@Override
	public Number editarPessoa(Pessoa pessoa) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_PESSOA, pessoa.getPrimeiroNome(), pessoa.getSegundoNome(),
				pessoa.getCpf(), pessoa.getEmail(), pessoa.getComplemento(), pessoa.getNumero(), pessoa.getId());
	}

	@Override
	public Pessoa buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_PESSOA, new PessoaMapper(), cod);
	}

	@Override
	public List<Pessoa> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_PESSOA, new PessoaMapper());
	}

	@Override
	public List<Pessoa> listarPorPessoa(String pessoa) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_PESSOA, new PessoaMapper(), pessoa);
	}

}
