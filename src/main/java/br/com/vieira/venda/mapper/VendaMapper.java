package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Venda;

public class VendaMapper implements RowMapper<Venda> {

	@Override
	public Venda mapRow(ResultSet rs, int rowNum) throws SQLException {
		Venda venda = new Venda();

		venda.setId(rs.getLong("IDVENDA"));
		venda.setPrecoTotal(rs.getFloat("PRECO_TOTAL"));
		venda.setDesconto(rs.getFloat("DESCONTO"));
		venda.setFormaPagamento(rs.getString("FORMAPAGAMENTO"));
		venda.setPagamento(rs.getFloat("PAGAMENTO"));
		venda.setDataPagamento(rs.getDate("DATAPAGAMENTO"));
		venda.setTroco(rs.getFloat("TROCO"));

		/*
		 * PESSOA E PRODUTO - FK
		 */

		return venda;
	}
}
