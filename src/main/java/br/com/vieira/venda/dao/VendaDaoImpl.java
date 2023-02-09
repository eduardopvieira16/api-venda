package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.VendaMapper;
import br.com.vieira.venda.model.Venda;

@Repository
@PropertySource("classpath:sql/venda.xml")
public class VendaDaoImpl implements VendaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.venda}")
	private String SQL_UPDATE_VENDA;
	@Value("${sql.delete.venda}")
	private String SQL_DELETE_VENDA;
	@Value("${sql.select.venda}")
	private String SQL_SELECT_VENDA;
	@Value("${sql.select.cod.venda}")
	private String SQL_SELECT_COD_VENDA;
	@Value("${sql.select.name.venda}")
	private String SQL_SELECT_NAME_VENDA;

	public VendaDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Venda adicionarVenda(Venda venda) throws Exception {
		SimpleJdbcInsert addVenda = new SimpleJdbcInsert(jdbcTemplate).withTableName("VENDAS")
				.usingColumns("IDPESSOA_PK", "IDPRODUTO_PK", "PRECO_TOTAL", "DESCONTO", "FORMAPAGAMENTO", "PAGAMENTO",
						"DATAPAGAMENTO", "TROCO")
				.usingGeneratedKeyColumns("IDVENDA");

		Number chave = addVenda.executeAndReturnKey(new BeanPropertySqlParameterSource(venda));

		venda.setId(chave.longValue());
		return venda;
	}

	@Override
	public Number deletarVenda(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_VENDA, cod);
	}

	@Override
	public Number editarVenda(Venda venda) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_VENDA, venda.getPessoa(), venda.getProduto(), venda.getPrecoTotal(),
				venda.getDesconto(), venda.getFormaPagamento(), venda.getPagamento(), venda.getDataPagamento(),
				venda.getTroco(), venda.getId());
	}

	@Override
	public Venda buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_VENDA, new VendaMapper(), cod);
	}

	@Override
	public List<Venda> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_VENDA, new VendaMapper());
	}

	@Override
	public List<Venda> listarPorVenda(String Venda) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_VENDA, new VendaMapper(), Venda);
	}

}
