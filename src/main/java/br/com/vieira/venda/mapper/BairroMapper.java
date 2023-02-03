package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Bairro;

public class BairroMapper implements RowMapper<Bairro> {

	@Override
	public Bairro mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Bairro(rs.getLong("IDBAIRRO"), rs.getString("BAIRRO"));
	}

}
