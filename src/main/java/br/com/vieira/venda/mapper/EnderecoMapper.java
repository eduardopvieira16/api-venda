package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Endereco;

public class EnderecoMapper implements RowMapper<Endereco> {

	@Override
	public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
		Endereco endereco = new Endereco();

		endereco.setId(rs.getLong("IDENDERECO"));
		endereco.setEndereco(rs.getString("ENDERECO"));
		endereco.setCep(rs.getString("CEP"));
		endereco.setCidade(rs.getLong("IDCIDADE_PK"), rs.getString("CIDADE"));
		endereco.setBairro(rs.getLong("IDBAIRRO_PK"), rs.getString("BAIRRO"));
		endereco.setEstado(rs.getLong("IDESTADO_PK"), rs.getString("ESTADO"));

		return endereco;
	}
}
