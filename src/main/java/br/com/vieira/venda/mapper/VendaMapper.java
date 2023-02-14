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
		venda.setPessoa(rs.getLong("IDPESSOA_PK"), rs.getString("PRIMEIRONOME"), rs.getString("SEGUNDONOME"),
				rs.getString("CPF"), rs.getString("EMAIL"), rs.getString("COMPLEMENTO"), rs.getString("NUMERO"),
				rs.getLong("IDENDERECO_PK"), rs.getString("ENDERECO"), rs.getString("CEP"), rs.getLong("IDCIDADE_PK"),
				rs.getString("CIDADE"), rs.getLong("IDESTADO_PK"), rs.getString("ESTADO"), rs.getLong("IDBAIRRO_PK"),
				rs.getString("BAIRRO"));
		venda.setProduto(rs.getLong("IDPRODUTO_PK"), rs.getString("PRODUTO"), rs.getString("DESCRICAO"),
				rs.getFloat("PRECO_UNITARIO"), rs.getString("NCM"), rs.getLong("IDUNIDADE_PK"), rs.getString("UNIDADE"),
				rs.getString("ABREVIACAO"), rs.getLong("IDCATEGORIA_PK"), rs.getString("CATEGORIA"));

		return venda;
	}
}
