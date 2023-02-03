package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Endereco;

public class EnderecoMapper implements RowMapper<Endereco> {

	@Override
	public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
		Endereco endereco = new Endereco();

		endereco.setId(rs.getLong("idEndereco"));
		endereco.setEndereco(rs.getString("ENDERECO"));
		endereco.setCep(rs.getString("CEP"));

		return endereco;
	}
}
