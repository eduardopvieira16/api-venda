package br.com.vieira.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.vieira.venda.mapper.ProdutoMapper;
import br.com.vieira.venda.model.Produto;

@Repository
@PropertySource("classpath:sql/produto.xml")
public class ProdutoDaoImpl implements ProdutoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.update.produto}")
	private String SQL_UPDATE_PRODUTO;
	@Value("${sql.delete.produto}")
	private String SQL_DELETE_PRODUTO;
	@Value("${sql.select.produto}")
	private String SQL_SELECT_PRODUTO;
	@Value("${sql.select.cod.produto}")
	private String SQL_SELECT_COD_PRODUTO;
	@Value("${sql.select.name.produto}")
	private String SQL_SELECT_NAME_PRODUTO;

	public ProdutoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Produto adicionarProduto(Produto produto) throws Exception {
		SimpleJdbcInsert addProduto = new SimpleJdbcInsert(jdbcTemplate).withTableName("PRODUTOS")
				.usingColumns("IDUNIDADE_PK", "IDCATEGORIA_PK", "PRODUTO", "DESCRICAO", "PRECO_UNITARIO", "NCM")
				.usingGeneratedKeyColumns("IDPRODUTO");

		Number chave = addProduto.executeAndReturnKey(new BeanPropertySqlParameterSource(produto));

		produto.setId(chave.longValue());
		return produto;
	}

	@Override
	public Number deletarProduto(Long cod) throws Exception {
		return jdbcTemplate.update(SQL_DELETE_PRODUTO, cod);
	}

	@Override
	public Number editarProduto(Produto produto) throws Exception {
		return jdbcTemplate.update(SQL_UPDATE_PRODUTO, produto.getUnidade(), produto.getCategoria(),
				produto.getProduto(), produto.getDescricao(), produto.getPrecoUnitario(), produto.getNcm(),
				produto.getId());
	}

	@Override
	public Produto buscarPorCod(Long cod) throws Exception {
		return jdbcTemplate.queryForObject(SQL_SELECT_COD_PRODUTO, new ProdutoMapper(), cod);
	}

	@Override
	public List<Produto> listarTodos() throws Exception {
		return jdbcTemplate.query(SQL_SELECT_PRODUTO, new ProdutoMapper());
	}

	@Override
	public List<Produto> listarPorProduto(String produto) throws Exception {
		return jdbcTemplate.query(SQL_SELECT_NAME_PRODUTO, new ProdutoMapper(), produto);
	}

}
