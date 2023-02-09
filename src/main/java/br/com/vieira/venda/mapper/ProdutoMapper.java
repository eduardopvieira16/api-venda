package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Produto;

public class ProdutoMapper implements RowMapper<Produto> {

	@Override
	public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produto produto = new Produto();

		produto.setId(rs.getLong("IDPRODUTO"));
		produto.setProduto(rs.getString("PRODUTO"));
		produto.setPrecoUnitario(rs.getFloat("PRECO_UNITARIO"));
		produto.setNcm(rs.getString("NCM"));

		/*
		 * CATEGORIA E UNIDADE - FK
		 */

		return produto;
	}
}
